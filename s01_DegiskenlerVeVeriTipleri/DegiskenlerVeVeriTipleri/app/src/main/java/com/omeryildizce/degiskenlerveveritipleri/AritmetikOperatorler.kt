package com.omeryildizce.degiskenlerveveritipleri

fun main(args: Array<String>) {
    val pi = Math.PI
    var yariCap = 2.0
    val alan = pi * yariCap * yariCap
    println("Dairenin alanı: $alan")

    //F = m x a
    var m = 12.5
    var a = 10.0
    var f = m * a
    println("F: $f")

    // Ax
    var v = 12.7
    var v0 = 23.56
    var t = 3.5

    var x1 = ((v + v0) / 2) * t
    println("x1: $x1")

    var x2 = (v0 * t) + (a * t * t) / 2
    println("x2: $x2")

    var y = 10
    y += 2
    println(y)
}