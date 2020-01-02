package com.app.local

import androidx.lifecycle.LiveData
import com.app.local.utils.asLiveData
import com.app.models.local.ContactLocal
import io.realm.Realm
import io.realm.RealmResults


class ContactDaoImpl(private val realm: Realm) : ContactDao {
    override fun addContact(contactLocal: ContactLocal) {
        realm.executeTransactionAsync {
            it.insert(contactLocal)
        }
    }

    override fun deleteContact(contactLocal: ContactLocal) {
        realm.executeTransactionAsync {
            val result: RealmResults<ContactLocal> =
                it.where(ContactLocal::class.java).equalTo("mobile", contactLocal.mobile)
                    .findAll()
            result.deleteAllFromRealm()
        }
    }

    override fun getAllContacts():
            LiveData<RealmResults<ContactLocal>> {
        return realm.where(ContactLocal::class.java).findAll().asLiveData()
    }
}