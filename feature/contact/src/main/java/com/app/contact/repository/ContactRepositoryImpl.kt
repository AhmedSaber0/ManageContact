package com.app.contact.repository

import com.app.local.contact.ContactDataSource
import com.app.local.utils.Result
import com.app.models.local.ContactLocal

class ContactRepositoryImpl constructor(
    private val contactDataSource: ContactDataSource
) : ContactRepository{

    override suspend fun addContact(contactLocal: ContactLocal): Boolean {
        return contactDataSource.addContact(contactLocal)
    }

    override suspend fun getAllContacts(): Result<List<ContactLocal>> {
        return contactDataSource.getAllContacts()
    }

    override suspend fun deleteContact(mobile: String) {
        contactDataSource.deleteContact(mobile)
    }
}