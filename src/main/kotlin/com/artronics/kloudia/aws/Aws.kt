package com.artronics.kloudia.aws

import com.amazonaws.regions.Regions


fun main() {
    fun test() {
        plan {
            name = ""
            region = Regions.DEFAULT_REGION
            bucket {
                renameStrategy = {""}

            }
        }
    }

}
