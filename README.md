Prototipo funcional de la aplicación móvil de Petcéntrico.
Guía Completa: Configuración y Ejecución de Proyecto Android con Kotlin
Requisitos Previos
1. Herramientas Necesarias

Android Studio (última versión estable)
JDK (Java Development Kit) versión 11 o superior
Sistema Operativo:

Windows 10/11
macOS (versión reciente)
Linux (distribución actualizada)



2. Instalaciones Previas

Descargar e instalar Android Studio desde el sitio oficial de Google
Configurar variables de entorno para Java y Android SDK
Tener Git instalado para clonar repositorios

Proceso de Configuración
Paso 1: Clonar Repositorio
Paso 2: Abrir Proyecto en Android Studio

Iniciar Android Studio
Seleccionar "Open an Existing Project"
Navegar hasta la carpeta del proyecto clonado
Seleccionar el archivo build.gradle a nivel de proyecto

Paso 3: Configuración de Gradle

Android Studio iniciará la sincronización de Gradle automáticamente
Verificar en la parte inferior que no existan errores de sincronización
Si surgen problemas, ejecutar "Sync Project with Gradle Files"

Paso 4: Configurar Dispositivo de Ejecución
Opción A: Emulador

Abrir "AVD Manager" (Android Virtual Devices)
Crear nuevo dispositivo virtual
Seleccionar imagen del sistema compatible
Configurar características del dispositivo
Iniciar emulador

Opción B: Dispositivo Físico

Activar "Modo Desarrollador" en dispositivo Android
Habilitar "Depuración USB"
Conectar mediante cable USB
Autorizar conexión desde Android Studio

Paso 5: Configuraciones Adicionales

Verificar versión de Kotlin configurada en build.gradle
Revisar dependencias y versiones de bibliotecas
Comprobar configuración de SDK

Paso 6: Compilación del Proyecto

Hacer clic en "Build" -> "Rebuild Project"
Esperar que finalice proceso de construcción
Verificar que no existan errores

Paso 7: Ejecución de la Aplicación

Seleccionar dispositivo de ejecución
Hacer clic en botón "Run" (ícono de play verde)
Esperar proceso de instalación
Verificar arranque correcto de aplicación

Posibles Troubleshooting
Errores Comunes

Versiones incompatibles de Gradle
SDK no configurado correctamente
Dependencias faltantes
Permisos de dispositivo

Soluciones Rápidas

Sincronizar proyecto
Limpiar proyecto: "Build" -> "Clean Project"
Invalidar cachés: "File" -> "Invalidate Caches"
Actualizar dependencias en build.gradle

Recomendaciones Adicionales

Mantener Android Studio actualizado
Tener conexión a internet estable
Verificar requisitos del proyecto en README
Consultar documentación específica del repositorio

Consideraciones Finales

Cada proyecto puede tener configuraciones específicas
Leer documentación del repositorio
Consultar issues en GitHub si surgen problemas

Contacto y Soporte

Revisar sección de "Issues" en repositorio GitHub
Contactar maintainers del proyecto
