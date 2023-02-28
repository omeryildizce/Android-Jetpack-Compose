package com.omeryildizce.kisileruygulamasi.room

import androidx.room.*
import com.omeryildizce.kisileruygulamasi.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("select * from kisiler")
    suspend fun tumKisiler():List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisiler: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisiler: Kisiler)

    @Delete
    suspend fun kisiSil(kisiler: Kisiler)

    @Query("select * from kisiler where kisi_ad like '%'||:aramaKelime||'%'")
    suspend fun kisiArama(aramaKelime:String):List<Kisiler>
}