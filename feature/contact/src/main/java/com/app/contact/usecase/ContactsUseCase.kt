package com.app.contact.usecase

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.local.utils.Result

class ContactsUseCase constructor(
    private val contactRepository: ContactRepository,
    private val mapperEntity: EntityContactMapper
) {
    suspend fun getAllContacts(): Result<List<ContactEntity>> {
        val contactsResult = contactRepository.getAllContacts()
        if (contactsResult is Result.Success) {
            val contacts = contactsResult.data
            return Result.Success(contacts.map {
                mapperEntity.mapFromLocalToEntity(it)
            })
        }
        return Result.Error(Exception())
    }
}