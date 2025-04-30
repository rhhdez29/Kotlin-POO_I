package model

import android.graphics.Color

class RectanguloSinBordes(color:Int, alto:Int, ancho:Int):RectanguloConBordes(color, alto, ancho) {

    override fun cambiarColorBordes(nuevoColorBorde:Int){

        bordeColor = nuevoColorBorde

    }

    fun eliminarBordes(){

        bordeColor= Color.TRANSPARENT

    }


}