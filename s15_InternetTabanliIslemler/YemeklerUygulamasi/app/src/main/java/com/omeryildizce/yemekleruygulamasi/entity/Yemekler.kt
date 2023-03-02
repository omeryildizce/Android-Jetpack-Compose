package com.omeryildizce.yemekleruygulamasi.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Yemekler(
    @SerializedName("yemek_id") @Expose var yemekId: Int,
    @SerializedName("yemek_adi") @Expose var yemekAdi: String,
    @SerializedName("yemek_resim_adi") @Expose var yemekResimAdi: String,
    @SerializedName("yemek_fiyat") @Expose var yemekFiyat: Int,
)
