package com.app.local.contact

import com.app.models.local.ContactLocal

interface ContactDao {

    suspend fun addContact(contactLocal: ContactLocal): Boolean
    suspend fun deleteContact(mobile: String)
    suspend fun getAllContacts(): List<ContactLocal>
}