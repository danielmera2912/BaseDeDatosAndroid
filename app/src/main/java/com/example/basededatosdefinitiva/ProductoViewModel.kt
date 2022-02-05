package com.example.basededatosdefinitiva

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.basededatosdefinitiva.database.Producto
import com.example.basededatosdefinitiva.database.ProductoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductoViewModel (application: Application): AndroidViewModel(application){
    val repository: ProductoRepository
    val allProducto: LiveData<List<Producto>>
    init{
        val dao= ProductoDatabase.getDatabase(application).getProductoDao()
        repository = ProductoRepository(dao)
        allProducto= repository.allProducto
    }
    fun deleteNode (producto: Producto) = viewModelScope.launch (Dispatchers.IO){
        repository.delete(producto)
    }
    fun insertProducto(producto: Producto) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(producto)
    }
}