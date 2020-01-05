package com.app.contactpresentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.contact.usecase.AddContactUseCase
import com.app.contact.usecase.ContactsUseCase
import com.app.models.local.ContactLocal

class AddContactViewModel constructor(
    private val addContactUseCase: AddContactUseCase
) : ViewModel() {

    private val _newTaskEvent = MutableLiveData<Event<Unit>>()
    val newTaskEvent: LiveData<Event<Unit>> = _newTaskEvent

    fun addContact(contactLocal: ContactLocal) {
        _newTaskEvent.value = Event(Unit)

//        addContactUseCase.addContact(contactLocal)
    }
}
