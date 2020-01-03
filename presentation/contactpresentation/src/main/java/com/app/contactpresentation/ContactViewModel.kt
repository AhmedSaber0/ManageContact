package com.app.contactpresentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.app.contact.usecase.ContactUseCase
import com.app.contactpresentation.mapper.UiContactMapper
import com.app.contactpresentation.uimodel.ContactUi
import com.app.models.local.ContactLocal

class ContactViewModel constructor(
    private val contactUseCase: ContactUseCase,
    private val mapperUi: UiContactMapper
) : ViewModel() {

    fun getAllContacts(): LiveData<List<ContactUi>> {
        return liveData {
            val result = contactUseCase.getAllContacts().map {
                mapperUi.mapToUiModel(it)
            }
            emit(result)
        }
    }
}