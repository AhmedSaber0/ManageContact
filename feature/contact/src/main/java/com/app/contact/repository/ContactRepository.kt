package com.app.contact.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.contact.mapper.ContactMapper
import com.app.local.ContactDao
import com.app.models.local.ContactLocal

class ContactRepository constructor(
    private val local: ContactDao,
    private val mapper: ContactMapper
) {
    fun addContact(contactLocal: ContactLocal): LiveData<Boolean> {
        val result = MutableLiveData<Boolean>()
        result.postValue(true)
        return result
    }

    fun getAllContacts(): LiveData<List<ContactLocal>> {
        val result = MutableLiveData<List<ContactLocal>>()
        val contacts = listOf(
            ContactLocal("ahmed", "01147871983"),
            ContactLocal("ali", "01016351613")
        )
        result.postValue(contacts)
        return result
    }

    fun deleteContact(): LiveData<Boolean> {
        val result = MutableLiveData<Boolean>()
        result.postValue(true)
        return result
    }
}