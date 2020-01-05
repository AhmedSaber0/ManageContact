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

    private val _items = MutableLiveData<List<ContactUi>>().apply { value = emptyList() }
    val items: LiveData<List<ContactUi>> = _items

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    private val _noTasksLabel = MutableLiveData<Int>()
    val noTasksLabel: LiveData<Int> = _noTasksLabel

    // Not used at the moment
    private val isDataLoadingError = MutableLiveData<Boolean>()

    init {
        getAllContacts()
    }

    fun getAllContacts(){
        _dataLoading.value = true

        viewModelScope.launch {
            val tasksResult = contactsUseCase.getAllContacts()
            if (tasksResult is Result.Success) {
                isDataLoadingError.value = false
                _items.value = tasksResult.data.map {
                    mapperUi.mapToUiModel(it)
                }
            } else {
                isDataLoadingError.value = false
                _items.value = emptyList()
            }

            _dataLoading.value = false
        }
    }
//
//    fun getAllContacts(): LiveData<List<ContactUi>> {
//        return liveData {
//            val result = contactsUseCase.getAllContacts().map {
//                mapperUi.mapToUiModel(it)
//            }
//            emit(result)
//        }
//    }
}