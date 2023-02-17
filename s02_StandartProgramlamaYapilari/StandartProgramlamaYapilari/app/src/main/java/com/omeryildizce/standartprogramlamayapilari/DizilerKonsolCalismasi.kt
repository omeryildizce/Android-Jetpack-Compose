package com.omeryildizce.standartprogramlamayapilari

fun main() {
    val isimler = Array<String>(5) { "" }

    for (i in isimler.indices) {
        println("${i + 1}. İsim:")
        isimler[i] = readLine().toString()
    }
    println(isimler.contentToString())

}