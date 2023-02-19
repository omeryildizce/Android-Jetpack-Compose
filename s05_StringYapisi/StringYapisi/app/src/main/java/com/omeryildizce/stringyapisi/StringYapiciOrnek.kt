package com.omeryildizce.stringyapisi

fun main() {
    val str1 = "Merhaba"
    println(str1)

    var str2 = String()
    str2 = "Kotlin"
    println(str2)

    val str3 = """
        Nasılsın
        "Merhaba"
        'Hey'
    """.trimIndent()
    println(str3)

    val str4 = ""
    val str5 = String()

    if (str4.isEmpty()){
        println("str4 boş")
    }else {
        println("str4 dolu")
    }

    if (str5.isEmpty()){
         println("boş")
    }
    val varA = 10
    val varB = 50
    println("${varA} x $varB = ${varA * varB}")

    val str6 = "Merhaba"
    val str7 = " Dünya"
    println(str6+str7)

    val str8 = "Merhaba, Kotlin!"
    println("${str8} boyutu ${str8.length}")

    val str9 = "Merhaba"
    val str10 = "merhaba"
    if (str9 == str10){
        println(true)
    }

    str10.forEach {
        println(it)
    }
}