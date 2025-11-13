package com.example.tareacomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun ModoOscuroSwitch() {

    // Estado para el interruptor (apagado = claro / encendido = oscuro)
    var modoOscuro by remember { mutableStateOf(false) }

    // Fondo cambia según el modo
    val colorFondo = if (modoOscuro) Color(0xFF121212) else Color(0xFFF5F5F5)
    val colorTexto = if (modoOscuro) Color.White else Color.Black

    // Estructura principal
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorFondo
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 4️⃣ Texto del estado actual
            Text(
                text = if (modoOscuro) "Modo oscuro activado" else " Modo claro activado",
                color = colorTexto,
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 5️⃣ Interruptor (Switch)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Modo oscuro",
                    color = colorTexto,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.width(12.dp))
                Switch(
                    checked = modoOscuro,
                    onCheckedChange = { modoOscuro = it }
                )
            }
        }
    }
}