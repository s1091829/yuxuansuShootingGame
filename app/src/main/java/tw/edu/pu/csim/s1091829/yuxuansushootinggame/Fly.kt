package tw.edu.pu.csim.s1091829.yuxuansushootinggame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect

class Fly (context: Context) {

    val res = context.resources  //讀取資源
    var x:Int = 0
    var y:Int = res.displayMetrics.heightPixels/2
    var w:Int
    var h:Int
    var image: Bitmap
    var SrcRect: Rect
    lateinit var DestRect: Rect
    var count : Int = 1
    var fire : Int = 0


    init {
        image = BitmapFactory.decodeResource(res, R.drawable.fly1)
        SrcRect = Rect(0, 0, image.width, image.height) //裁切
        w = image.width/4
        h = image.height/4
        y -= h/2
    }

    fun draw(canvas: Canvas) {
        DestRect = Rect(x, y, x + w, y + h)
        canvas.drawBitmap(image, SrcRect, DestRect, null)
    }

    fun update(){
        if (fire == 0){
            if (count==1){
                count = 2
                image = BitmapFactory.decodeResource(res, R.drawable.fly2)
            }
            else{
                count = 1
                image = BitmapFactory.decodeResource(res, R.drawable.fly1)
            }
        }
        else{
            when(fire){
                1 -> image = BitmapFactory.decodeResource(res, R.drawable.shoot1)
                2 -> image = BitmapFactory.decodeResource(res, R.drawable.shoot2)
                3 -> image = BitmapFactory.decodeResource(res, R.drawable.shoot3)
                4 -> image = BitmapFactory.decodeResource(res, R.drawable.shoot4)
                5 -> image = BitmapFactory.decodeResource(res, R.drawable.shoot5)
            }
            fire++
            if (fire>5){
                fire = 0
            }
        }
    }
}