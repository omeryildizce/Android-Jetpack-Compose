package com.omeryildizce.kisileruygulamasi.entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.omeryildizce.kisileruygulamasi.entity.Kisiler

data class KisilerCevap(
    @SerializedName("kisiler") @Expose var kisiler:List<Kisiler>,
    @SerializedName("success") @Expose var success:Int
)
