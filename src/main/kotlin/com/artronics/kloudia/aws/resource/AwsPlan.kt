package com.artronics.kloudia.aws.resource


class AwsPlan internal constructor(
    name: String

): BaseResource(name = name) {

    override fun create() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun bucket(name: String, init: Bucket.() -> Unit): Bucket {
        val bucket = Bucket(name)
        bucket.init()

        return bucket
    }
}

fun plan(name: String, init: AwsPlan.() -> Unit): AwsPlan {
    val plan = AwsPlan(name)
//    awsContext.addResource(plan)
    plan.init()
//    awsContext.createResources()

    return plan
}
