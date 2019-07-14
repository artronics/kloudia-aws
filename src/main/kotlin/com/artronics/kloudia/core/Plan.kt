package com.artronics.kloudia.core

interface Plan {
    var name: String
}

class BasePlan : Plan {
    override lateinit var name: String
}
