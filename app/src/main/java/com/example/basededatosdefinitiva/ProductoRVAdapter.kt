package com.example.basededatosdefinitiva

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.basededatosdefinitiva.database.Producto

class ProductoRVAdapter(private val context: Context, val listener: IProductoRVAdapter): RecyclerView.Adapter<ProductoRVAdapter.ProductoViewHolder>() {

    val allProducto= ArrayList<Producto>()
    inner class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView= itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val viewHolder = ProductoViewHolder(LayoutInflater.from(context).inflate(R.layout.items_producto,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allProducto[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allProducto.size
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val currentProducto = allProducto[position]
        holder.textView.text = currentProducto.text
    }
    fun updateList(newList: List<Producto>){
        allProducto.clear()
        allProducto.addAll(newList)
        notifyDataSetChanged()
    }

}
interface IProductoRVAdapter{
    fun onItemClicked(producto:Producto)
}