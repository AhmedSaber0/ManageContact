package com.app.local.contact

import com.app.models.local.ContactLocal
import io.realm.Realm
import io.realm.RealmResults


class ContactDaoImpl : ContactDao {
    override suspend fun addContact(contactLocal: ContactLocal): Boolean {
        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        return if (contactExists(contactLocal.mobile))
            false
        else {
            realm.insert(contactLocal)
            realm.commitTransaction()
            true
        }
    }

    private fun contactExists(mobile: String): Boolean {
        return Realm.getDefaultInstance()
            .where(ContactLocal::class.java)
            .equalTo("mobile", mobile)
            .findFirst() != null
    }


    override suspend fun deleteContact(mobile: String) {
        Realm.getDefaultInstance().executeTransactionAsync {
            val result: RealmResults<ContactLocal> =
                it.where(ContactLocal::class.java).equalTo("mobile", mobile)
                    .findAll()
            result.deleteAllFromRealm()
        }
    }

    override suspend fun getAllContacts(): List<ContactLocal> {
        val realm = Realm.getDefaultInstance()
        val realmResults =
            realm.where(ContactLocal::class.java).findAll()
        return realm.copyFromRealm(realmResults)
    }
}