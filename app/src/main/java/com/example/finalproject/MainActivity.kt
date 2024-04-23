package com.example.finalproject

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject.screens.MainScreen
import com.example.finalproject.Theme.FinalProjectTheme
import com.example.finalproject.screens.CameraScreen
import com.example.finalproject.screens.InstructionScreen
import com.example.finalproject.screens.PokemonList

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") { MainScreen(navController) }
                    composable("pokemonList") { PokemonList(navController) }
                    composable("cameraScreen") { CameraScreen(navController) }
                    composable("instructionScreen") { InstructionScreen(navController) }
                }
            }
        }
    }
}