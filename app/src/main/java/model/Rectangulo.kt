package model

open class Rectangulo(var color:Int, var ancho:Int, var alto:Int) { //Se pone como open para que pueda heredar a otras clases

    //cordenadas iniciales

    /*var x:Int=0
    var y:Int=0*/

    //Se crea un objeto de la clase MiDimension que contiene las propiedades de un rectangulo, x, y, ancho y alto
    //por lo que remplazamos las cordenadas iniciales por un objeto de la clase MiDimension
    var dimensiones=MiDimension(0,0,ancho,alto)

    //Metodos de comportamiento

    fun moverArriba(){

        //y-=10
        dimensiones.y-=10

    }

    fun moverAbajo(){

        //y+=10
        dimensiones.y+=10

    }

    fun moverIzquierda(){

        //x-=10
        dimensiones.x-=10

    }

    fun moverDerecha(){

        //x+=10
        dimensiones.x+=10

    }

    fun cambiarTamanio(nuevoAncho:Int, nuevoAlto:Int){

        /*ancho=nuevoAncho
        alto=nuevoAlto*/

        dimensiones.ancho=nuevoAncho
        dimensiones.alto=nuevoAlto

    }

}