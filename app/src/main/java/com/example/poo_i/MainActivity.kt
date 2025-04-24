package com.example.poo_i

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
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
            val rectangulo = Rectangulo(R.color.red, inicialWidth, inicialHeight).apply {

                x=inicialX
                y=inicialY

            }
            val btnArriba: Button = findViewById(R.id.btnArriba)
            val btnAbajo: Button = findViewById(R.id.btnAbajo)
            val btnIzquierda: Button = findViewById(R.id.btnIzquierda)
            val btnDerecha: Button = findViewById(R.id.btnDerecha)
            val btnSize: Button = findViewById(R.id.btnSize)
            val btnColor: Button = findViewById(R.id.btnColor)

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

    private fun actualizarFigura(rectangulo:Rectangulo, rectanguloView: View){ //Funcion que carga todos los cambios del view

        rectanguloView.layoutParams.width=rectangulo.ancho
        rectanguloView.layoutParams.height=rectangulo.alto

        rectanguloView.setBackgroundColor(rectangulo.color)

        rectanguloView.x= rectangulo.x.toFloat()
        rectanguloView.y= rectangulo.y.toFloat()

        rectanguloView.requestLayout() //Para hacer efectivos los cambios

    }
}