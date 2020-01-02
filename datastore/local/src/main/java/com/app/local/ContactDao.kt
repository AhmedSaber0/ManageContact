package com.app.local

import com.app.models.local.ContactLocal
import io.realm.RealmResults

interface ContactDao {

    suspend fun addContact(contactLocal: ContactLocal)
    suspend fun deleteContact(contactLocal: ContactLocal)
    suspend fun getAllContacts(): RealmResults<ContactLocal>
}