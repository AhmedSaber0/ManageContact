package com.app.contact.repository

import com.app.local.utils.Result
import com.app.models.local.ContactLocal

interface ContactRepository {
    suspend fun addContact(contactLocal: ContactLocal): Boolean
    suspend fun getAllContacts(): Result<List<ContactLocal>>
    suspend fun deleteContact(mobile: String)
}