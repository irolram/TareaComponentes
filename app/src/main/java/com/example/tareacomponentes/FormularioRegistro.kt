package com.example.tareacomponentes


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FormularioRegistro() {
    // Variables de estado para almacenar los valores de los campos
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }

    // Variables de estado para errores
    var errorNombre by remember { mutableStateOf(false) }
    var errorCorreo by remember { mutableStateOf(false) }
    var errorContraseña by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE3F2FD)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // nombre
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                isError = errorNombre,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (errorNombre) {
                Text(
                    text = "El nombre no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // correo
            TextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text("Correo") },
                isError = errorCorreo,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            if (errorCorreo) {
                Text(
                    text = "El correo no puede estar vacío",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // contraseña
            TextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                label = { Text("Contraseña") },
                isError = errorContraseña,
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            if (errorContraseña) {
                Text(
                    text = "La contraseña no puede estar vacía",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de registro
            Button(
                onClick = {
                    // Validación de campos vacíos
                    errorNombre = nombre.isEmpty()
                    errorCorreo = correo.isEmpty()
                    errorContraseña = contraseña.isEmpty()

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }
        }
    }
}
