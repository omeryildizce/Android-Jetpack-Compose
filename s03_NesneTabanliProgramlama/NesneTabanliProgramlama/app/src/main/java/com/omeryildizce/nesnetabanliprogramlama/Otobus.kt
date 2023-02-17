package com.omeryildizce.nesnetabanliprogramlama

class Otobus(var kapasite: Int, var nereden:String,var nereye:String, var mevcutYolcu:Int ) {
    fun yolcuAl(yolcu:Int){
        if(mevcutYolcu < kapasite && mevcutYolcu + yolcu <= kapasite){
            mevcutYolcu += yolcu
        }
    }

    fun yolcuIndir(yolcu:Int){
        if(mevcutYolcu > 0 && mevcutYolcu - yolcu >= 0){
            mevcutYolcu -= yolcu
        }
    }

    override fun toString(): String {
        return "Otobus(kapasite = $kapasite, nereden = '$nereden', nereye = '$nereye', mevcutYolcu = $mevcutYolcu)"
    }
}