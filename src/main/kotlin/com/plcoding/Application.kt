package com.plcoding

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.plcoding.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureHTTP()
        configureMonitoring()
        configureSerialization()
    }.start(wait = true)
}
