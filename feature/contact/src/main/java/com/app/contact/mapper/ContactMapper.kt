package com.app.contact.mapper

import MapFromLocalToEntity
import com.app.contact.entity.ContactEntity
import com.app.models.local.ContactLocal

class ContactMapper : MapFromLocalToEntity<ContactLocal, ContactEntity> {
    override fun mapFromLocalToEntity(model: ContactLocal): ContactEntity {
        with(model) {
            return ContactEntity(model.name, model.mobile)
        }
    }

}