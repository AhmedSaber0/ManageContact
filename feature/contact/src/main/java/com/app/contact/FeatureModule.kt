package com.app.contact

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.ContactsUseCase
import com.app.models.local.ContactLocal
import com.app.models.mappers.MapFromLocalToEntity
import org.koin.dsl.module

val featureModule = module {

    single<MapFromLocalToEntity<ContactLocal, ContactEntity>> { EntityContactMapper() }

    single<ContactRepository> { ContactRepositoryImpl(contactDataSource = get()) }

    factory  {
        ContactsUseCase(
            contactRepository = get(),
            mapperEntity = get()
        )
    }
}
