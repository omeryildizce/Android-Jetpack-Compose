package com.omeryildizce.kisileruygulamasi.entity

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Kisiler(var kisi_id:String?="", val kisi_ad:String?="", var kisi_tel :String?="")
