package com.app.contactpresentation

import androidx.lifecycle.ViewModel
import com.app.contact.usecase.ContactUseCase
import com.app.models.local.ContactLocal

class ContactViewModel constructor(private val contactUseCase: ContactUseCase) : ViewModel() {

    val getAllContacts = contactUseCase.getAllContacts()
    fun addContact(contactLocal: ContactLocal) = contactUseCase.addContact(contactLocal)
    fun deleteContact() = contactUseCase.getAllContacts()
}