package es.ua.eps.personalizapp

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import es.ua.eps.personalizapp.Drawables
import es.ua.eps.personalizapp.databinding.MainActivityBinding

class MainActivity : ComponentActivity() {
    private lateinit var bindings : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){ //like initLayout in Filmoteca
        bindings = MainActivityBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)
            buttonDrawable.setOnClickListener { irDrawable() }
        }
    }
    private fun irDrawable(){
        val ir = Intent(this@MainActivity, Drawables::class.java)
        startActivity(ir)
    }
}