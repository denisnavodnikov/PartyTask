package ru.navodnikov.denis.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ru.navodnikov.denis.domain.entity.PartyItem
import ru.navodnikov.denis.domain.repositories.PartyRepository

class GetPartyItemUseCase(private val partyRepository: PartyRepository) {
    fun execute(): Flow<PartyItem> {
        return partyRepository.getPartyItem()
    }
}