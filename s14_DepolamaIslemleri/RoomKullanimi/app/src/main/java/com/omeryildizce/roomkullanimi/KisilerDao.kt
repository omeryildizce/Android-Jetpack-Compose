package com.omeryildizce.roomkullanimi

import androidx.room.*

@Dao
interface KisilerDao {
    @Query("Select * From kisiler")
    suspend fun tumKisiler(): List<Kisiler>

    @Insert
    suspend fun kisiEkle(kisiler: Kisiler)

    @Update
    suspend fun kisiGuncelle(kisiler: Kisiler)

    @Delete
    suspend fun kisiSil(kisiler:Kisiler)

    @Query("Select * from kisiler order by random() limit 1")
    suspend fun rastgeleKisiGetir():List<Kisiler>

    @Query("Select * from kisiler where kisi_ad like '%'|| :aramaKelimesi || '%'")
    suspend fun kisiAra(aramaKelimesi:String):List<Kisiler>

    @Query("Select * from kisiler where kisi_id = :kisi_id")
    suspend fun kisiGetir(kisi_id:Int):Kisiler

    @Query("select count(*) from kisiler where kisi_ad = :kisi_ad")
    suspend fun kayitKontrol(kisi_ad: String):Int
}