package com.app.local.contact

import com.app.local.utils.Result
import com.app.models.local.ContactLocal

interface ContactDataSource{

    suspend fun addContact(contactLocal: ContactLocal): Boolean
    suspend fun deleteContact(mobile: String)
    suspend fun getAllContacts(): Result<List<ContactLocal>>
}