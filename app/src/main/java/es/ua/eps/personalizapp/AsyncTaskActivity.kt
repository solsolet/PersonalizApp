package es.ua.eps.personalizapp

import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.personalizapp.databinding.AsyncTaskActivityBinding

class AsyncTaskActivity : AppCompatActivity() {
    private lateinit var bindings : AsyncTaskActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initUI()
    }
    private fun initUI(){
        bindings = AsyncTaskActivityBinding.inflate(layoutInflater)

        with(bindings){
            setContentView(root)
            TareaContador().execute()
        }
    }
    inner class TareaContador : AsyncTask<Void, Int, Void>() {
        override fun onPreExecute() {
            bindings.tvCrono.text = getString(R.string.comenzandoCont)
        }
        override fun doInBackground(vararg p0: Void?): Void? { // Ejecucion hilo secundario
            var t = 10
            do {
                publishProgress(t)
                Thread.sleep(1000)
                t--
            } while (t > 0)
            return null
        }
        override fun onProgressUpdate(vararg values: Int?) {
            bindings.tvCrono.text = buildString {
                append(getString(R.string.contador))
                append(values[0])
            }
        }
        override fun onPostExecute(result: Void?) {
            bindings.tvCrono.text = getString(R.string.contTerminado)
        }
        override fun onCancelled() {
            bindings.tvCrono.text = getString(R.string.contTerminado)
        }
    }
}