package com.app.contact

import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.AddContactUseCase
import com.app.contact.usecase.ContactsUseCase
import com.app.contact.usecase.DeleteContactUseCase
import org.koin.dsl.module

val featureModule = module {

    single { EntityContactMapper() }

    single<ContactRepository> { ContactRepositoryImpl(contactDataSource = get()) }

    factory {
        ContactsUseCase(
            contactRepository = get(),
            mapperEntity = get()
        )
    }

    factory {
        AddContactUseCase(
            contactRepository = get(),
            mapperEntity = get()
        )
    }

    factory {
        DeleteContactUseCase(
            contactRepository = get(),
            mapperEntity = get()
        )
    }
}
