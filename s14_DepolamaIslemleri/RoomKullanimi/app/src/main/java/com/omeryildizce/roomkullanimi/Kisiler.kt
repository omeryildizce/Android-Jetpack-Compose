package com.omeryildizce.roomkullanimi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("kisiler")
data class Kisiler(
    @PrimaryKey(true) @ColumnInfo("kisi_id") @NotNull var kisi_id: Int,
    @ColumnInfo("kisi_ad") @NotNull var kisi_adi: String,
    @ColumnInfo("kisi_tel") @NotNull var kisi_tel: String,
) {

}