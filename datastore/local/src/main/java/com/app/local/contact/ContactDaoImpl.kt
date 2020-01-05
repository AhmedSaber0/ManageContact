package com.app.local.contact

import com.app.models.local.ContactLocal
import io.realm.Realm
import io.realm.RealmResults


class ContactDaoImpl(private val realm: Realm = Realm.getDefaultInstance()) : ContactDao {
    override suspend fun addContact(contactLocal: ContactLocal) {
        Realm.getDefaultInstance().executeTransaction {
            it.insert(contactLocal)
        }
    }

    override suspend fun deleteContact(contactLocal: ContactLocal) {
        Realm.getDefaultInstance().executeTransactionAsync {
            val result: RealmResults<ContactLocal> =
                it.where(ContactLocal::class.java).equalTo("mobile", contactLocal.mobile)
                    .findAll()
            result.deleteAllFromRealm()
        }
    }

    override suspend fun getAllContacts(): List<ContactLocal> {
        val realmResults =
            Realm.getDefaultInstance().where(ContactLocal::class.java).findAll()
        return Realm.getDefaultInstance().copyFromRealm(realmResults)
    }
}