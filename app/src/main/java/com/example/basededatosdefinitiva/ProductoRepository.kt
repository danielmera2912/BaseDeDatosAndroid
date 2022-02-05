package com.example.basededatosdefinitiva

import androidx.lifecycle.LiveData
import com.example.basededatosdefinitiva.database.Producto
import com.example.basededatosdefinitiva.database.ProductoDao

class ProductoRepository (private val productoDao: ProductoDao){

    val allProducto: LiveData<List<Producto>> = productoDao.getAllProducto()

    suspend fun insert(producto: Producto){
        productoDao.insert(producto)
    }
    suspend fun delete(producto: Producto){
        productoDao.delete(producto)
    }
}