package tw.edu.pu.csim.s1091829.yuxuansushootinggame

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MySurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs),SurfaceHolder.Callback {

    lateinit var surfaceHolder: SurfaceHolder
    lateinit var BG: Bitmap

    init {
        surfaceHolder = getHolder()
        BG = BitmapFactory.decodeResource(getResources(), R.drawable.background)

        surfaceHolder.addCallback(this)
    }


    override fun surfaceCreated(p0: SurfaceHolder) {
        var canvas: Canvas = surfaceHolder.lockCanvas()
            drawSomething(canvas)
        surfaceHolder.unlockCanvasAndPost(canvas)

    }


    fun drawSomething(canvas:Canvas) {
        var SrcRect: Rect = Rect(0, 0, BG.width, BG.height) //裁切
        var w:Int = width
        var h:Int = height
        var DestRect: Rect = Rect(0, 0, w, h)
        canvas.drawBitmap(BG, SrcRect, DestRect, null)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.BLUE
        paint.textSize = 50f
        canvas.drawText("射擊遊戲(作者：蘇鈺暄)",50f,50f, paint)

    }


    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }


    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }

}