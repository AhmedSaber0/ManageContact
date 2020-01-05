package com.app.local.contact

import com.app.models.local.ContactLocal

interface ContactDao {

    suspend fun addContact(contactLocal: ContactLocal)
    suspend fun deleteContact(contactLocal: ContactLocal)
    suspend fun getAllContacts(): List<ContactLocal>
}