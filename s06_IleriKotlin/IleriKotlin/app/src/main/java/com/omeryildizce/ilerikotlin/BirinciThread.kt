package com.omeryildizce.ilerikotlin

import kotlin.concurrent.thread

class BirinciThread :Thread() {
    override fun run() {
        for (i in 100..199)
        {
            println("Birinci Thread: $i")
            Thread.sleep(20)
        }
    }
}