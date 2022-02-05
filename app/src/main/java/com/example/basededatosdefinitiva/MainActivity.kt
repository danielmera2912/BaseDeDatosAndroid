package com.example.basededatosdefinitiva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basededatosdefinitiva.database.Producto

class MainActivity : AppCompatActivity(), IProductoRVAdapter {
    lateinit var viewModel: ProductoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView= findViewById<RecyclerView> (R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter= ProductoRVAdapter(this,this)
        recyclerView.adapter= adapter

        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)
        viewModel.allProducto.observe(this, Observer{ list ->
            list?.let {
                adapter.updateList(it)
            }
        })


    }
    override fun onItemClicked(producto: Producto){
        viewModel.deleteNode(producto)
    }

    fun submitData(view: android.view.View) {
        val input= findViewById<EditText> (R.id.input)
        val productoText = input.text.toString()
        if(productoText.isNotEmpty()){
            viewModel.insertProducto(Producto(productoText))
        }
    }
}