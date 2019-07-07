package com.artronics.kloudia.aws.resource

import com.artronics.kloudia.aws.context.AwsContext


class Bucket(name: String, private val awsContext: AwsContext) : BaseResource(name = name, context = awsContext) {
//    private val s3Client = AmazonS3ClientBuilder.standard()
//        .withCredentials(AWSStaticCredentialsProvider(awsContext.credentials))
//        .withRegion(awsContext.region)
//        .build()

    override fun create() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
