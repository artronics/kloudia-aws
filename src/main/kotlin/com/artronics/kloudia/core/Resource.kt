package com.artronics.kloudia.core

import com.artronics.kloudia.aws.resource.ResourceDocument

@DslMarker
annotation class ResourceDslMarker

interface Resource {
    fun create()
    fun resourceDocument(): ResourceDocument
}
