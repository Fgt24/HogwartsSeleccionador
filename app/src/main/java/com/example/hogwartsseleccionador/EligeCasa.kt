package com.example.hogwartsseleccionador

import CasaHogwarts
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class EligeCasa : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elige_casa)

        // Mostramos el número de alumnos por cada casa cargados en la BBDD
        val txtNumGriffindor: TextView = findViewById(R.id.txtNumGriffindorf)
        val txtNumSlytherin: TextView = findViewById(R.id.txtNumSlytherin)
        val txtNumHufflepuff: TextView = findViewById(R.id.txtNumHufflepuff)
        val txtNumRavenclaw: TextView = findViewById(R.id.txtNumRavenclaw)

        // Obtenemos los números de la BBDD de SQLite
        var hogwartsDB: HogwartsDatabaseHelper = HogwartsDatabaseHelper(this)
        txtNumGriffindor.text = hogwartsDB.getNumeroAlumnos(CasaHogwarts.CASA_GRIFFINDORF).toString() + " alumnos"
        txtNumSlytherin.text = hogwartsDB.getNumeroAlumnos(CasaHogwarts.CASA_SLYTHERIN).toString() + " alumnos"
        txtNumHufflepuff.text = hogwartsDB.getNumeroAlumnos(CasaHogwarts.CASA_HUFFLEPLUFF).toString() + " alumnos"
        txtNumRavenclaw.text = hogwartsDB.getNumeroAlumnos(CasaHogwarts.CASA_RAVENCLAW).toString() + " alumnos"

        // Botón y acción para Griffindor
        val btnGriffindor: Button = findViewById(R.id.btnVerGriffindorf)
        btnGriffindor.setOnClickListener {
            val intent = Intent(this, ListadoCasaHogwarts::class.java)
            intent.putExtra("casa", CasaHogwarts.CASA_GRIFFINDORF)
            startActivity(intent)
        }

        // Botón y acción para Slytherin
        val btnSlytherin: Button = findViewById(R.id.btnVerSlytherin)
        btnSlytherin.setOnClickListener {
            val intent = Intent(this, ListadoCasaHogwarts::class.java)
            intent.putExtra("casa", CasaHogwarts.CASA_SLYTHERIN)
            startActivity(intent)
        }

        // Botón y acción para Hufflepuff
        val btnHufflepuff: Button = findViewById(R.id.btnVerHufflepuff)
        btnHufflepuff.setOnClickListener {
            val intent = Intent(this, ListadoCasaHogwarts::class.java)
            intent.putExtra("casa", CasaHogwarts.CASA_HUFFLEPLUFF)
            startActivity(intent)
        }

        // Botón y acción para Ravenclaw
        val btnRavenclaw: Button = findViewById(R.id.btnVerRavenclaw)
        btnRavenclaw.setOnClickListener {
            val intent = Intent(this, ListadoCasaHogwarts::class.java)
            intent.putExtra("casa", CasaHogwarts.CASA_RAVENCLAW)
            startActivity(intent)
        }
// Imagen btnAtrasDesdeCasas
        val btnAtrasDesdeCasas: ImageButton = findViewById(R.id.btnAtrasDesdeCasas)
        btnAtrasDesdeCasas.setOnClickListener{
            // Nos devuelve a la MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}