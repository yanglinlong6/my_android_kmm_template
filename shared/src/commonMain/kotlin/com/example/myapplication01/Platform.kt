package com.example.myapplication01

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform