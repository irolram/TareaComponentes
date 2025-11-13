package com.example.tareacomponentes



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource


@Composable
fun TarjetaAshKetchum() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        // Card principal
        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Imagen Ash
                ImageItem(R.drawable.ash ,"Ash")


                // Nombre y región
                Text(
                    text = "Ash Ketchum",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0D47A1)
                )

                Text(
                    text = "Región: Kanto",
                    fontSize = 18.sp,
                    color = Color(0xFF1976D2)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Título de las medallas
                Text(
                    text = "Medallas de Kanto:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E88E5)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Fila con las 8 medallas
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ImageItemKanto(R.drawable.roca, "Roca")
                        ImageItemKanto(R.drawable.cascada, "Cascada")
                        ImageItemKanto(R.drawable.trueno, "Trueno")
                        ImageItemKanto(R.drawable.arcoiris, "Arcoiris")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ImageItemKanto(R.drawable.alma, "Alma")
                        ImageItemKanto(R.drawable.pantano, "Pantano")
                        ImageItemKanto(R.drawable.volcan, "Volcan")
                        ImageItemKanto(R.drawable.tierra, "Tierra")
                    }


                }

            }
        }
    }
}



@Composable
fun ImageItemKanto(imageRes: Int, descripcion: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // TImagen redondeada
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = descripcion,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)

        )
        Spacer(modifier = Modifier.height(8.dp))
        // Texto descriptivo debajo de la imagen
        Text(text = descripcion, fontSize = 14.sp, color = Black)
    }
}
