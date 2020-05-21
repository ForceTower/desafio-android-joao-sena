package dev.forcetower.heroes.core.model.persistence

data class MarvelCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: String
)