package ru.navodnikov.denis.data.storage

import android.content.Context
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.navodnikov.denis.data.utils.NAME_OF_JSON
import ru.navodnikov.denis.data.utils.readAssetsFile
import ru.navodnikov.denis.domain.entity.PartyItem

class PartyStorage(private val context: Context) : Storage {
    override fun getPartyItem(): Flow<PartyItem> {
        val gson = Gson()
        val partyItem: PartyItem =
            gson.fromJson(context.assets.readAssetsFile(NAME_OF_JSON), PartyItem::class.java)
        return flowOf(partyItem)
    }
}