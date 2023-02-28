package com.omeryildizce.yemekleruygulamasi.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler

@Database(entities = [Yemekler::class], version = 1)
abstract class VeriTabani: RoomDatabase() {
    abstract fun yemeklerDao():YemeklerDao
    companion object{
        var INSTANCE :VeriTabani? = null
        fun veritabaniErisim(context: Context):VeriTabani?{
            if (INSTANCE == null){
                synchronized(VeriTabani::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        VeriTabani::class.java,
                        "yemekler.sqlite"
                    )
                        .createFromAsset("yemekler.sqlite")
                        .build()
                }
            }


            return INSTANCE
        }


    }
}