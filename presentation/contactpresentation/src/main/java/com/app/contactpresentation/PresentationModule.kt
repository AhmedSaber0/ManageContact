package com.app.contactpresentation

import com.app.contact.entity.ContactEntity
import com.app.contact.mapper.EntityContactMapper
import com.app.contact.repository.ContactRepository
import com.app.contact.repository.ContactRepositoryImpl
import com.app.contact.usecase.ContactsUseCase
import com.app.contactpresentation.mapper.UiContactMapper
import com.app.contactpresentation.uimodel.ContactUi
import com.app.local.contact.ContactDao
import com.app.local.contact.ContactDaoImpl
import com.app.models.local.ContactLocal
import com.app.models.mappers.MapFromEntityToUi
import com.app.models.mappers.MapFromLocalToEntity
import io.realm.Realm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { Realm.getDefaultInstance() }

    single { ContactDaoImpl(realm = get()) as ContactDao }

    single<MapFromLocalToEntity<ContactLocal, ContactEntity>> { EntityContactMapper() }

    single<ContactRepository> { ContactRepositoryImpl(contactDataSource = get()) }

    factory  {
        ContactsUseCase(
            contactRepository = get(),
            mapperEntity = get()
        )
    }

    single<MapFromEntityToUi<ContactEntity,ContactUi>> { UiContactMapper() }

    viewModel { ContactViewModel(contactsUseCase = get(), mapperUi = get()) }
}