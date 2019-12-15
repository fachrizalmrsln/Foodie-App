package com.id.zul.foodie.ui.splashscreen

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.id.zul.foodie.R
import com.id.zul.foodie.ui.listfoods.ListFoodsActivity
import org.jetbrains.anko.startActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity<ListFoodsActivity>()
            finish()
        }, 3000)
    }
}
