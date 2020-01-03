package com.app.contact.repository

import com.app.models.local.ContactLocal
import io.realm.RealmResults

interface ContactRepository {
    fun addContact(contactLocal: ContactLocal)
    suspend fun getAllContacts(): RealmResults<ContactLocal>
    suspend fun deleteContact(contactLocal: ContactLocal)
}