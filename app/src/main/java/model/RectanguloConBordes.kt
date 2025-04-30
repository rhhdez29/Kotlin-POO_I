package model

import android.graphics.Color

//Clase que hereda sus caracteristicas y funciones de la clase Rectangulo
//Las clases por defecto son final, asi como sus funciones lo que significa que no pueden ser heredadas
// y por lo tanto no se pueden modificar al poner open antes de la clase o funcion permitimos que sean heredadas
open class RectanguloConBordes (color:Int, alto:Int, ancho:Int, var bordeColor:Int= Color.BLACK): Rectangulo(color, ancho, alto) {

    class ManejoColor{ //Clase Nested es como una clase comun pero dentro de otra clase y no puede acceder a las propiedades de la clase que la contiene
                       //Nos sirve para hacer una encapsulacion y tener un mejor manejo de los datos

        companion object{ //Permite acceder a los miembros de la clase sin necesidad de crear una instancia de la clase
                          //Estos son creados de manera estatica y no pueden acceder a los miembros privados de la clase

            val ROJO=Color.RED
            val AZUL=Color.BLUE
            val VERDE=Color.GREEN
            val NEGRO=Color.BLACK

            fun generarColorAleatorio():Int{ //Funcion que genera colores aleatorios de una lista de colores previamente creados

                val colores= listOf(ROJO, AZUL, VERDE, NEGRO)
                return colores.random()
            }

        }



    }

   open fun cambiarColorBordes(nuevoColorBorde:Int){

        bordeColor=nuevoColorBorde

    }
}