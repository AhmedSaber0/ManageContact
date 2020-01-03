package com.app.contact.usecase

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.models.local.ContactLocal

class ContactUseCase constructor(
    private val contactRepository: ContactRepository,
    private val mapperEntity: EntityContactMapper
) {
    suspend fun getAllContacts(): List<ContactEntity> {
        return contactRepository.getAllContacts().map {
            mapperEntity.mapFromLocalToEntity(it)
        }
    }

    fun addContact(contactLocal: ContactLocal) = contactRepository.addContact(contactLocal)
    suspend fun deleteContact(contactLocal: ContactLocal) = contactRepository.deleteContact(contactLocal)

}