package com.app.local.contact

import com.app.local.utils.await
import com.app.models.local.ContactLocal
import io.realm.Realm
import io.realm.RealmResults


class ContactDaoImpl(private val realm: Realm) : ContactDao {
    override  fun addContact(contactLocal: ContactLocal) {
        Realm.getDefaultInstance().executeTransactionAsync {
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

    override suspend fun getAllContacts(): RealmResults<ContactLocal> {
        return Realm.getDefaultInstance().where(ContactLocal::class.java).await()
    }
}