package com.example.tareacomponentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GaleriaElementos() {
    // Estado para el icono de favorito
    var favorito by remember { mutableStateOf(false) }

    // Superficie para centrar todo
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Fila con 3 imágenes
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ImageItem(R.drawable.cucurella, "Imagen 1")
                ImageItem(R.drawable.nico, "Imagen 2")
                ImageItem(R.drawable.yeremay, "Imagen 3")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Icono de favorito que cambia de color al pulsarlo
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorito",
                tint = if (favorito) Color.Red else Color.Gray,
                modifier = Modifier.size(48.dp).clickable { favorito = !favorito }
            )
        }
    }
}

@Composable
fun ImageItem(imageRes: Int, descripcion: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen redondeada
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = descripcion,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Texto descriptivo debajo de la imagen
        Text(text = descripcion, fontSize = 14.sp)
    }
}
