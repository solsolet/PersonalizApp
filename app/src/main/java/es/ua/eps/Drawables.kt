package es.ua.eps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import es.ua.eps.personalizapp.databinding.DrawablesBinding

class Drawables : ComponentActivity() {
    private lateinit var bindings : DrawablesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){ //like initLayout in Filmoteca
        bindings = DrawablesBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)
            //buttonPersonalizado
        }
    }
}