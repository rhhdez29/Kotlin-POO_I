package model

open class Rectangulo(var color:Int, var ancho:Int, var alto:Int) { //Se pone como open para que pueda heredar a otras clases

    //cordenadas iniciales

    var x:Int=0
    var y:Int=0

    //Metodos de comportamiento

    fun moverArriba(){

        y-=10

    }

    fun moverAbajo(){

        y+=10

    }

    fun moverIzquierda(){

        x-=10

    }

    fun moverDerecha(){

        x+=10

    }

    fun cambiarTamanio(nuevoAncho:Int, nuevoAlto:Int){

        ancho=nuevoAncho
        alto=nuevoAlto

    }

}