package com.krstudio.mymoviecatalogue

import io.ktor.client.*
import io.ktor.client.engine.ios.*
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion


}