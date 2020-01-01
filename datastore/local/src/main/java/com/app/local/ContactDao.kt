package com.app.local

import com.app.models.local.ContactLocal

interface ContactDao {

    fun addContact(contactLocal: ContactLocal)
    fun deleteContact(contactLocal: ContactLocal)
    fun getAllContacts(contactLocal: List<ContactLocal>)
}