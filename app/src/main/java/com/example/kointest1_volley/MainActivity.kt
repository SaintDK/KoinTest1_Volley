package com.example.kointest1_volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kointest1_volley.Volley.VolleyRequest
import com.example.kointest1_volley.Volley.VolleyRequest1
import com.example.kointest1_volley.Volley.VolleyRequest2
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    private val apiRequest: VolleyRequest by inject()
    private val apiRequest1: VolleyRequest1 by inject()
    private val apiRequest2: VolleyRequest2 by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(apiModule)
        }

        apiRequest.makeApiRequest(this)
        apiRequest1.makeApiRequest1(this)
        apiRequest2.makeApiRequest2(this)
    }

    val apiModule = module {
        single<VolleyRequest> { VolleyRequest() }
        single<VolleyRequest1> { VolleyRequest1() }
        single<VolleyRequest2> { VolleyRequest2() }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}