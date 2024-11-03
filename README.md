```markdown
# Spotify Skeleton

Este es un proyecto de ejemplo para una aplicación de Spotify utilizando Kotlin y Jetpack Compose.

## Estructura del Proyecto

El proyecto está dividido en varios módulos:

- **app**: Contiene la actividad principal y la configuración de la aplicación.
- **domain**: Contiene la lógica de negocio y las entidades del dominio.
- **presentation/songs**: Contiene la lógica de presentación y las vistas relacionadas con las canciones.

## Requisitos

- Android Studio Koala | 2024.1.1 Patch 2
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

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
```

Este `README.md` proporciona una visión general de tu proyecto, incluyendo la estructura, requisitos, configuración, uso y dependencias.
