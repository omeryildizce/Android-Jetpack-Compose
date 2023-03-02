package com.omeryildizce.kisileruygulamasi.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://10.0.2.2/"
        fun getKisilerDaoInterface():KisilerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }
}