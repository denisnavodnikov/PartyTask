package ru.navodnikov.denis.partytask.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import ru.navodnikov.denis.data.repositories.PartyRepositoryImpl
import ru.navodnikov.denis.data.storage.PartyStorage
import ru.navodnikov.denis.data.storage.Storage
import ru.navodnikov.denis.domain.repositories.PartyRepository

val dataModule = module {
    single<Storage> { PartyStorage(context = androidApplication()) }
    single<PartyRepository> { PartyRepositoryImpl(storage = get()) }
}