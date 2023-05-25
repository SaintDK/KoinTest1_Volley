package com.example.kointest1_volley.Volley

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kointest1_volley.MainActivity

class VolleyRequest() {

    fun makeApiRequest(context: Context) {

        val url = "https://lookup.binlist.net/45717362"
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET, url,

            { response ->
                // Обработка ответа от API
                Log.d("API123", response)
            },
            { error ->
                // Обработка ошибки
                Log.e("API123", error.toString())
            })

        queue.add(stringRequest)
    }
}