package com.artronics.kloudia.core

import com.artronics.kloudia.aws.resource.ResourceDocument

interface Resource {
    fun create()
    fun resourceDocument(): ResourceDocument
}
