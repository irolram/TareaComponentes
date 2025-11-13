package com.example.tareacomponentes



import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.scale



@Composable
fun ControlDeVolumen() {
    // Estado del valor del slider
    var volumen by remember { mutableStateOf(5f) } // valor inicial: 5

    // Calcular tamaño del icono según el volumen
    val escalaIcono = 0.5f + (volumen / 10f) // entre 0.5x y 1.5x del tamaño original

    // Estructura visual
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Control de volumen",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Icono que cambia de tamaño
            Icon(
                imageVector = Icons.AutoMirrored.Filled.VolumeUp,
                contentDescription = "Volumen",
                tint = Color(0xFF1E88E5),
                modifier = Modifier
                    .size(64.dp)
                    .scale(escalaIcono)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Slider (control deslizante)
            Slider(
                value = volumen,
                onValueChange = { volumen = it },
                valueRange = 0f..10f,
                steps = 9, // pasos entre 0 y 10
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Texto con valor actual
            Text(
                text = "Volumen: ${volumen.toInt()}",
                fontSize = 18.sp
            )
        }
    }
}
