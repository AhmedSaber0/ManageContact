package com.app.local.contact

import com.app.models.local.ContactLocal
import io.realm.RealmResults

interface ContactDao {

    fun addContact(contactLocal: ContactLocal)
    suspend fun deleteContact(contactLocal: ContactLocal)
    suspend fun getAllContacts(): RealmResults<ContactLocal>
}