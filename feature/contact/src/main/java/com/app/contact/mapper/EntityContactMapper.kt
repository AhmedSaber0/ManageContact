package com.app.contact.mapper

import com.app.contact.entity.ContactEntity
import com.app.models.local.ContactLocal
import com.app.models.mappers.MapFromLocalToEntity

class EntityContactMapper : MapFromLocalToEntity<ContactLocal, ContactEntity> {
    override fun mapFromLocalToEntity(localModel: ContactLocal): ContactEntity {
        return ContactEntity(localModel.name, localModel.mobile)
    }

    override fun mapFromLocalToEntity(localModels: List<ContactLocal>): List<ContactEntity> {
        val contactEntities = mutableListOf<ContactEntity>()
        for (contact in localModels)
            contactEntities.add(ContactEntity(contact.name, contact.mobile))

        return contactEntities
    }

}