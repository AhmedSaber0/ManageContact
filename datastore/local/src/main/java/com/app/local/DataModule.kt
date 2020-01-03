package com.app.local

import com.app.local.contact.ContactDao
import com.app.local.contact.ContactDaoImpl
import io.realm.Realm
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule = module {

    single { Realm.getDefaultInstance() }

    single { ContactDaoImpl(realm = get()) as ContactDao }
}