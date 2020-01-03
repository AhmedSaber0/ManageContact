package com.app.contactpresentation

import androidx.lifecycle.ViewModel
import com.app.contact.usecase.ContactUseCase
import com.app.models.local.ContactLocal

class AddContactViewModel constructor(
    private val contactUseCase: ContactUseCase
) : ViewModel() {

    fun addContact(contactLocal: ContactLocal) = contactUseCase.addContact(contactLocal)
}
