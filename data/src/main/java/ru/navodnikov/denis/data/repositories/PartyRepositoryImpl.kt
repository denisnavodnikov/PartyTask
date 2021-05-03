package ru.navodnikov.denis.data.repositories

import kotlinx.coroutines.flow.Flow
import ru.navodnikov.denis.data.storage.Storage
import ru.navodnikov.denis.domain.entity.PartyItem
import ru.navodnikov.denis.domain.repositories.PartyRepository

class PartyRepositoryImpl(private val storage: Storage): PartyRepository {
    override fun getPartyItem(): Flow<PartyItem> {
        return storage.getPartyItem()
    }
}