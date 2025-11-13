// UI del carrusel y la vista del detalle

package com.example.carruselandroid.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.carruselandroid.R
import com.example.carruselandroid.model.ImageItem

@Composable
fun ImageCarrusel() {
    // Lista inmutable con los datos que se van a mostrar
    val images = listOf(
        ImageItem(R.drawable.img1, "Playa San Andres", "Un paraíso caribeño de aguas turquesa y arena blanca, perfecto para relajarse, bucear y disfrutar del ambiente isleño con sabor tropical."),
        ImageItem(R.drawable.img2, "Playa Portugal", "Playas de acantilados dorados, mar intenso y atardeceres mágicos, ideales para surfistas, aventureros y amantes del buen vino frente al mar."),
        ImageItem(R.drawable.img3, "Las Maldivas", "Lujo sobre el agua. Bungalows flotantes, mares cristalinos y un cielo que parece sacado de un sueño tropical."),
        ImageItem(R.drawable.img4, "Playa Guanascuate", "Un rincón natural y tranquilo donde la brisa marina y los paisajes vírgenes te desconectan de todo."),
        ImageItem(R.drawable.img5, "Playa Florida", "Ambiente vibrante, olas suaves y diversión sin fin. Desde Miami hasta Clearwater, cada playa vibra con sol, música y energía."),


        )

    // Declara estados de la imagen
    var selectedImage by remember { mutableStateOf<ImageItem?>(null) }

    if (selectedImage == null) {
        // Carrusel principal (crea y reproduce el carrusel)
        val pagerState = rememberPagerState { images.size }

        // Contiene el titulo y pager osea estados de donde se esta ubicado
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los hijos
            verticalArrangement = Arrangement.Center // Centrar en la mitad de la pantalla
        ) {
            // Título del carrusel
            Text(
                text = "Sitios Turísticos 🌅",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 30.dp)
            )

            // Carrusel con imágenes centradas
            HorizontalPager( // Crea una pagina por cada elemento (imagen)
                state = pagerState, // Manejo de paginas
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                val image = images[page] // obtiene la imagen correspondiente dependiendo del state

                // Centra la imagen en cada página
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = image.imageRes), // Carga el drawable local
                        contentDescription = image.title,
                        contentScale = ContentScale.Crop, // Recorta la imagen para que se ajuste al tamaño del contenedor
                        modifier = Modifier
                            .fillMaxWidth(0.9f) // ocupa el 90% del ancho
                            .height(280.dp)     // alto ajustado
                            .clickable { selectedImage = image } // Dispara la vista de detalle al hacer click

                    )
                }
            }
        }

    } else {
        // Pantalla de detalle de imagen con column centrada
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = selectedImage!!.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(bottom = 25.dp)
            )
            Image(
                painter = painterResource(id = selectedImage!!.imageRes),
                contentDescription = selectedImage!!.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(0.9f)  // centrando en detalle
                    .height(300.dp)

            )
            Spacer(modifier = Modifier.height(16.dp)) // Añade espacios verticales

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = selectedImage!!.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { selectedImage = null }) { // Vuelve la imagen a null es decir regresa al carrusel
                Text("Atrás")
            }
        }
    }
}
