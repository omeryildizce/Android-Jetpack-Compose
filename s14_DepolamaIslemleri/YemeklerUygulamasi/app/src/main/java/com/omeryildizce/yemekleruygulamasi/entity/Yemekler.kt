package com.omeryildizce.yemekleruygulamasi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("yemekler")
data class Yemekler(
    @PrimaryKey(true)
    @ColumnInfo("yemek_id") @NotNull var yemek_id: Int,
    @ColumnInfo("yemek_adi") @NotNull var yemek_adi:String,
    @ColumnInfo("yemek_resim_adi") @NotNull var yemek_resim_adi:String,
    @ColumnInfo("yemek_fiyat") @NotNull  var yemek_fiyat:Int
    )
