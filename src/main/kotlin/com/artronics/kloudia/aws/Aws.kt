package com.artronics.kloudia.aws

import com.artronics.kloudia.core.ConfigurationService
import com.artronics.kloudia.core.Context
import com.artronics.kloudia.core.Provider
import com.google.inject.AbstractModule
import com.google.inject.Guice

class AwsModule : AbstractModule() {
    override fun configure() {
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
