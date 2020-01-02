package com.app.contact.repository

import com.app.local.ContactDaoImpl
import com.app.models.local.ContactLocal
import io.realm.RealmResults

class ContactRepository constructor(
    private val local: ContactDaoImpl
) {

    suspend fun addContact(contactLocal: ContactLocal) {
        local.addContact(contactLocal)
    }

    suspend fun getAllContacts(): RealmResults<ContactLocal> {
        return local.getAllContacts()
    }

    suspend fun deleteContact(contactLocal: ContactLocal) {
        local.deleteContact(contactLocal)
    }
}