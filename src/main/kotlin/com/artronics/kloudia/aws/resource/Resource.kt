package com.artronics.kloudia.aws.resource

import com.artronics.kloudia.core.Resource

abstract class BaseResource(name: String) : Resource {
    private val resourceDocument = ResourceDocument(name)

    override fun resourceDocument(): ResourceDocument {
        return resourceDocument
    }
}

data class ResourceDocument(val name: String)

