package ru.navodnikov.denis.domain.entity

data class PartyItem(
    val nameOfOrganizer: String,
    val organizerImage: String,
    val partyImage: String,
    val partyName: String,
    val visitors: List<Visitor>
)