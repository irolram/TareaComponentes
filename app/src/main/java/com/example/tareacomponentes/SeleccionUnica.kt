package com.example.tareacomponentes

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SeleccionMetodoPago() {

    // Lista de métodos disponibles
    val metodosPago = listOf("Tarjeta", "PayPal", "Transferencia")

    // Variable de estado para el método seleccionado
    var metodoSeleccionado by remember { mutableStateOf("") }

    // Estructura visual
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Selecciona un método de pago:",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Grupo de RadioButtons
            metodosPago.forEach { metodo ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    RadioButton(
                        selected = metodo == metodoSeleccionado,
                        onClick = { metodoSeleccionado = metodo }
                    )
                    Text(
                        text = metodo,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Mostrar el método seleccionado
            Text(
                text = if (metodoSeleccionado.isEmpty())
                    "No has seleccionado ningún método de pago."
                else
                    "Método seleccionado: $metodoSeleccionado",
                fontSize = 18.sp
            )
        }
    }
}
