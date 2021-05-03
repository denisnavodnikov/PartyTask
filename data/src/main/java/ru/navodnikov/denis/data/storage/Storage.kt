package ru.navodnikov.denis.data.storage

import kotlinx.coroutines.flow.Flow
import ru.navodnikov.denis.domain.entity.PartyItem

interface Storage {
    fun getPartyItem(): Flow<PartyItem>
}