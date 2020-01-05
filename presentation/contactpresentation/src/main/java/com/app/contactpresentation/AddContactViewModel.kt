package com.app.contactpresentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.contact.usecase.AddContactUseCase
import com.app.models.local.ContactLocal
import kotlinx.coroutines.launch

class AddContactViewModel constructor(
    private val addContactUseCase: AddContactUseCase
) : ViewModel() {

    private val _newContactEvent = MutableLiveData<Event<Unit>>()
    val newContactEvent: LiveData<Event<Unit>> = _newContactEvent

    fun addContact(contactLocal: ContactLocal) = viewModelScope.launch {
        addContactUseCase.addContact(contactLocal)
        _newContactEvent.value = Event(Unit)
    }
}
