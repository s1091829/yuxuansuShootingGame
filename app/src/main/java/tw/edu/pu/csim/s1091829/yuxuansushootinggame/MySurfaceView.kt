package tw.edu.pu.csim.s1091829.yuxuansushootinggame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
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
        canvas.drawBitmap(BG, 0f, 0f, null)


    }


    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {

    }
}