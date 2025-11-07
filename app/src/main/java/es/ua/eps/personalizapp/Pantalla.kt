package es.ua.eps.personalizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.PantallaBinding

class Pantalla : AppCompatActivity() {

    private lateinit var bindings: PantallaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }

    private fun initUI(){
        bindings = PantallaBinding.inflate(layoutInflater)
        setContentView(bindings.root)
    }
}