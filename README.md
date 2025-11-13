# Carrusel de Imágenes - Android con Jetpack Compose

Este proyecto es desarrollado en **Kotlin** con **Jetpack Compose**, que muestra un **carrusel interactivo de imágenes**.  
Al hacer clic sobre una imagen, se muestra una **pantalla de detalle** con su título y descripción.


## Características principales

* Carrusel horizontal con desplazamiento tipo “slide”.
* Imágenes locales mostradas con `HorizontalPager`.  
* Pantalla de detalle con título, descripción y botón “Atrás”.  
* Interfaz con `Material3` y Compose.  
* Arquitectura separada en paquetes (`model` Modelo de datos de cada imagen , `screen` Pantalla principal (carrusel + detalle)).  


## Estructura del proyecto

com.example.carruselandroid/
│
├── model/
│ └── ImageItem.kt → Modelo de datos de cada imagen
│
├── screen/
│ └── ImageCarrusel.kt → Pantalla principal (carrusel + detalle)
│
├── ui/theme/ → Estilos generados por Compose (colores, tipografía)
│
└── MainActivity.kt → Punto de entrada que carga el carrusel
