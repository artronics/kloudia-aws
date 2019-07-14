package com.artronics.kloudia.aws.resource

import com.amazonaws.regions.Regions
import com.artronics.kloudia.core.BaseResourcePlan
import com.artronics.kloudia.core.ResourcePlan

interface AwsResourcePlan : ResourcePlan {
    var region: Regions
}

class AwsBaseResourcePlan(
    baseResourcePlan: ResourcePlan = BaseResourcePlan()
) : AwsResourcePlan , ResourcePlan by baseResourcePlan {

    override lateinit var region: Regions
}

