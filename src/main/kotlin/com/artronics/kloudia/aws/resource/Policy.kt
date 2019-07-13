package com.artronics.kloudia.aws.resource

import com.artronics.kloudia.aws.resource.PrincipalEntry.*
import com.artronics.kloudia.core.ResourceDslMarker
import com.amazonaws.auth.policy.Statement as AwsStatement

fun policy(init: Policy.() -> Unit): Policy {
    val policy = Policy()
    policy.init()

    return policy
}

@ResourceDslMarker
class Policy {
    lateinit var name: String
    var version: PolicyVersion? = null
    var id: String? = null
    val statements: List<Statement> = mutableListOf()

    fun statements(init: Statements.() -> Unit) {
        val statements = Statements()
        statements.init()

    }

}

@ResourceDslMarker
class Statements {
    private val statements: MutableList<Statement> = mutableListOf()

    fun statement(init: Statement.() -> Unit) {
        val statement = Statement()
        statement.init()
        statements.add(statement)
    }

}

fun foo() {
    policy {
        statements {
            statement {
                effect = Statement.Effect.Allow
                sid = "kfi"
                resources("*", "kir")
                actions("df")
            }
        }
    }
    principals {
        principal("*")
        principal(Principal.PrincipalEntry.AWS to arrayOf("f"))
    }

//    val s = principle { AWS to "kir" }
}

sealed class Principal {
    object Wildcard : Principal()
    data class SingleEntry(
        val f: Pair<PrincipalEntry, String>
    ) : Principal()
    data class MultipleEntry(
        val f: Pair<PrincipalEntry, Array<String>>
    ) : Principal()

    enum class PrincipalEntry { AWS, Federated, Service }
}

class Statement {
    lateinit var effect: Effect
    var sid: String? = null
    private var principals: MutableList<String> = mutableListOf()
    private var actions: MutableList<String> = mutableListOf()
    private var resources: MutableList<String> = mutableListOf()

    enum class Effect { Allow, Deny }

    fun principals(vararg principals: String) {
        this.principals.addAll(principals)
    }

    fun actions(vararg actions: String) {
        this.actions.addAll(actions)
    }

    fun resources(vararg resources: String) {
        this.resources.addAll(resources)
    }
}

enum class PolicyVersion (val value: String) {
    V_2008_10_7("2008-10-7"),
    V_2012_10_7("2012-10-7"),
}

data class PolicyDocument(
    val Version: PolicyVersion? = null,
    val Id: String? = null,
    val Statement: List<StatementDocument>
)


fun principals(init: Principals.() -> Unit) {
    val principal = Principals()
    principal.init()

}


typealias P = Pair<Principal.PrincipalEntry, Array<String>>
class Principals {
    private val principals = mutableListOf<P>()
    private var hasWildcard: Boolean = false

    fun principal(principal: P) {
        principals.add(principal)
    }

    fun principal(wildcard: String) {
        hasWildcard = true
    }

    fun principal(p: Principal)
}

data class StatementDocument(
    val Sid: String? = null,
    val Effect: AwsStatement.Effect,
    val Principal: PrincipalDocument,
    val Action: List<String> = emptyList(),
    val Resource: List<String>
)


data class PrincipalDocument(val wildcard:String, val principalEntry: Map<PrincipalEntry, String>)


