package com.omeryildizce.yemekleruygulamasi.room

import androidx.room.Dao
import androidx.room.Query
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler

@Dao
interface YemeklerDao {

    @Query("select * from yemekler")
    suspend fun tumYemekler(): List<Yemekler>
}