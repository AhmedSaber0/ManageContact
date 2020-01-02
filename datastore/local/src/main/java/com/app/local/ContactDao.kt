package com.app.local

import androidx.lifecycle.LiveData
import com.app.models.local.ContactLocal
import io.realm.RealmResults

interface ContactDao {

    fun addContact(contactLocal: ContactLocal)
    fun deleteContact(contactLocal: ContactLocal)
    fun getAllContacts(): LiveData<RealmResults<ContactLocal>>
}