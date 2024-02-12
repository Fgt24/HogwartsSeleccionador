package com.example.hogwartsseleccionador

import AlumnoHogwarts
import CasaHogwarts
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class BienvenidaAlumno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida_alumno)
        //Volver a Inicio
        val btnInicio: Button = findViewById(R.id.btnVolverInicio)
        btnInicio.setOnClickListener {
            // Nos devuelve a la MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Cargamos los datos del último alumno para mostrarlo en nuestra Activity
        var hogwartsDB: HogwartsDatabaseHelper = HogwartsDatabaseHelper(this);
        val alumno: AlumnoHogwarts? = hogwartsDB.ultimoAlumno()
        hogwartsDB.close()

        // Si no aparece un alumno con ese ID lo mostramos en el cuadro de diálogo
        if (alumno == null) {
            // Para no perder la referencia de la actividad
            val contentActivity = this
            // Crea y muestra el cuadro de diálogo de tipo alerta
            AlertDialog.Builder(this).apply {
                setTitle("Alumno no encontrado en la BBDD")
                setMessage("Lo siento pero no hemos podido encontrar ese alumno")
                setPositiveButton("Aceptar") { _, _ ->
                    // Acción a realizar cuando el usuario presione el botón "Aceptar"
                    val intentNuevoAlumno = Intent(contentActivity, NuevoAlumno::class.java)
                    startActivity(intentNuevoAlumno)
                }
            }.show()
        }

        // Cogemos la referencia de los componentes de la Activity
        var imgCasa: ImageView = findViewById(R.id.imgCasa)
        var txtTituloCasa: TextView = findViewById(R.id.txtTituloCasa)
        var txtNombreApellido: TextView = findViewById(R.id.txtNombreApellido)
        var txtHabilidad: TextView = findViewById(R.id.txtHabilidad)
        var txtInteligencia: TextView = findViewById(R.id.txtInteligencia)
        var txtCreatividad: TextView = findViewById(R.id.txtCreatividad)
        var txtEtica: TextView = findViewById(R.id.txtEtica)
        var txtCoraje: TextView = findViewById(R.id.txtCoraje)
        var txtLealtad: TextView = findViewById(R.id.txtLealtad)

        // Actualizamos los datos del alumno en la Activity
        if (alumno != null) {
            txtNombreApellido.text = alumno.nombre + " " + alumno.apellido
            txtHabilidad.text = "Habilidad: " + alumno.listaAtributos[0]
            txtInteligencia.text = "Inteligencia: " +  alumno.listaAtributos[1]
            txtCreatividad.text = "Creatividad: " + alumno.listaAtributos[2]
            txtEtica.text = "Etica: " + alumno.listaAtributos[3]
            txtCoraje.text = "Coraje: " + alumno.listaAtributos[4]
            txtLealtad.text = "Lealtad: " + alumno.listaAtributos[5]

            // Cambiamos la imagen de la casa, el título de la misma y el color de fondo de la activity
            if (alumno.casa == CasaHogwarts.CASA_GRIFFINDORF) {
                imgCasa.setImageResource(R.drawable.gryffindor)
                txtTituloCasa.text = "Bienvenido a Gryffindor"
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.griffindorfBackground
                    )
                )
            } else if (alumno.casa == CasaHogwarts.CASA_SLYTHERIN) {
                imgCasa.setImageResource(R.drawable.slytherin)
                txtTituloCasa.text = "Bienvenido a Slytherin"
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.slytherinfBackground
                    )
                )
            } else if (alumno.casa == CasaHogwarts.CASA_HUFFLEPLUFF) {
                imgCasa.setImageResource(R.drawable.hufflepuff)
                txtTituloCasa.text = "Bienvenido a Hufflepuff"
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.hufflepuffBackground
                    )
                )
            } else if (alumno.casa == CasaHogwarts.CASA_RAVENCLAW) {
                imgCasa.setImageResource(R.drawable.ravenclaw)
                txtTituloCasa.text = "Bienvenido a Ravenclaw"
                window.decorView.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.ravenclawBackground
                    )
                )
            }
        }
    }
}