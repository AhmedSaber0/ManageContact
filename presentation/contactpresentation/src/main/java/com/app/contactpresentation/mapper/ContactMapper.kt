package com.app.contactpresentation.mapper

import com.app.contact.entity.ContactEntity
import com.app.contactpresentation.uimodel.ContactUi
import com.app.models.mappers.MapFromEntityToUi

class ContactMapper : MapFromEntityToUi<ContactEntity, ContactUi> {
    override fun mapToUiModel(model: ContactEntity): ContactUi {
        return ContactUi(model.name, model.mobile)
    }

    override fun mapToUiModelList(model: List<ContactEntity>): List<ContactUi> {
        return model.map {
            ContactUi(it.name, it.mobile)
        }
    }

}