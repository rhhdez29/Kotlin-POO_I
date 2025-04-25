package model

import android.graphics.Color

//Clase que hereda sus caracteristicas y funciones de la clase Rectangulo
class RectanguloConBordes (color:Int, alto:Int, ancho:Int, var bordeColor:Int= Color.BLACK): Rectangulo(color, ancho, alto) {

    fun cambiarColorBordes(nuevoColorBorde:Int){

        bordeColor=nuevoColorBorde

    }
}