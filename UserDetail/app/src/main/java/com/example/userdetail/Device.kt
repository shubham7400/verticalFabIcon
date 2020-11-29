package com.example.userdetail

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "device_table")
data class Device (
    /* @PrimaryKey(autoGenerate = true)
     val id:Int,*/
    /*val profilePhoto: Bitmap,*/
    var username: String,
    var deviceName:String,
    /* @ColumnInfo(name = "email")*/
    var deviceModel:String,
    /* @ColumnInfo(name = "date")*/
    var deviceDate :String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}