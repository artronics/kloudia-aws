package com.artronics.kloudia.aws

import com.artronics.kloudia.aws.configuration.AwsConfigurationService
import com.artronics.kloudia.aws.context.AwsContext
import com.artronics.kloudia.aws.provider.AwsProvider
import com.artronics.kloudia.core.ConfigurationService
import com.artronics.kloudia.core.Context
import com.artronics.kloudia.core.Provider
import com.google.inject.AbstractModule
import com.google.inject.Guice

class AwsModule : AbstractModule() {
    override fun configure() {
        bind(ConfigurationService::class.java).to(AwsConfigurationService::class.java)
        bind(Provider::class.java).to(AwsProvider::class.java)
        bind(Context::class.java).to(AwsContext::class.java)
    }
}

fun awsProvider(): Context {
    val injector = Guice.createInjector(AwsModule())

    return injector.getInstance(Context::class.java)
}
fun main() {
    val context = awsProvider()

/*    val credentials = ProfileCredentialsProvider().credentials
    val awsProvider = AwsProvider(credentials, Regions.EU_WEST_1, clientFactory)
    val context = AwsContext(awsProvider)
    val clientFactory = S3Client()

    plan(context, "planA") {
        bucket("kir") {
        }
    }*/
}
