package com.app.contactpresentation

import com.app.contactpresentation.mapper.UiContactMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    single { UiContactMapper() }

    viewModel {
        ContactViewModel(
            contactsUseCase = get(),
            deleteContactUseCase = get(),
            mapperUi = get()
        )
    }
    viewModel { AddContactViewModel(addContactUseCase = get()) }
}