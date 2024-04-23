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
import com.example.finalproject.R
import com.example.finalproject.CameraActivity

@Composable
fun CameraScreen(navController: NavController) {
    val context = LocalContext.current
    val intent = Intent(context, CameraActivity::class.java)
    context.startActivity(intent)

    navController.navigate("mainScreen")
}