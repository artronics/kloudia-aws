package com.artronics.kloudia.core

typealias RenameStrategy = (name: String) -> String

object IdentityRenameStrategy : RenameStrategy {
    override fun invoke(name: String) = name
}

data class PrefixRenameStrategy(private val prefix: String) : RenameStrategy {
    override fun invoke(name: String) = "$prefix$name"
}
