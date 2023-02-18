package com.omeryildizce.nesnetabanliprogramlama2

class Villa(var garajVarMi: Boolean, pencereSayisi: Int) :Ev(pencereSayisi){
    override fun toString(): String {
        return "Villa garajVarMi=$garajVarMi, " + super.toString()
    }
}