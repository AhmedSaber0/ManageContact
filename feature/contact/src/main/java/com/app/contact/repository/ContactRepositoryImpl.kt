package com.app.contact.repository

import com.app.local.contact.ContactDaoImpl
import com.app.models.local.ContactLocal
import io.realm.RealmResults

class ContactRepositoryImpl constructor(
    private val contactDaoImpl: ContactDaoImpl
) : ContactRepository{

    override  fun addContact(contactLocal: ContactLocal) {
        contactDaoImpl.addContact(contactLocal)
    }

    override suspend fun getAllContacts(): RealmResults<ContactLocal> {
        return contactDaoImpl.getAllContacts()
    }

    override suspend fun deleteContact(contactLocal: ContactLocal) {
        contactDaoImpl.deleteContact(contactLocal)
    }
}