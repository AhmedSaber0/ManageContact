package com.app.models.local

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ContactLocal(
    var name: String,
    @PrimaryKey
    var mobile: String
) : RealmObject() {
    constructor() : this("", "")
}
