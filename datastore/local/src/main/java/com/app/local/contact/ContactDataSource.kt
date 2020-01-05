package com.app.local.contact

import com.app.local.utils.Result
import com.app.models.local.ContactLocal
import io.realm.RealmResults

interface ContactDataSource{

    suspend fun addContact(contactLocal: ContactLocal)
    suspend fun deleteContact(contactLocal: ContactLocal)
    suspend fun getAllContacts(): Result<List<ContactLocal>>
}