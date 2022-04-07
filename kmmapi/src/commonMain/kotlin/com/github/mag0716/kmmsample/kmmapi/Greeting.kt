package com.github.mag0716.kmmsample.kmmapi

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}