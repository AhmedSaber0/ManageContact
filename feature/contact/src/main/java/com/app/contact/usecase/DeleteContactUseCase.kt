package com.app.contact.usecase

import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository

class DeleteContactUseCase constructor(
    private val contactRepository: ContactRepository,
    private val mapperEntity: EntityContactMapper
) {
    suspend fun deleteContact(mobile: String) = contactRepository.deleteContact(mobile)
}