package com.artronics.kloudia.core


interface Resource {
    var name: String
}

class BaseResource : Resource {
    override lateinit var name: String
}
