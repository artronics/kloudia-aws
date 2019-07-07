package com.artronics.kloudia.aws.context

import com.artronics.kloudia.aws.provider.AwsProvider
import com.artronics.kloudia.aws.resource.BaseResource
import com.artronics.kloudia.core.Context
import com.artronics.kloudia.core.Resource
import com.google.inject.Inject
import java.util.*

class AwsContext @Inject constructor(private val awsProvider: AwsProvider) : Context {
    private val resource = linkedMapOf<String, BaseResource>()

    override fun addResource(resource: BaseResource) {
        val name = resource.resourceDocument().name
        if (this.resource.containsKey(name)) {
            throw ResourceAlreadyExistException("Resource: \"$name\" already exists")
        }
        this.resource[name] = resource

    }

    override fun createResources() {
        resource.values.forEach { it.create() }
    }

    override fun findResource(resourceName: String): Optional<Resource> = Optional.ofNullable(resource[resourceName])
}

class ResourceAlreadyExistException(message: String) : RuntimeException(message)
