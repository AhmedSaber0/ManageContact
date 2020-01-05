package com.app.local.contact

import com.app.local.utils.Result
import com.app.models.local.ContactLocal
import io.realm.RealmResults
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactLocalDataSource constructor(
    private val contactDao: ContactDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ContactDataSource {

    override suspend fun addContact(contactLocal: ContactLocal) = withContext(ioDispatcher) {
        contactDao.addContact(contactLocal)
    }

    override suspend fun deleteContact(contactLocal: ContactLocal) = withContext(ioDispatcher) {
        contactDao.deleteContact(contactLocal)
    }

    override suspend fun getAllContacts(): Result<List<ContactLocal>> =
        withContext(ioDispatcher) {
            return@withContext try {
                Result.Success(contactDao.getAllContacts())
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}