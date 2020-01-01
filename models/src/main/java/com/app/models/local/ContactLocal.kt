package com.app.models.local

import io.realm.RealmObject

data class ContactLocal(
    val name: String,
    val mobile: String
) : RealmObject()
