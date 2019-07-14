package com.artronics.kloudia.core

import java.util.*

interface Context {
    fun findResource(resourceName: String): Optional<Resource>
    fun createResources()
}
