package com.app.contact.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.ContactMapper
import com.app.contact.repository.ContactRepository
import com.app.models.local.ContactLocal

class ContactUseCase constructor(
    private val repository: ContactRepository,
    private val mapper: ContactMapper
) {
    fun getAllContacts(): LiveData<List<ContactEntity>> {
        return Transformations.map(repository.getAllContacts()) { result ->
            mapper.mapFromLocalToEntity(result)
        }
    }

    fun addContact(contactLocal: ContactLocal) = repository.addContact(contactLocal)
    fun deleteContact(contactLocal: ContactLocal) = repository.deleteContact(contactLocal)

}