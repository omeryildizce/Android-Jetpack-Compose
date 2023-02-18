package com.omeryildizce.nesnetabanliprogramlama

class Odev3 {
    fun faktoriyelHesaplama(sayi: Int): Int {
        if (sayi <= 1) {
            return 1
        }

        return sayi * faktoriyelHesaplama(sayi - 1)
    }
}