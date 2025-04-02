# Spotify Skeleton

Este es un proyecto de ejemplo para una aplicación de Spotify utilizando Kotlin y Jetpack Compose.

## Estructura del Proyecto

El proyecto está dividido en varios módulos:

- **app**: Contiene la actividad principal y la configuración de la aplicación.
- **domain**: Contiene la lógica de negocio y las entidades del dominio.
- **presentation/artistdetail**: Contiene la lógica de presentación y las vistas relacionadas con los detalles de los artistas.
- **presentation/search**: Contiene la lógica de presentación y las vistas relacionadas con la búsqueda de canciones y artistas.
- **presentation/splash**: Contiene la lógica de presentación y las vistas relacionadas con la pantalla de inicio.
- **presentation/trackdetail**: Contiene la lógica de presentación y las vistas relacionadas con los detalles de las canciones.

## Requisitos

- Android Studio Meerkat | 2024.3.1 Patch 1
- JDK 11 o superior

## Configuración del Proyecto

1. Clona el repositorio:
    ```sh
    git clone https://github.com/SergioSngular/spotify-skeleton.git
    ```
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle.

## Uso

### MainActivity

La `MainActivity` es el punto de entrada de la aplicación. Utiliza Jetpack Compose para definir la interfaz de usuario.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpotifySkeletonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
```

### Composable Functions

Ejemplo de una función composable:

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
```

## Dependencias

El proyecto utiliza varias dependencias, incluyendo:

- `androidx.compose.ui:ui-tooling`
- `com.google.android.material:material`
- `androidx.core:core-ktx`
- `androidx.appcompat:appcompat`
- `arrow-kt:arrow-core`
- `org.jetbrains.kotlinx:kotlinx-coroutines-core`
- `com.squareup.retrofit2:retrofit`
- `com.squareup.retrofit2:converter-gson`

## Características

- **Pantalla de Splash**: Implementada con soporte para Android 12.
- **Navegación con Compose**: Utiliza Jetpack Compose Navigation.
- **Inyección de Dependencias**: Configurada con Hilt.
- **Persistencia Local**: Utiliza Room para almacenamiento local.
- **Manejo de Tokens**: Guardado en SharedPreferences.
- **CI/CD**: Configurado para todos los commits.
- **Lint y Formateo**: Configurado con Detekt y Spotless.
- **Accesibilidad**: Mejoras en accesibilidad y soporte para modo claro y oscuro.
- **Previews en Compose**: Custom previews para diseño y accesibilidad.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
```