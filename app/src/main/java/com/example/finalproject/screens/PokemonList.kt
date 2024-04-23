package com.example.finalproject.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.finalproject.Pokemon
import com.example.finalproject.PokemonAdapter
import com.example.finalproject.PokemonService
import com.example.finalproject.R
import com.example.finalproject.extractPokemonId

import com.example.finalproject.modules.Header
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()


val pokemonService = retrofit.create(PokemonService::class.java)


@Composable
fun PokemonList(navController: NavController) {
    val pokemonListState = remember { mutableStateOf<List<Pokemon>>(emptyList()) }

    // Fetch Pokemon list from the API
    LaunchedEffect(Unit) {
        try {
            val response = withContext(Dispatchers.IO) {
                pokemonService.getPokemonList(0,999)
            }
            if (response.isSuccessful) {
                val pokemonList = response.body()?.results
                pokemonListState.value = pokemonList ?: emptyList()
            } else {
                Log.e("PokemonList", "Failed to fetch Pokemon list: ${response.message()}")
            }
        } catch (e: Exception) {
            Log.e("PokemonList", "Error: ${e.message}")
        }
    }

    // Display the fetched Pokemon list
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Header(title = stringResource(id = R.string.pokemon_api))
        }

        // Back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { navController.navigate("mainScreen") }) {
                Text(text = stringResource(id = R.string.back))
            }
        }

        // Spacer
        Spacer(modifier = Modifier.height(16.dp))

        // Display Pokemon list
        LazyColumn {
            items(pokemonListState.value) { pokemon ->
                val id = extractPokemonId(pokemon.url)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {


                            Image(
                                painter = rememberImagePainter(
                                    data = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png",
                                    builder = {
                                        crossfade(true)
                                        placeholder(R.drawable.placeholder_image)
                                    }
                                ),
                                contentDescription = "Image of ${pokemon.name}",
                                modifier = Modifier.size(150.dp)
                            )
                            // Display Pokemon name and ID with a Spacer for padding
                            Spacer(modifier = Modifier.width(16.dp))
                            Column {
                                Text(
                                    text = pokemon.name.replaceFirstChar { it.uppercase() },

                                    )
                                Text(
                                    text = "ID: $id",

                                    )
                            }










                            }
                    }
                }
            }
        }

    }