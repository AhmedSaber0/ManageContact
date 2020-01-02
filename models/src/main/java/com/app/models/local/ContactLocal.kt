package com.app.models.local

import io.realm.RealmObject

open class ContactLocal(
    var name: String,
    var mobile: String
) : RealmObject() {
    constructor() : this("", "")
}
