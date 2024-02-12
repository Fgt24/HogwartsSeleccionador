package com.example.hogwartsseleccionador


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar MediaPlayer con el sonido de fondo en res/raw
        mediaPlayer = MediaPlayer.create(this, R.raw.sound)
        mediaPlayer.isLooping = true // Repetir el sonido en bucle
        mediaPlayer.start() // Comenzar la reproducción

        // Cogemos el botón nuevo alumno y creamos el evento listener
        val btnNuevoAlumno: Button = findViewById(R.id.btnNuevoAlumno)
        btnNuevoAlumno.setOnClickListener {
            val intent = Intent(this, NuevoAlumno::class.java)
            startActivity(intent)
        }

        // Botón para acceder a los listados de Alumnos
        val btnListadoAlumnos: Button = findViewById(R.id.btnListaAlumnos)
        btnListadoAlumnos.setOnClickListener {
            val intent = Intent(this, EligeCasa::class.java)
            startActivity(intent)
        }

        val btnCerrarApp: Button = findViewById(R.id.btnCerrarApp)

        // Configura un OnClickListener para el botón de cerrar la aplicación
        btnCerrarApp.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            finishAffinity() // Cierra todas las actividades de la aplicación
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos cuando la actividad se destruye
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }
}
