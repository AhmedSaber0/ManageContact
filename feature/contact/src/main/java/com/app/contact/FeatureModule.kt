package com.app.contact

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.ContactUseCase
import com.app.local.contact.ContactDao
import com.app.local.contact.ContactDaoImpl
import com.app.models.local.ContactLocal
import com.app.models.mappers.MapFromLocalToEntity
import io.realm.Realm
import org.koin.core.module.Module
import org.koin.dsl.module

val featureModule = module {

    single<MapFromLocalToEntity<ContactLocal, ContactEntity>> { EntityContactMapper() }

    single<ContactRepository> { ContactRepositoryImpl(contactDaoImpl = get()) }

    factory  {
        ContactUseCase(
            contactRepository = get(),
            mapperEntity = get()
        )
    }
}
