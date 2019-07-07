package com.artronics.kloudia.aws.configuration

import com.amazonaws.regions.Regions
import com.artronics.kloudia.core.ConfigurationService

class AwsConfigurationService : ConfigurationService<AwsConfiguration> {
    override fun configure(): AwsConfiguration {
        return AwsConfiguration(Regions.EU_WEST_1)
    }
}

data class AwsConfiguration(
    val defaultRegion: Regions
)
