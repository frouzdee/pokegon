package com.example.finalproject.screens

import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.finalproject.R

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.pokegon),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, // Add spacing between buttons
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = { navController.navigate("PokemonList") },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp) // Set a fixed height for the button
                .clip(RoundedCornerShape(8.dp)), // Apply rounded corners to the button
            contentPadding = PaddingValues(horizontal = 16.dp), // Add horizontal padding
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = stringResource(id = R.string.pokemon_api),
                        fontSize = 20.sp, // Set text size
                        fontWeight = FontWeight.Bold // Set text weight
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { navController.navigate("CameraScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp) // Set a fixed height for the button
                .clip(RoundedCornerShape(8.dp)), // Apply rounded corners to the button
            contentPadding = PaddingValues(horizontal = 16.dp), // Add horizontal padding
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = stringResource(id = R.string.camera),
                        fontSize = 20.sp, // Set text size
                        fontWeight = FontWeight.Bold // Set text weight
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { navController.navigate("InstructionScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp) // Set a fixed height for the button
                .clip(RoundedCornerShape(8.dp)), // Apply rounded corners to the button
            contentPadding = PaddingValues(horizontal = 16.dp), // Add horizontal padding
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        text = stringResource(id = R.string.ins),
                        fontSize = 20.sp, // Set text size
                        fontWeight = FontWeight.Bold // Set text weight
                    )
                }
            }
        }

    }





}

