package com.app.contact.usecase

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.ContactMapper
import com.app.contact.repository.ContactRepository
import com.app.models.local.ContactLocal

class ContactUseCase constructor(
    private val repository: ContactRepository,
    private val mapper: ContactMapper
) {
    suspend fun getAllContacts(): List<ContactEntity> {
        return repository.getAllContacts().map {
            mapper.mapFromLocalToEntity(it)
        }
    }

    suspend fun addContact(contactLocal: ContactLocal) = repository.addContact(contactLocal)
    suspend fun deleteContact(contactLocal: ContactLocal) = repository.deleteContact(contactLocal)

}