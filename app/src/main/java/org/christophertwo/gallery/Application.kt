package org.christophertwo.gallery

import android.app.Application
import org.christophertwo.gallery.di.DataModule
import org.christophertwo.gallery.di.DomainModule
import org.christophertwo.gallery.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

class Application : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@Application)
            modules(
                listOf(
                    ViewModelModule,
                    DataModule,
                    DomainModule
                )
            )
        }
    }
}