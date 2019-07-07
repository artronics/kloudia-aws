package com.artronics.kloudia.aws.provider

import com.artronics.kloudia.aws.configuration.AwsConfigurationService
import com.artronics.kloudia.core.Provider
import com.google.inject.Inject

class AwsProvider @Inject constructor(
    private val configurationService: AwsConfigurationService
) : Provider {

}
