package com.app.contactpresentation.mapper

import com.app.contact.entity.ContactEntity
import com.app.contactpresentation.uimodel.ContactUi
import com.app.models.mappers.MapFromEntityToUi

class UiContactMapper : MapFromEntityToUi<ContactEntity, ContactUi> {
    override fun mapToUiModel(uiModel : ContactEntity): ContactUi {
        return ContactUi(uiModel.name, uiModel.mobile)
    }

    override fun mapToUiModelList(uiModels: List<ContactEntity>): List<ContactUi> {
        return uiModels.map {
            ContactUi(it.name, it.mobile)
        }
    }

}