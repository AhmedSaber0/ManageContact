package com.app.managecontacts

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import io.realm.Realm

class ContactApp : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}