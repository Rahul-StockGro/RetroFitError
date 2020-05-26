package com.rahul.retrofiterror

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service: ApiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.mocky.io")
            .build().create(ApiService::class.java)
        service.getMock2().enqueue(object : CustomCallback<SuccessResponse, ErrorResponse>(this,ErrorResponse::class.java) {
            override fun onSuccess(result: SuccessResponse?) {
                Toast.makeText(this@MainActivity, result?.hello, Toast.LENGTH_LONG).show()
            }

            override fun onError(error: ErrorResponse?) {
                Toast.makeText(this@MainActivity, error?.errorMessage, Toast.LENGTH_LONG).show()

            }
        })
        helloWorldBtn.setOnClickListener {
            service.getMock().enqueue(object : CustomCallback<SuccessResponse, ErrorResponse>(this,ErrorResponse::class.java) {
                override fun onSuccess(result: SuccessResponse?) {
                    Toast.makeText(this@MainActivity, result?.hello, Toast.LENGTH_LONG).show()
                }

                override fun onError(error: ErrorResponse?) {
                    Toast.makeText(this@MainActivity, error?.errorMessage, Toast.LENGTH_LONG).show()

                }
            })

        }
    }
}
