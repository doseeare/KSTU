package com.kstu.kelbilim.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.kstu.kelbilim.MainActivity
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.RetrofitHeader
import com.kstu.kelbilim.service.AppPreferences
import com.kstu.kelbilim.service.Status
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModel()
    private val header = RetrofitHeader()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login()
    }

    private fun login() {
        login_enter.setOnClickListener {
            viewModel.login(header.header("${login_login.length() + login_password.length()}"), login_login.text.toString(), login_password.text.toString())
                .observe(this, Observer { result ->
                    val data = result.data
                    val msg = result.msg
                    when (result.status) {
                        Status.SUCCESS -> {
                            AppPreferences.isLogined = true
                            AppPreferences.studentId = data?.idStudent.toString()
                            AppPreferences.studentName = data?.studentName
                            AppPreferences.mobilePassword = data?.mobilePassword
                            AppPreferences.mobileLogin = data?.mobileLogin

                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        Status.ERROR -> {
                            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
                        }
                        Status.NETWORK -> {
                            Toast.makeText(this, "Проблемы с интернетом", Toast.LENGTH_LONG)
                                .show()
                        }
                        else -> {
                            Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_LONG).show()
                        }
                    }
                })
        }
    }
}
