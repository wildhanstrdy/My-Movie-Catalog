package com.krstudio.mymoviecatalogue

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import java.util.concurrent.TimeUnit

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    actual val httpClient: HttpClient
        get() = createClientForAndroid()

    private fun createClientForAndroid(): HttpClient {
        return HttpClient(OkHttp) {
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            engine {
                // this: OkHttpConfig
                config {
                    // this: OkHttpClient.Builder
                    followRedirects(true)
                    // ...
                }
            }
        }
    }

}