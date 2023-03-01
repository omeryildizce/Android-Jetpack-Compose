package com.omeryildizce.retrofitkullanimi
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class CRUDCevap(
    @SerializedName("success") @Expose var success:Int,
    @SerializedName("message") @Expose var message:String
)
