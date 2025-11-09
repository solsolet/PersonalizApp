package es.ua.eps.personalizapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.HilosBinding

class Hilos : AppCompatActivity() {

    private lateinit var bindings : HilosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = HilosBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)
            // Codigo enunciado
    //        val tvCrono = tvCrono
    //        var t = 10
    //        do {
    //            tvCrono.text = "Contador: $t"
    //            Thread.sleep(1000)
    //            t--
    //        } while (t > 0)
    //        tvCrono.text = "Contador terminado"
            buttonThread.setOnClickListener { irThread() }
            buttonAsync.setOnClickListener { irAsync() }
            buttonCorrutinas.setOnClickListener { irCorrutinas() }
        }
    }
    private fun irThread(){
        val ir = Intent(this@Hilos, ThreadActivity::class.java)
        startActivity(ir)
    }
    private fun irAsync(){
        val ir = Intent(this@Hilos, AsyncTaskActivity::class.java)
        startActivity(ir)
    }
    private fun irCorrutinas(){
        val ir = Intent(this@Hilos, CorrutinasActivity::class.java)
        startActivity(ir)
    }
}