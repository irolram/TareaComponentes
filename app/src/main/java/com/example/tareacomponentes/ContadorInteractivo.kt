package com.example.tareacomponentes


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContadorInteractivo() {
    // Variable de estado para el contador
    var contador by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar el contador
            Text(
                text = contador.toString(),
                fontSize = 50.sp
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Fila con los botones "+"
            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                // Botón "–"
                Button(
                    onClick = { contador-- },
                    enabled = contador > 0 // Desactivamos si contador == 0
                ) {
                    Text("–", fontSize = 24.sp)
                }

                // Botón "+"
                Button(
                    onClick = { contador++ }
                ) {
                    Text("+", fontSize = 24.sp)
                }
            }
        }
    }
}
