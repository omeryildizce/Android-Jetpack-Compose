package com.omeryildizce.yemekleruygulamasi.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://10.0.2.2/"

        fun getYemeklerDaoInterface():YemeklerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDaoInterface::class.java)
        }
    }
}