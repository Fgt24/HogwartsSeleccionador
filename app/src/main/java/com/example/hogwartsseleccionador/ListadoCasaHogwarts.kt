package com.example.hogwartsseleccionador

import AlumnoHogwarts
import CasaHogwarts
import FuncionesApoyo
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.core.content.ContextCompat

class ListadoCasaHogwarts : AppCompatActivity() {

    private fun setEstiloCelda(textoCelda: TextView){
        textoCelda.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
        textoCelda.gravity = Gravity.CENTER
        textoCelda.setBackgroundResource(R.color.white)
    }

    /**
     * Insertamos un alumno en la tabla indicada
     * @param alumno datos del objeto AlumnoHogwartas
     * @param tabla tabla del estilo TableLayout donde se añadirá la fila
     */
    private fun insertarFilaTabla(alumno: AlumnoHogwarts, tabla: TableLayout) {
        var fila: TableRow = TableRow(this)
        // Introducimos los datos de la fila con los datos del alumno
        fila.setBackgroundResource(R.drawable.celda_borde)

        // Nombre y Apellidos del alumno
        var nombreApellidos: TextView = TextView(this)
        nombreApellidos.text = "${alumno.nombre} ${alumno.apellido}"
        setEstiloCelda(nombreApellidos)
        // Si es Maggle
        var esMaggle: TextView = TextView(this)
        esMaggle.text = FuncionesApoyo.booleanToString(alumno.familiaMaggle)
        setEstiloCelda(esMaggle)
        // Habilidad, Inteligencia, Creatividad, Etica, Coraje, Lealtad
        var habilidad: TextView = TextView(this)
        habilidad.text = alumno.listaAtributos[0].valor.toString()
        setEstiloCelda(habilidad)
        var inteligencia: TextView = TextView(this)
        inteligencia.text = alumno.listaAtributos[1].valor.toString()
        setEstiloCelda(inteligencia)
        var creatividad: TextView = TextView(this)
        creatividad.text = alumno.listaAtributos[2].valor.toString()
        setEstiloCelda(creatividad)
        var etica: TextView = TextView(this)
        etica.text = alumno.listaAtributos[3].valor.toString()
        setEstiloCelda(etica)
        var coraje: TextView = TextView(this)
        coraje.text = alumno.listaAtributos[4].valor.toString()
        setEstiloCelda(coraje)
        var lealtad: TextView = TextView(this)
        lealtad.text = alumno.listaAtributos[5].valor.toString()
        setEstiloCelda(lealtad)

        // Insertamos los datos en la fila
        fila.addView(nombreApellidos)
        fila.addView(esMaggle)
        fila.addView(habilidad)
        fila.addView(inteligencia)
        fila.addView(creatividad)
        fila.addView(etica)
        fila.addView(coraje)
        fila.addView(lealtad)
        // Insertamos la fila en la tabla
        tabla.addView(fila)
    }

    /**
     * Función que inserta en la tabla el listado de Alumnos de una casa
     */
    fun insertarAlumnosTabla(tabla: TableLayout, alumnos: List<AlumnoHogwarts>){
        // Recorremos el listado de alumnos y lo añadimos a la tabla
        for(alumno in alumnos){
            insertarFilaTabla(alumno, tabla)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_casa_hogwarts)

        // Botón Atrás
        val btnAtras: ImageButton = findViewById(R.id.btnAtrasListado)
        btnAtras.setOnClickListener {
            // Nos devuelve a Seleccionar Casa
            val intent = Intent(this, EligeCasa::class.java)
            startActivity(intent)
        }

        // Recogemos el parámetro pasado por el Put
        val casaHogwart: String? = intent.getStringExtra("casa")
        // Cogemos el TextView del Titulo de la Casa
        val tituloCasa: TextView = findViewById<TextView>(R.id.txtTituloCasaListado)
        // Cogemos el ImgView del logo de la Casa
        val logoCasa: ImageView = findViewById<ImageView>(R.id.imgCasaListado)
        // Cogemos la referencia de la Tabla
        val tablaAlumnos: TableLayout = findViewById(R.id.tablaAlumnos)

        // Si se recibe el nombre de la Casa
        if (casaHogwart != null) {
            // Acceso a la BBDD de SQLite
            var hogwartsDB: HogwartsDatabaseHelper = HogwartsDatabaseHelper(this)
            // Ponemos el nombre de la Casa
            tituloCasa.text = casaHogwart
            // Accedemos al listado de alumnos de la casa
            var listaAlumnos = hogwartsDB.listaAlumnos(casaHogwart)
            if (listaAlumnos != null) {
                insertarAlumnosTabla(tablaAlumnos, listaAlumnos)
            }
            // Accedemos al número de alumnos
            var numAlumnos: TextView = findViewById(R.id.txtListadoAlumnos)
            numAlumnos.text = hogwartsDB.getNumeroAlumnos(casaHogwart).toString() + " alumnos"

            // Cambiamos la imagen de la casa y el color del fondo en función de la casa
            if (casaHogwart == CasaHogwarts.CASA_GRIFFINDORF) {
                logoCasa.setImageResource(R.drawable.gryffindor)
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.griffindorfBackground
                    )
                )
            } else if (casaHogwart == CasaHogwarts.CASA_SLYTHERIN) {
                logoCasa.setImageResource(R.drawable.slytherin)
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.slytherinfBackground
                    )
                )
            } else if (casaHogwart == CasaHogwarts.CASA_HUFFLEPLUFF) {
                logoCasa.setImageResource(R.drawable.hufflepuff)
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.hufflepuffBackground
                    )
                )
            } else if (casaHogwart == CasaHogwarts.CASA_RAVENCLAW) {
                logoCasa.setImageResource(R.drawable.ravenclaw)
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.ravenclawBackground
                    )
                )
            }
            // Cerramos la BBDD
            hogwartsDB.close()
        }
    }
}