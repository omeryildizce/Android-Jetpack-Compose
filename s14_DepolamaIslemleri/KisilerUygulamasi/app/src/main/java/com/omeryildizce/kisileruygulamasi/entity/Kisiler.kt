package com.omeryildizce.kisileruygulamasi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("kisiler")
data class Kisiler(
    @PrimaryKey(true)
    @ColumnInfo(name = "kisi_id") @NotNull var kisi_id: Int,
    @ColumnInfo(name = "kisi_ad") @NotNull val kisi_ad: String,
    @ColumnInfo(name = "kisi_tel") @NotNull var kisi_tel: String,
)
