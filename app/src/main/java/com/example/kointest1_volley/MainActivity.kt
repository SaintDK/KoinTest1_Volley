package com.example.kointest1_volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kointest1_volley.Volley.VolleyRequest
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    private val apiRequest: VolleyRequest by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(apiModule)
        }

        apiRequest.makeApiRequest(this)
    }

    val apiModule = module {
        single<VolleyRequest> { VolleyRequest() }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}