package com.example.hogwartsseleccionador

import AlumnoHogwarts
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class NuevoAlumno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_alumno)

        //Cogemos el botón y programamos el evento onClicks
        val btnAniadirAlumno: Button = findViewById(R.id.btnAddAlumno)
        // Cogemos los datos del formulario y añadimos el alumno
        btnAniadirAlumno.setOnClickListener {
            //Cogemos los valores de los formularios
            val txtNombre: EditText = findViewById(R.id.txtNombreAlumnoNuevo)
            val esMaggle: CheckBox = findViewById(R.id.chkFamilia)
            // Debe introducir un nombre válido
            if (txtNombre.text.toString() == "Nombre")
                Toast.makeText(this, "Debes introducir un nombre válido", Toast.LENGTH_SHORT)
            else{
                val nombre = txtNombre.text.toString()
                val maggle = esMaggle.isChecked
                val nuevoAlumno: AlumnoHogwarts = AlumnoHogwarts(nombre, maggle)
                // Acceso a la BBDD de SQLite
                var hogwartsDB: HogwartsDatabaseHelper = HogwartsDatabaseHelper(this)
                val idAlumno: Long = hogwartsDB.insert(nuevoAlumno)
                hogwartsDB.close()
                // Nos vamos a la siguiente Activity
                var intent = Intent(this, BienvenidaAlumno::class.java)
                startActivity(intent)
            }
        }

        // Imagen btnAtras
        val btnImgAtras: ImageButton = findViewById(R.id.imgBtnAtras)
        btnImgAtras.setOnClickListener{
            // Nos devuelve a la MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}