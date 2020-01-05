package com.app.contact.repository

import com.app.local.utils.Result
import com.app.models.local.ContactLocal
import io.realm.RealmResults

interface ContactRepository {
    suspend fun addContact(contactLocal: ContactLocal)
    suspend fun getAllContacts(): Result<List<ContactLocal>>
    suspend fun deleteContact(contactLocal: ContactLocal)
}