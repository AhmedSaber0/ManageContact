package com.app.local

import com.app.local.contact.ContactDao
import com.app.local.contact.ContactDaoImpl
import com.app.local.contact.ContactDataSource
import com.app.local.contact.ContactLocalDataSource
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {

    single { Dispatchers.IO }

    single { ContactDaoImpl() as ContactDao }

    single { ContactLocalDataSource(contactDao = get(), ioDispatcher = get()) as ContactDataSource }
}