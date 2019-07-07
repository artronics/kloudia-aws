package com.artronics.kloudia.aws.resource

import com.artronics.kloudia.aws.context.AwsContext

class AwsPlan internal constructor(
    name: String,
    private val awsContext: AwsContext

): BaseResource(name = name, context = awsContext) {

    override fun create() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun bucket(name: String, init: Bucket.() -> Unit): Bucket {
        val bucket = Bucket(name, awsContext)
        bucket.init()

        return bucket
    }
}

fun plan(awsContext: AwsContext, name: String, init: AwsPlan.() -> Unit): AwsPlan {
    val plan = AwsPlan(name, awsContext)
    awsContext.addResource(plan)
    plan.init()
    awsContext.createResources()

    return plan
}
