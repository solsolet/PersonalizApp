package es.ua.eps.personalizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.PersonalizacionCompBinding

class PersonalizacionComp : AppCompatActivity() {

    private lateinit var bindings : PersonalizacionCompBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = PersonalizacionCompBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)

        }
    }
}