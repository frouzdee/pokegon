package com.example.finalproject

import com.example.finalproject.screens.pokemonService

suspend fun fetchPokemonList(): List<Pokemon> {
    val response = pokemonService.getPokemonList(0,100000) // Assuming you have a Retrofit service set up
    return if (response.isSuccessful) {
        val pokemonList = response.body()?.results
        pokemonList?.mapNotNull { pokemon ->
            val id = extractPokemonId(pokemon.url)
            if (id != null) {
                Pokemon(
                    id = id, // Use the extracted ID here
                    name = pokemon.name,
                    url = pokemon.url,
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
                )
            } else null
        } ?: emptyList()
    } else {
        emptyList()
    }
}

fun extractPokemonId(url: String): Int {
    val segments = url.split("/")
    // The ID is the second-to-last segment in the URL
    return segments[segments.size - 2].toIntOrNull() ?: 0 // Return 0 if conversion fails
}

