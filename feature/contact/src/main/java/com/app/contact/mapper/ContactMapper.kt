package com.app.contact.mapper

import com.app.contact.entity.ContactEntity
import com.app.models.local.ContactLocal
import com.app.models.mappers.MapFromLocalToEntity

class ContactMapper : MapFromLocalToEntity<ContactLocal, ContactEntity> {
    override fun mapFromLocalToEntity(model: ContactLocal): ContactEntity {
        return ContactEntity(model.name, model.mobile)
    }

    override fun mapFromLocalToEntity(results: List<ContactLocal>): List<ContactEntity> {
        val contactEntities = mutableListOf<ContactEntity>()
        for (contact in results)
            contactEntities.add(ContactEntity(contact.name, contact.mobile))

        return contactEntities
    }

}