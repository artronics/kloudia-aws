package com.artronics.kloudia.core

import com.artronics.kloudia.aws.resource.BaseResource
import java.util.*

interface Context {
    fun addResource(resource: BaseResource)
    fun findResource(resourceName: String): Optional<Resource>
    fun createResources()
}
