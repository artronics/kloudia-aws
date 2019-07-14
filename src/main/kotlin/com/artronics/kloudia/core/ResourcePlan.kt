package com.artronics.kloudia.core

interface ResourcePlan {
    var renameStrategy: RenameStrategy
}

class BaseResourcePlan : ResourcePlan {
    override var renameStrategy: RenameStrategy = IdentityRenameStrategy
}
