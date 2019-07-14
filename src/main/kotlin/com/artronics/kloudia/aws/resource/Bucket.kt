package com.artronics.kloudia.aws.resource

import com.artronics.kloudia.core.BaseResource
import com.artronics.kloudia.core.Resource


internal interface BucketDsl {
    fun bucket(init: Bucket.() -> Unit)
}

class Bucket internal constructor(
    baseResource: Resource = BaseResource(),
    awsBaseResourcePlan: AwsBaseResourcePlan = AwsBaseResourcePlan()

) : BucketDsl,
    Resource by baseResource,
    AwsResourcePlan by awsBaseResourcePlan {

    override fun bucket(init: Bucket.() -> Unit) {
        val bucket = Bucket()
        bucket.init()
    }

}
