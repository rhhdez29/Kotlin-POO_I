package com.example.poo_i

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
import model.RectanguloConBordes
import model.RectanguloSinBordes
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var rectanguloView:View=findViewById(R.id.rentagulo)

        rectanguloView.post { //con post aseguramos que la view este construida para que podemos interactuar con ella

            //Obtenemos los datos del view de xml cordenadas, ancho y alto
            val inicialX=rectanguloView.x.toInt()
            val inicialY=rectanguloView.y.toInt()
            val inicialWidth=rectanguloView.width
            val inicialHeight=rectanguloView.height

            //apply función de alcance que se usa para modificar las propiedades de un objeto recien creado
            /*val rectangulo = Rectangulo(R.color.purple, inicialWidth, inicialHeight).apply {

                x=inicialX
                y=inicialY

            }*/

            /*val rectangulo = RectanguloConBordes(ContextCompat.getColor(this, R.color.purple), inicialWidth, inicialHeight).apply {

                x=inicialX
                y=inicialY
                //ContextCompat se usa para que tenga compatibilidad con versiones anteriores de android
                //this@MainActivity hace referencia al contexto de la actividad que es mainactivity debido a que estamos en una clase anidada
                //en este caso es apply si no solo necesitariamos this para referirnos al contexto de mainactivity
                bordeColor=ContextCompat.getColor(this@MainActivity, R.color.purple) //Debido a que usamos apply al intentar usar

            }*/

            val rectangulo = RectanguloSinBordes(ContextCompat.getColor(this, R.color.purple), inicialWidth, inicialHeight).apply {

               /* x=inicialX
                  y=inicialY*/

                dimensiones.x=inicialX
                dimensiones.y=inicialY

            }

            rectangulo.eliminarBordes()
            actualizarFigura(rectangulo, rectanguloView)

            val btnArriba: Button = findViewById(R.id.btnArriba)
            val btnAbajo: Button = findViewById(R.id.btnAbajo)
            val btnIzquierda: Button = findViewById(R.id.btnIzquierda)
            val btnDerecha: Button = findViewById(R.id.btnDerecha)
            val btnSize: Button = findViewById(R.id.btnSize)
            val btnColor: Button = findViewById(R.id.btnColor)
            val btnColorBorde:Button=findViewById(R.id.btnColorBorde)

            //Funciones para realizar los cambios em la posicion, tamaño y color
            btnArriba.setOnClickListener {

                rectangulo.moverArriba()
                actualizarFigura(rectangulo, rectanguloView)

            }

            btnAbajo.setOnClickListener {

                rectangulo.moverAbajo()
                actualizarFigura(rectangulo, rectanguloView)

            }

            btnIzquierda.setOnClickListener {

                rectangulo.moverIzquierda()
                actualizarFigura(rectangulo, rectanguloView)

            }

            btnDerecha.setOnClickListener {

                rectangulo.moverDerecha()
                actualizarFigura(rectangulo, rectanguloView)

            }

            btnSize.setOnClickListener {

                var ancho = Random.nextInt(50, 200)
                var alto = Random.nextInt(50, 200)

                rectangulo.cambiarTamanio(ancho, alto) //El tamaño va cambiando de manera aleatoria
                actualizarFigura(rectangulo, rectanguloView)

            }

            btnColor.setOnClickListener {
                //El color va cambiando de manera aleatoria
                rectangulo.color = generarColorAleatorio()
                actualizarFigura(rectangulo, rectanguloView)

            }
            btnColorBorde.setOnClickListener {

                //rectangulo.cambiarColorBordes(generarColorAleatorio())
                rectangulo.cambiarColorBordes(RectanguloConBordes.ManejoColor.generarColorAleatorio()) //Aqui le asignamos el color al borde de la figura por medio de la clase ManejoColor
                                                                                                       //para acceder a esta clase no es necesiario crear una instancia de la clase RectanguloConBordes
                                                                                                       //debido a que esta clase es una clase nested dentro de la clase RectanguloConBordes y funciona como estática
                actualizarFigura(rectangulo, rectanguloView)

            }

        }
    }

    //Funcion que por medio de la clase random nos da colores aleatorios
    private fun generarColorAleatorio():Int{

        val random=Random.Default
        val rojo=random.nextInt(256)
        val verde=random.nextInt(256)
        val azul=random.nextInt(256)

        return Color.rgb(rojo,verde,azul)
    }

    private fun actualizarFigura(rectangulo:RectanguloConBordes, rectanguloView: View){ //Funcion que carga todos los cambios del view

        val drawable=GradientDrawable() //Creamos una variable de tipor GradientDrawable

        drawable.setColor(rectangulo.color) //Cambiamos el color del rectangulo
        drawable.setStroke(10, rectangulo.bordeColor) //Cambiamos el color del borde del rectangulo

        /*rectanguloView.layoutParams.width=rectangulo.ancho
        rectanguloView.layoutParams.height=rectangulo.alto*/
        rectanguloView.layoutParams.width=rectangulo.dimensiones.ancho
        rectanguloView.layoutParams.height=rectangulo.dimensiones.alto

        //rectanguloView.setBackgroundColor(rectangulo.color) //Ya no es necesario porque usamos el drawable

        rectanguloView.background=drawable //Cambiamos el fondo del rectangulo

        /*rectanguloView.x= rectangulo.x.toFloat()
        rectanguloView.y= rectangulo.y.toFloat()*/

        rectanguloView.x= rectangulo.dimensiones.x.toFloat()
        rectanguloView.y= rectangulo.dimensiones.y.toFloat()

        rectanguloView.requestLayout() //Para hacer efectivos los cambios

    }
}