package com.omeryildizce.ilerikotlin

fun main() {
    val birinciThread = BirinciThread()
    val ikinciThread = Thread(IkinciThread())

    birinciThread.start()
    ikinciThread.start()

    for (i in 900..999){
        println("Main Thread: $i")
        Thread.sleep(20)
    }
}