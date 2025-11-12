package com.example.tareacomponentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
//Diversos tipos de texto
fun PantallaBienvenida() {
    // Variables dinámicas
    val saludo = "¡Hola"
    val nombre = "Iván!"

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE3F2FD) // Fondo azul claro
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Texto principal (saludo dinámico)
            Text(
                text = "$saludo $nombre",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1565C0),
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Subtítulo decorativo
            Text(
                text = "Bienvenido a tu aplicación Compose",
                fontSize = 20.sp,
                color = Color.Black,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Texto con fuente diferente
            Text(
                text = "Explora, aprende y disfruta del código.",
                fontSize = 18.sp,
                color = Color(0xFF512DA8),
                fontFamily = FontFamily.Monospace
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Texto pequeño con color gris y espaciado
            Text(
                text = "Versión 3.0.5.0",
                fontSize = 14.sp,
                color = Color.Gray,
                letterSpacing = 2.sp
            )
        }
    }
}