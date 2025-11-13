package com.example.tareacomponentes


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun DialogMatrixScreen() {
    // 1️⃣ Estados
    var showDialog by remember { mutableStateOf(false) }
    var showMorfeoImage by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botón para abrir el diálogo
            Button(onClick = { showDialog = true }) {
                Text("Elegir pastilla")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Mostrar imagen de Morfeo si se eligió la pastilla roja
            if (showMorfeoImage) {
                Image(
                    painter = painterResource(id = R.drawable.morfeo),
                    contentDescription = "Morfeo",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(16.dp)
                )
            }

            // Diálogo
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false }, // cuando se toca fuera
                    title = { Text("Elige tu destino") },
                    text = { Text("¿Qué pastilla eliges?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                // Pastilla Azul → solo cerrar diálogo
                                showDialog = false
                            }
                        ) {
                            Text("Pastilla Azul")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                // Pastilla Roja → cerrar diálogo y mostrar Morfeo
                                showDialog = false
                                showMorfeoImage = true
                            }
                        ) {
                            Text("Pastilla Roja")
                        }
                    },
                    shape = RoundedCornerShape(12.dp)
                )
            }
        }
    }
}