package com.app.managecontacts

import com.app.contact.featureModule
import com.app.contactpresentation.presentationModule
import com.app.local.dataModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

object ContactModules {
    fun init() {
        loadKoinModules(
            listOf(
                dataModule,
                featureModule,
                presentationModule
            )
        )
    }
}

fun injectFeature() = loadFeature
fun unloadKoinModules() = unLoadFeature

private val loadFeature by lazy {
    loadKoinModules(
        listOf(
            presentationModule
        )
    )
}

private val unLoadFeature by lazy {
    unloadKoinModules(
        listOf(
            presentationModule
        )
    )
}