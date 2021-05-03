package ru.navodnikov.denis.partytask.di

import org.koin.dsl.module
import ru.navodnikov.denis.domain.usecases.GetPartyItemUseCase

val domainModule = module {
    single { GetPartyItemUseCase(partyRepository = get()) }
}