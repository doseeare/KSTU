package com.kstu.kelbilim.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kstu.kelbilim.MainActivity
import com.kstu.kelbilim.R
import com.kstu.kelbilim.service.AppPreferences
import com.kstu.kelbilim.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        initViews()
    }

    private fun initViews() {
        if (AppPreferences.isLogined){
            startActivity(Intent(this, MainActivity::class.java))
        }
        start_student.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}
