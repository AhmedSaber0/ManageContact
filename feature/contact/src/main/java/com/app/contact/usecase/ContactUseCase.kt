package com.app.contact.usecase

import com.app.contact.repository.ContactRepository
import com.app.models.local.ContactLocal

class ContactUseCase constructor(
    val repository: ContactRepository
) {

    fun getAllContacts() = repository.getAllContacts()
    fun addContact(local: ContactLocal) = repository.addContact(local)
    fun deleteContact() = repository.deleteContact()

}