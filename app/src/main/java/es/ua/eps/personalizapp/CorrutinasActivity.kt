package es.ua.eps.personalizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.CorrutinasActivityBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CorrutinasActivity : AppCompatActivity() {
    private lateinit var bindings : CorrutinasActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = CorrutinasActivityBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)

            GlobalScope.launch(Dispatchers.IO) {
                var t = 10
                do {
                    launch(Dispatchers.Main) {  // Accedemos al interfaz
                        tvCrono.text = "Contador: $t"
                    }

                    Thread.sleep(1000)
                    t--
                } while (t > 0)

                launch(Dispatchers.Main) {  // Accedemos al interfaz
                    tvCrono.text = "Contador terminado"
                }
            }
        }
    }
}