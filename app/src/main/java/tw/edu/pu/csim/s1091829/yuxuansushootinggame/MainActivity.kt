package tw.edu.pu.csim.s1091829.yuxuansushootinggame


import android.content.pm.ActivityInfo
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.coroutines.*
@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() {

    lateinit var img : ImageView
    lateinit var game : MySurfaceView
    var flag:Boolean = false
    lateinit var job : Job
    lateinit var imgAuthor : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //設定螢幕水平顯示
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

        img = findViewById(R.id.img)
        game = findViewById(R.id.game)

        imgAuthor = findViewById(R.id.imgAuthor)
        GlideApp.with(this)
            //.load(R.drawable.earth)
            .load(R.drawable.yxsu)
            .circleCrop()
            .override(800, 600)
            .into(imgAuthor)

        img.setOnClickListener({
            if (flag){
                flag = false
                img.setImageResource(R.drawable.start)
                job.cancel()
            }
            else{
                flag = true
                img.setImageResource(R.drawable.stop)
                job = GlobalScope.launch(Dispatchers.Main) {
                    while(flag) {
                        delay(10)
                        game.fly.update()
                        var canvas: Canvas = game.surfaceHolder.lockCanvas()
                        game.drawSomething(canvas)
                        game.surfaceHolder.unlockCanvasAndPost(canvas)
                    }
                }
            }

        })


    }
}