package com.example.finalproject.modules

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Header(title: String) {
    Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
}
