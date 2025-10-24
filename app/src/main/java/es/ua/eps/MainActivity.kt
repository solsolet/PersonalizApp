package es.ua.eps.personalizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
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
        }

    }
}