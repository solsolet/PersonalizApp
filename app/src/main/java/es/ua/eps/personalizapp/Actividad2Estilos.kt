package es.ua.eps.personalizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.Actividad2EstilosBinding

class Actividad2Estilos : AppCompatActivity() {
    private lateinit var bindings : Actividad2EstilosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = Actividad2EstilosBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        bindings.buttonVolver.setOnClickListener { irEstilosTemas() }
    }
    private fun irEstilosTemas(){
        val ir = Intent(this@Actividad2Estilos, EstilosTemas::class.java)
        startActivity(ir)
    }
}