package es.ua.eps.personalizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.DrawablesBinding

class Drawables : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){ //like initLayout in Filmoteca
        val bindings = DrawablesBinding.inflate(layoutInflater)
        setContentView(bindings.root)
    }
}