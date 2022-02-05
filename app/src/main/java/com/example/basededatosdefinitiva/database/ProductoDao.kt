package com.example.basededatosdefinitiva.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(producto: Producto)

    @Delete
    suspend fun delete(producto: Producto)

    @Query("Select * from producto_table order by id ASC")
    fun getAllProducto(): LiveData<List<Producto>>
}