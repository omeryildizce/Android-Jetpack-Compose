package com.omeryildizce.roomkullanimi

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface KisilerDao {
    @Query("Select * From kisiler")
    suspend fun tumKisiler(): List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisiler: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisiler: Kisiler)
}