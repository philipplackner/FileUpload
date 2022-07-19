package com.plcoding.routes

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.uploadFile() {
    post("file") {
        val multipart = call.receiveMultipart()
        multipart.forEachPart { part ->
            when (part) {
                is PartData.FormItem -> Unit
                is PartData.FileItem -> {
                    if(part.name == "image") {
                        part.save("build/resources/main/static/images/", "myImage.jpg")
                    }
                }
                else -> Unit
            }
        }
        call.respond(HttpStatusCode.OK)
    }
}