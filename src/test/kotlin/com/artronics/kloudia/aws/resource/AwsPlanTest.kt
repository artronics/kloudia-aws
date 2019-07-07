package com.artronics.kloudia.aws.resource

import com.artronics.kloudia.aws.context.AwsContext
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class AwsPlanTest {
    @Test
    fun `It should add plan to context resource list`() {
        val context = mockk<AwsContext>()
        every { context.addResource(any()) } returns Unit

        // When
        plan(context, "testPlan") {
            // Then - assertion is here to make sure we addResource before calling init(block)
            verify { context.addResource(any()) }
        }
    }

    @Test
    fun `It should create all resources after plan block`() {
        val context = mockk<AwsContext>()
        every { context.addResource(any()) } returns Unit
        every { context.createResources() } returns Unit

        // When
        plan(context, "testPlan") {
            // Then - assertion is here to make sure we addResource before calling init(block)
            verify(exactly = 0) { context.createResources() }
        }

        verify { context.createResources() }
    }
}
