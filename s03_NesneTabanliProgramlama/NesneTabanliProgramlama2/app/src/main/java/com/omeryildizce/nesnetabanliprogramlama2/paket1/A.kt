package com.omeryildizce.nesnetabanliprogramlama2.paket1

import com.omeryildizce.nesnetabanliprogramlama2.paket2.B

class A : B() {
    fun fonksiyon(){
        val nesne = B()
        println(nesne.varsayilanDegisken)
        println(nesne.publicDegisken)
        println(nesne.internalDegisken)
        println(protectedDegisken)

    }
}