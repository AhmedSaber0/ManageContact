package com.app.contactpresentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.app.contact.usecase.ContactUseCase
import com.app.contactpresentation.mapper.ContactMapper
import com.app.contactpresentation.uimodel.ContactUi
import com.app.models.local.ContactLocal

class ContactViewModel constructor(
    private val contactUseCase: ContactUseCase,
    private val mapper: ContactMapper
) : ViewModel() {

    fun getAllContacts(): LiveData<List<ContactUi>> {
//        return liveData(Dispatchers.IO) {
        return Transformations.map(contactUseCase.getAllContacts()) { contacts ->
            mapper.mapToUiModelList(contacts)
        }
//            emitSource(result)
//        }
    }

    fun addContact(contactLocal: ContactLocal) = contactUseCase.addContact(contactLocal)
    fun deleteContact() = contactUseCase.getAllContacts()
}