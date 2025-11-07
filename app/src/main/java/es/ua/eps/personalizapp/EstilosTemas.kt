package es.ua.eps.personalizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.EstilosTemasBinding

class EstilosTemas : AppCompatActivity() {

    private lateinit var bindings : EstilosTemasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = EstilosTemasBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        bindings.buttonContinuar.setOnClickListener { irSecundaria() }
    }
    private fun irSecundaria(){
        val ir = Intent(this@EstilosTemas, Actividad2Estilos::class.java)
        startActivity(ir)
    }
}