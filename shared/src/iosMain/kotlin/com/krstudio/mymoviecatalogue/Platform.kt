package com.krstudio.mymoviecatalogue

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.engine.ios.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    actual val httpClient: HttpClient
        get() = createClientForIos()

    private fun createClientForIos(): HttpClient {
        return HttpClient(Darwin) {
            install(ContentNegotiation){
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            engine {
                configureRequest {
                    setAllowsCellularAccess(true)
                }
            }
        }
    }

}