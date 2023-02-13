package com.omeryildizce.degiskenlerveveritipleri

fun main(){
    var i : Int = 42
    var d : Double = 42.42
    var f : Float = 42.42f

    var sonuc1 : Int = d.toInt()
    var sonuc2 : Double = i.toDouble()
    var sonuc3 : Int = f.toInt()
    println(sonuc1)
    println(sonuc2)
    println(sonuc3)

    var str1 = i.toString()
    var str2 = d.toString()
    var str3 = f.toString()
    println(str1)
    println(str2)
    println(str3)

    var yazi1 = "34t"
    try {
        var x = yazi1.toInt()
        println(x)
    }catch (e:Exception){
       println("Hata!")
    }

    var yazi2 = "49w"
    var y = yazi2.toIntOrNull()
    println(y)
    if (y != null){
        println(y)
    }else{
        println(y)
    }

    var yazi3 = "67s"
    var z = yazi3.toIntOrNull()
    z?.let { println("z: "+it) }



}