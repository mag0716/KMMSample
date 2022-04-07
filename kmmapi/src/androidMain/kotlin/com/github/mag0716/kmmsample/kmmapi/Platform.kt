package com.github.mag0716.kmmsample.kmmapi

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}