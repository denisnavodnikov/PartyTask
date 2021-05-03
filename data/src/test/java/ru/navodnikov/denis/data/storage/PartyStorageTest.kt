package ru.navodnikov.denis.data.storage

import android.content.Context
import android.content.res.AssetManager
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.mockkStatic
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import ru.navodnikov.denis.data.utils.readAssetsFile
import ru.navodnikov.denis.domain.entity.PartyItem
import ru.navodnikov.denis.domain.entity.Visitor

@ExtendWith(MockKExtension::class)
class PartyStorageTest {

    private lateinit var json: String
    private lateinit var expectedItem: PartyItem
    private lateinit var result: Flow<PartyItem>

    @MockK
    private lateinit var contextMock: Context

    @MockK
    private lateinit var assetManagerMock: AssetManager


    @BeforeEach
    fun setUp() {
        json = """{
   "nameOfOrganizer": "Кристина",
   "partyName": "Именины",
   "partyImage": "https://partyImage",
   "organizerImage": "https://organizerImage",
   "visitors":[
      {
         "name":"Роберт",
         "imageUrl":"https://imageUrl"
      }
   ]
}"""
        expectedItem = PartyItem(
            nameOfOrganizer = "Кристина",
            organizerImage = "https://organizerImage",
            partyImage = "https://partyImage",
            partyName = "Именины",
            visitors = listOf(Visitor(name = "Роберт", imageUrl = "https://imageUrl"))
        )
    }

    @Test
    fun getPartyItem_test() {
        every { contextMock.assets } returns assetManagerMock
        mockkStatic(AssetManager::readAssetsFile)
        every { assetManagerMock.readAssetsFile("party.json") } returns json
        val storage = PartyStorage(contextMock)
        val flow = storage.getPartyItem()
        runBlocking {
            assertEquals(expectedItem, flow.first())
        }
    }
}