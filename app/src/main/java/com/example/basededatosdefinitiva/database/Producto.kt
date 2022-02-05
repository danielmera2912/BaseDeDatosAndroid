package com.example.basededatosdefinitiva.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "producto_table")
class Producto (@ColumnInfo(name = "text")val text: String){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

