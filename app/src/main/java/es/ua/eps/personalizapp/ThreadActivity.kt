package es.ua.eps.personalizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.ThreadActivityBinding

class ThreadActivity : AppCompatActivity() {

    private lateinit var bindings : ThreadActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = ThreadActivityBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)
            Thread {
                var t = 10
                do {
                    tvCrono.post {
                        tvCrono.text = buildString {
                            append(getString(R.string.contador))
                            append(t)
                        }//"Contador: $t"
                    }
                    Thread.sleep(1000)
                    t--
                } while (t > 0)
                    runOnUiThread {
                        tvCrono.text = getString(R.string.contTerminado)
                    }
            }.start()
        }
    }
}