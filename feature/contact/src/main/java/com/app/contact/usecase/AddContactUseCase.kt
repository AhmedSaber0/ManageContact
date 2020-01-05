package com.app.contact.usecase

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.models.local.ContactLocal

class AddContactUseCase constructor(
    private val contactRepository: ContactRepository,
    private val mapperEntity: EntityContactMapper
) {
    suspend fun addContact(contactLocal: ContactLocal) = contactRepository.addContact(contactLocal)
}