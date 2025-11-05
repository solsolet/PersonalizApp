package es.ua.eps.personalizapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Grafica @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0 ) : View(context, attrs, defStyle) {

    private val DEFAULT_SIZE = 100
    private var percent = 0
    private var cX = 0F
    private var cY = 0F
    private var r = 0F

    init{
        if(attrs != null) {
            val ta = context.obtainStyledAttributes(attrs, R.styleable.Grafica)
            percent = ta.getInt(R.styleable.Grafica_percentage, 0)
        }
    }

    override fun onDraw(canvas: Canvas) {
        // red
        val red = Paint()
        red.style = Paint.Style.FILL
        red.color = Color.RED
        //red.isAntiAlias = true
        // blue
        val blue = Paint()
        blue.style = Paint.Style.FILL
        blue.color = Color.BLUE

        val angle = percent.toFloat() * 360f/100f

        super.onDraw(canvas)
        // Define how to draw the component
        canvas.drawCircle(cX, cY,r,  blue) // base circle
        canvas.drawArc(cX-r, cY-r, cX+r, cY+r, 0F, angle, true, red)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        var width: Int = DEFAULT_SIZE
        var height = width // square
        when (widthMode) {
            MeasureSpec.EXACTLY -> width = widthSize
            MeasureSpec.AT_MOST -> if (width > widthSize) width = widthSize
        }
        when (heightMode) {
            MeasureSpec.EXACTLY -> height = heightSize
            MeasureSpec.AT_MOST -> if (height > heightSize) height = heightSize
        }

        cX = width / 2f
        cY = height /2f
        r = (width.coerceAtMost(height) / 2).toFloat()

        setMeasuredDimension(width, height)
    }

    fun setPercentage(per: Int) {
        percent = per
        invalidate()
    }
}