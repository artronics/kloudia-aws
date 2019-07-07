package com.artronics.kloudia.aws.context

import com.artronics.kloudia.aws.provider.AwsProvider
import com.artronics.kloudia.aws.resource.BaseResource
import com.artronics.kloudia.aws.resource.ResourceDocument
import com.artronics.kloudia.core.Context
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AwsContextTest {
    private lateinit var context: Context

    @BeforeEach
    fun setUp() {
        val awsProvider = mockk<AwsProvider>()
//        every { awsProvider.credentials } returns mockk()
//        every { awsProvider.region } returns mockk()

        context = AwsContext(awsProvider)
    }

    @Test
    fun `It should find added resource`() {
        // Given
        val resourceName = "testResource"
        val expResource = TestResource(resourceName, context)

        // When
        context.addResource(expResource)

        // Then
        val actResource = context.findResource(resourceName)
        assertThat(actResource).hasValue(expResource)
    }

    @Test
    fun `It should not let adding the same resource`() {
        // Given
        val resourceName = "testResource"
        val expResource = TestResource(resourceName, context)

        context.addResource(expResource)

        // When/Then
        assertThatExceptionOfType(ResourceAlreadyExistException::class.java)
            .isThrownBy { context.addResource(expResource) }
            .withMessage("Resource: \"$resourceName\" already exists")
    }

    @Test
    fun `It should create all resources - preserve order`() {
        // Given
        val res1 = mockk<TestResource>()
        every { res1.resourceDocument() } returns ResourceDocument("res1")
        every { res1.create() } returns Unit

        val res2 = mockk<TestResource>()
        every { res2.resourceDocument() } returns ResourceDocument("res2")
        every { res2.create() } returns Unit

        context.addResource(res2)
        context.addResource(res1)

        // When
        context.createResources()

        // Then
        verifyOrder {
            res2.create()
            res1.create()
        }

    }
}

class TestResource(name: String, context: Context) : BaseResource(name, context) {
    override fun create() {

    }
}
