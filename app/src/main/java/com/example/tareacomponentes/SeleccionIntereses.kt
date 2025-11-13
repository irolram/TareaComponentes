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
import androidx.compose.ui.unit.sp



@Composable
fun SeleccionDeIntereses() {

    // Lista de aficiones posibles
    val aficiones = listOf("Música", "Deporte", "Lectura", "Cine", "Viajar", "Videojuegos")

    // Estado: mapa de afición -> seleccionado
    var seleccion by remember {
        mutableStateOf(
            aficiones.associateWith { false } // todas desmarcadas al inicio
        )
    }

    // Calcular las seleccionadas
    val seleccionadas = seleccion.filterValues { it }.keys.joinToString(", ")

    // Interfaz
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Selecciona tus aficiones:",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Generar una fila con cada afición + CheckBox
            aficiones.forEach { aficion ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Checkbox(
                        checked = seleccion[aficion] == true,
                        onCheckedChange = {
                            seleccion = seleccion.toMutableMap().also { mapa ->
                                mapa[aficion] = it
                            }
                        }
                    )
                    Text(text = aficion, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Texto con las opciones seleccionadas
            Text(
                text = if (seleccionadas.isEmpty())
                    "No has seleccionado ninguna afición."
                else
                    "Aficiones seleccionadas: $seleccionadas",
                fontSize = 18.sp
            )
        }
    }
}