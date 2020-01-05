package com.app.contactpresentation

import androidx.lifecycle.*
import com.app.contact.usecase.ContactsUseCase
import com.app.contactpresentation.mapper.UiContactMapper
import com.app.contactpresentation.uimodel.ContactUi
import com.app.local.utils.Result
import kotlinx.coroutines.launch

class ContactViewModel constructor(
    private val contactsUseCase: ContactsUseCase,
    private val mapperUi: UiContactMapper
) : ViewModel() {

    private val _contacts = MutableLiveData<List<ContactUi>>().apply { value = emptyList() }
    val contacts: LiveData<List<ContactUi>> = _contacts

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _noContactLabel = MutableLiveData<Int>()
    val noContactLabel: LiveData<Int> = _noContactLabel

    val emptyList: LiveData<Boolean> = Transformations.map(_contacts) {
        it.isNullOrEmpty()
    }

    init {
        getAllContacts()
    }

    private fun getAllContacts() {
        _dataLoading.value = true

        viewModelScope.launch {
            val tasksResult = contactsUseCase.getAllContacts()
            if (tasksResult is Result.Success) {
                _contacts.value = tasksResult.data.map {
                    mapperUi.mapToUiModel(it)
                }
            } else {
                _contacts.value = emptyList()
            }

            _dataLoading.value = false
        }
    }
}