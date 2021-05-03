package ru.navodnikov.denis.partytask.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.navodnikov.denis.partytask.BuildConfig
import ru.navodnikov.denis.partytask.di.appModule
import ru.navodnikov.denis.partytask.di.dataModule
import ru.navodnikov.denis.partytask.di.domainModule

class PartyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            if(BuildConfig.DEBUG) {
                androidLogger(Level.ERROR)
            } else {
                androidLogger()
            }
            androidContext(this@PartyApp)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}