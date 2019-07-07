package com.artronics.kloudia.aws.provider

import com.artronics.kloudia.aws.context.AwsContext

//interface ClientProvider {
//    fun create()
//}
//
//interface ClientProviderFactory<T> {
//    fun createClient(client: T): ClientProvider
//}
//
//class AwsProviderClientFactory : ClientProviderFactory<AwsClient> {
//    override fun createClient(client: AwsClient): ClientProvider {
//        return when (client) {
//            S3 -> S3Client()
//        }
//    }
//}
//
//enum class AwsClient {
//    S3
//}

class S3Client(private val awsContext: AwsContext) {

//    fun create(): AmazonS3 = AmazonS3ClientBuilder.standard()
//            .withCredentials(AWSStaticCredentialsProvider(awsContext.credentials))
//            .withRegion(awsContext.region)
//            .build()
}
