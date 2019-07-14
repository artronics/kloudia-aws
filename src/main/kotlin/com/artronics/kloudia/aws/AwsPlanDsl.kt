package com.artronics.kloudia.aws

import com.amazonaws.regions.Regions
import com.artronics.kloudia.aws.resource.Bucket
import com.artronics.kloudia.aws.resource.BucketDsl
import com.artronics.kloudia.core.BasePlan
import com.artronics.kloudia.core.Plan

interface AwsPlan : Plan {
    var region: Regions
}

class BaseAwsPlan internal constructor(basePlan: Plan = BasePlan()) : AwsPlan, Plan by basePlan {
    override lateinit var region: Regions
}

class AwsPlanDsl internal constructor(
    awsBasePlan: AwsPlan = BaseAwsPlan(),
    bucket: BucketDsl = Bucket()
) : AwsPlan by awsBasePlan,
    BucketDsl by bucket  {

}

fun plan(init: AwsPlanDsl.() -> Unit) {
    val plan = AwsPlanDsl()
    plan.init()
}

