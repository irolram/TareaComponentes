package com.example.tareacomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun CargaSimulada() {

    //  Variables de estado
    var cargando by remember { mutableStateOf(false) }
    var mensaje by remember { mutableStateOf("Pulsa el botón para iniciar la carga") }


    // Alcance para lanzar corrutinas desde el botón
    val scope = rememberCoroutineScope()

    // Estructura principal
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Texto del estado actual
            Text(text = mensaje)

            Spacer(modifier = Modifier.height(24.dp))

            // Si está cargando, mostramos el indicador
            if (cargando) {
                CircularProgressIndicator()
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para iniciar la carga
            Button(
                onClick = {
                    // Lanzamos una corrutina cuando se pulsa
                    scope.launch {
                        cargando = true
                        mensaje = "Cargando..."
                        delay(3000) // Simula una carga de 3 segundos
                        cargando = false
                        mensaje = "Carga finalizada"
                    }
                },
                enabled = !cargando // desactiva el botón mientras carga
            ) {
                Text("Iniciar carga")
            }
        }
    }
}