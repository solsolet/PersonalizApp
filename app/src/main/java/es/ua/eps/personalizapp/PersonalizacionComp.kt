package es.ua.eps.personalizapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            //EdicionBorrable
            val editText = findViewById<EditText>(R.id.editText)!!
            val buttonX = findViewById<Button>(R.id.buttonBorrable)!!

            buttonX.setOnClickListener { editText.setText("") }
        }
    }
}