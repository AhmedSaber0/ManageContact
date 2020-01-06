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

    private val _addContactErrorVisible = MutableLiveData<Boolean>()
    val addContactErrorVisible: LiveData<Boolean> = _addContactErrorVisible

    fun addContact(contactLocal: ContactLocal) = viewModelScope.launch {
        _addContactErrorVisible.value = addContactUseCase.addContact(contactLocal)
    }
}
