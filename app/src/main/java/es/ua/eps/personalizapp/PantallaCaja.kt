package es.ua.eps.personalizapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

class PantallaCaja @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0 )
    : View(context, attrs, defStyle),
      GestureDetector.OnGestureListener {

    private val SIZE = 50
    private var cX = 100F // coordinates center
    private var cY = 100F

    private var gDetector = GestureDetectorCompat(context, this@PantallaCaja)

    private var vX: Float = -1f // initial coordinates fling
    private var vY: Float = -1f

    private var caja = Paint().apply{
        style = Paint.Style.FILL
        color = Color.RED
    }
    private var lineaCaja = Paint().apply{
        style = Paint.Style.FILL
        strokeWidth = 6f
        color = Color.BLACK
    }

    private var gestoEnCaja = false

    override fun onDraw(canvas: Canvas) {
        // si hay una línea de fling pendiente, dibujarla primero
        if (vX >= 0f && vY >= 0f) {
            canvas.drawLine(vX, vY, cX, cY, lineaCaja)
        }
        canvas.drawRect(cX - SIZE, cY - SIZE, cX + SIZE, cY + SIZE, caja)
        super.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event == null) return false
        // Delegamos el evento al detector
        gDetector.onTouchEvent(event)
        // También queremos asegurarnos de recibir el ACTION_DOWN inicial,
        // así que devolvemos true siempre para indicar que manejamos el toque.
        return true
    }

    override fun onDown(e: MotionEvent): Boolean {
        // comprobar si la pulsación inicial cae dentro de la caja
        val dentro = e.x >= cX - SIZE && e.x <= cX + SIZE && e.y >= cY - SIZE && e.y <= cY + SIZE
        gestoEnCaja = dentro
        // devolvemos true para indicar que queremos seguir recibiendo eventos
        return true
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (!gestoEnCaja || e1 == null) return false

        vX = e1.x
        vY = e1.y

        cX = e2.x
        cY = e2.y

        this.invalidate()
        return true
    }

//    override fun onFling(
//        e1: MotionEvent?,
//        e2: MotionEvent?,
//        velocityX: Float,
//        velocityY: Float
//    ): Boolean {
//        // No debería llamarse esta sobrecarga (ya tenemos la otra), devolvemos false
//        return false
//    }

    override fun onLongPress(e: MotionEvent) {}

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        if (!gestoEnCaja) return false

        cX = e2.x
        cY = e2.y
        vX = -1f
        vY = -1f

        this.invalidate()
        return true
    }

    override fun onShowPress(e: MotionEvent) {}

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        if (!gestoEnCaja) return false

        caja.color = if (caja.color == Color.RED) Color.BLUE else Color.RED
        invalidate()
        return true
    }
}