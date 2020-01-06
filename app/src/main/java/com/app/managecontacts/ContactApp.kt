package com.app.managecontacts

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.app.contact.featureModule
import com.app.contactpresentation.presentationModule
import com.app.local.dataModule
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ContactApp : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)

        startKoin {
            androidLogger()
            androidContext(this@ContactApp)
            modules(
                listOf(dataModule, featureModule, presentationModule)
            )
        }
    }
}