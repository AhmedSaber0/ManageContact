package com.app.contact.repository

import androidx.lifecycle.LiveData
import com.app.local.ContactDaoImpl
import com.app.models.local.ContactLocal
import io.realm.RealmResults

class ContactRepository constructor(
    private val local: ContactDaoImpl
) {

    fun addContact(contactLocal: ContactLocal) {
        local.addContact(contactLocal)
    }

    fun getAllContacts(): LiveData<RealmResults<ContactLocal>> {
        return local.getAllContacts()
    }

    fun deleteContact(contactLocal: ContactLocal) {
        local.deleteContact(contactLocal)
    }
}