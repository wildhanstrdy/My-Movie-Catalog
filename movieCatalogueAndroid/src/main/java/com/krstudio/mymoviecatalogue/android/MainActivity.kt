package com.krstudio.mymoviecatalogue.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.krstudio.mymoviecatalogue.Greeting
import android.widget.TextView
import com.krstudio.mymoviecatalogue.APIService
import com.krstudio.mymoviecatalogue.Platform
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

suspend fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(),CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                val result = APIService().
                getTopRatedMovies()
                Log.d("sdf","${result.results.toString()}")
            }
        }
    }
}
