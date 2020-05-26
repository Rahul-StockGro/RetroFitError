package com.rahul.retrofiterror

import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


abstract class CustomCallback<T,K>(private val context: Context, val errorType: Class<K>) : Callback<T> {

    abstract fun onSuccess(result : T?)
    abstract fun onError(error : K?)

    override fun onFailure(call: Call<T>, t: Throwable) {
        Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.isSuccessful){
            onSuccess(response.body())
        }else {
            onError(Gson().fromJson(response.errorBody()?.string(), errorType))
        }
    }

}

