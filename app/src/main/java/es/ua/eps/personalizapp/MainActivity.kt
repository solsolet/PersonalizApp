package es.ua.eps.personalizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindings : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = MainActivityBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)
            buttonDrawable.setOnClickListener { irDrawable() }
            buttonPersonalizacion.setOnClickListener { irPersonalizacion() }
            buttonNotificacion.setOnClickListener { irNotificacion() }
        }
    }
    private fun irDrawable(){
        val ir = Intent(this@MainActivity, Drawables::class.java)
        startActivity(ir)
    }
    private fun irPersonalizacion(){
        val ir = Intent(this@MainActivity, PersonalizacionComp::class.java)
        startActivity(ir)
    }
    private fun irNotificacion(){
        val ir = Intent(this@MainActivity, Notificaciones::class.java)
        startActivity(ir)
    }
}