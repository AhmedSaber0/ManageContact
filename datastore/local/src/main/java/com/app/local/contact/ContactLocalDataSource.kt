package com.app.local.contact

import com.app.local.utils.Result
import com.app.models.local.ContactLocal
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ContactLocalDataSource constructor(
    private val contactDao: ContactDao,
    private val ioDispatcher: CoroutineDispatcher
) : ContactDataSource {

    override suspend fun addContact(contactLocal: ContactLocal) = withContext(ioDispatcher) {
        contactDao.addContact(contactLocal)
    }

    override suspend fun deleteContact(mobile: String) = withContext(ioDispatcher) {
        contactDao.deleteContact(mobile)
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