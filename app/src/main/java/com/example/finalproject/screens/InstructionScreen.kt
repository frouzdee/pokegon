package com.example.finalproject.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.finalproject.R
import com.example.finalproject.CameraActivity

@Composable
fun InstructionScreen(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { navController.navigate("mainScreen") }) {
            Text(text = stringResource(id = R.string.back))
        }
    }

    Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(16.dp),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Image(
             painter = painterResource(id = R.drawable.instruction),
             contentDescription = null,
             modifier = Modifier.size(500.dp)
         )

         Spacer(modifier = Modifier.height(16.dp))

     }
}