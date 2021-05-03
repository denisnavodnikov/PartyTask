package ru.navodnikov.denis.partytask.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.navodnikov.denis.partytask.ui.party.PartyViewModel

val appModule = module {
    viewModel { PartyViewModel(getPartyItemUseCase = get()) }
}