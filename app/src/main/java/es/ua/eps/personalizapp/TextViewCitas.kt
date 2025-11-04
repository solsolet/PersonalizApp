package es.ua.eps.personalizapp

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

class TextViewCitas @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyle: Int = 0 ) : AppCompatTextView(context!!, attrs, defStyle) {

    private val listaCitas : Array<String> = resources.getStringArray(R.array.citas)

    init { citaAleatoria() }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        citaAleatoria()
        return super.onTouchEvent(event)
    }
    private fun citaAleatoria(){
        text = listaCitas.random()
    }
}