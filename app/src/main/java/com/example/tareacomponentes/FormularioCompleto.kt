package com.example.tareacomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun FormularioIntegrador() {

    // Scrollable
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    // Estados de los campos

    var nombre by rememberSaveable { mutableStateOf("") }
    var correo by rememberSaveable { mutableStateOf("") }
    var nombreError by remember { mutableStateOf(false) }
    var correoError by remember { mutableStateOf(false) }

    var NotificacionesDeSwitch by rememberSaveable { mutableStateOf(false) }

    val interesesOpciones = listOf("Música", "Deporte", "Lectura", "Cine", "Viajar")
    var interesesSeleccionados by rememberSaveable { mutableStateOf(interesesOpciones.associateWith { false }) }

    val generoOpciones = listOf("Masculino", "Femenino", "Otro")
    var generoSeleccionado by rememberSaveable { mutableStateOf("") }

    var edad by rememberSaveable { mutableStateOf(18f) }

    var showDialogConfirmacion by remember { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }
    var showResumen by remember { mutableStateOf(false) }


    // Pantalla principal

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Título
            Text(
                text = "Formulario de Registro",
                fontSize = 28.sp,
                color = Color(0xFF0D47A1)
            )

            // Campos de texto
            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it
                    nombreError = it.isBlank()
                },
                label = { Text("Nombre") },
                isError = nombreError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (nombreError) {
                Text("El nombre no puede estar vacío", color = Color.Red, fontSize = 12.sp)
            }

            OutlinedTextField(
                value = correo,
                onValueChange = {
                    correo = it
                    correoError = !android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()
                },
                label = { Text("Correo") },
                isError = correoError,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (correoError) {
                Text("Introduce un correo válido", color = Color.Red, fontSize = 12.sp)
            }

            // Switch
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Recibir notificaciones", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Switch(
                    checked = NotificacionesDeSwitch,
                    onCheckedChange = { NotificacionesDeSwitch = it }
                )
            }

            // CheckBox
            Column {
                Text("Intereses:", fontSize = 16.sp)
                interesesOpciones.forEach { opcion ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = interesesSeleccionados[opcion] == true,
                            onCheckedChange = {
                                interesesSeleccionados = interesesSeleccionados.toMutableMap().also { mapa ->
                                    mapa[opcion] = it
                                }
                            }
                        )
                        Text(opcion)
                    }
                }
            }

            // RadioButton
            Column {
                Text("Género:", fontSize = 16.sp)
                generoOpciones.forEach { opcion ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = generoSeleccionado == opcion,
                            onClick = { generoSeleccionado = opcion }
                        )
                        Text(opcion)
                    }
                }
            }

            // Slider
            Column {
                Text("Edad: ${edad.toInt()}", fontSize = 16.sp)
                Slider(
                    value = edad,
                    onValueChange = { edad = it },
                    valueRange = 0f..100f,
                    steps = 100
                )
            }

            // Botón de enviar
            Button(
                onClick = {
                    // Validaciones generales
                    nombreError = nombre.isBlank()
                    correoError = !android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()

                    if (!nombreError && !correoError) {
                        showDialogConfirmacion = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Enviar")
            }

            // Confirmación
            if (showDialogConfirmacion) {
                AlertDialog(
                    onDismissRequest = { showDialogConfirmacion = false },
                    title = { Text("Confirmar envío") },
                    text = { Text("¿Deseas enviar el formulario?") },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                showDialogConfirmacion = false
                                // Mostrar progreso antes del resumen
                                showProgress = true
                                coroutineScope.launch {
                                    delay(2000)
                                    showProgress = false
                                    showResumen = true
                                }
                            }
                        ) { Text("Sí") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDialogConfirmacion = false }) {
                            Text("No")
                        }
                    }
                )
            }

            // Progress indicator
            if (showProgress) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }

            // Card de resumen
            if (showResumen) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Resumen del registro", fontSize = 20.sp, color = Black)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Nombre: $nombre", color = Black)
                        Text("Correo: $correo", color = Black)
                        Text("Notificaciones: ${if (NotificacionesDeSwitch) "Sí" else "No"}", color = Black)
                        Text(
                            "Intereses: ${
                                interesesSeleccionados.filterValues { it }.keys.joinToString(", ")
                            }", color = Black
                        )
                        Text("Género: $generoSeleccionado", color = Black)
                        Text("Edad: ${edad.toInt()}", color = Black)
                    }
                }
            }
        }
    }
}
