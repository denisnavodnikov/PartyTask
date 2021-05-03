package ru.navodnikov.denis.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.navodnikov.denis.domain.entity.PartyItem

interface PartyRepository {
    fun getPartyItem(): Flow<PartyItem>
}