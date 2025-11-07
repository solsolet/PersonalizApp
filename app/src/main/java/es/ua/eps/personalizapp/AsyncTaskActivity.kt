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
            bindings.tvCrono.text = "Comenzando la descarga..."
        }
        override fun doInBackground(vararg p0: Void?): Void? {
            var t = 10
            do {
                publishProgress(t)

                Thread.sleep(1000)
                t--
            } while (t > 0)
            return null
        }
        override fun onProgressUpdate(vararg values: Int?) {
            bindings.tvCrono.text = "Contador: ${values[0]}"
        }
        override fun onPostExecute(result: Void?) {
            bindings.tvCrono.text = "Contador terminado"
        }
        override fun onCancelled() {
            bindings.tvCrono.text = "Contador terminado"
        }
    }
}