# 🔧 Cómo Generar una APK Real para Smart TV

## ⚠️ IMPORTANTE
La APK generada por el script `create-apk-manual.bat` es solo un archivo de demostración. Para crear una APK funcional, sigue estos pasos:

## 📋 Requisitos Necesarios

### 1. Software Requerido:
- **Android Studio** (versión Arctic Fox o superior)
- **Java JDK 8 o superior**
- **Android SDK** (API 21-34)
- **Android SDK Build Tools**

### 2. Configuración del Entorno:
```bash
# Variables de entorno necesarias
ANDROID_HOME=C:\Users\[TuUsuario]\AppData\Local\Android\Sdk
JAVA_HOME=C:\Program Files\Java\jdk-[version]
```

## 🚀 Pasos para Generar APK Real

### Opción 1: Usando Android Studio (Recomendado)
1. **Abrir el proyecto**:
   - Abre Android Studio
   - Selecciona "Open an existing project"
   - Navega a: `c:\Users\Ines Pamela Bravo M\Documents\ComarcasView-AndroidTV`

2. **Sincronizar el proyecto**:
   - Android Studio detectará automáticamente los archivos Gradle
   - Espera a que se sincronicen las dependencias

3. **Generar APK**:
   - Ve a `Build` → `Generate Signed Bundle / APK`
   - Selecciona `APK`
   - Configura o crea un keystore para firmar la APK
   - Selecciona `release` como build variant
   - Haz clic en `Finish`

### Opción 2: Línea de Comandos (Avanzado)
```bash
# Desde el directorio raíz del proyecto
cd "c:\Users\Ines Pamela Bravo M\Documents\ComarcasView-AndroidTV"

# Generar APK de release
gradlew assembleRelease

# La APK se generará en:
# app\build\outputs\apk\release\app-release.apk
```

## 📱 Instalación en Smart TV

### Requisitos de la Smart TV:
- **Android TV 5.0+** (API 21 o superior)
- **Espacio libre**: Mínimo 50MB
- **Conexión a internet** (para descargar dependencias si es necesario)

### Pasos de Instalación:
1. **Preparar USB**:
   - Formatea una memoria USB en FAT32 o NTFS
   - Copia la APK generada a la raíz del USB

2. **Configurar Smart TV**:
   - Ve a `Configuración` → `Seguridad`
   - Habilita `Fuentes desconocidas` o `Instalar apps desconocidas`

3. **Instalar APK**:
   - Conecta el USB a la Smart TV
   - Abre el explorador de archivos de la TV
   - Navega al USB y selecciona la APK
   - Confirma la instalación

## 🔍 Verificación de la APK

### Características de una APK Real:
- **Tamaño**: Entre 5-20 MB (dependiendo de las dependencias)
- **Firma digital**: Debe estar firmada con un certificado válido
- **Metadatos**: Contiene información del manifiesto Android

### Comandos para Verificar:
```bash
# Verificar información de la APK
aapt dump badging app-release.apk

# Verificar firma
jarsigner -verify -verbose -certs app-release.apk
```

## 🛠️ Solución de Problemas

### Si Gradle no funciona:
1. Instala Android Studio completo
2. Configura las variables de entorno
3. Ejecuta `gradle wrapper` desde Android Studio

### Si la APK no se instala:
1. Verifica que la Smart TV sea compatible con Android TV
2. Asegúrate de que "Fuentes desconocidas" esté habilitado
3. Verifica que la APK esté firmada correctamente

## 📞 Alternativas

### Si no puedes instalar Android Studio:
1. **Usar un servicio online** como AppGyver o BuildBot
2. **Pedir ayuda** a un desarrollador Android
3. **Usar Android Studio en la nube** (GitHub Codespaces, etc.)

---

**Nota**: El proyecto actual tiene toda la estructura y código necesario. Solo necesitas las herramientas adecuadas para compilarlo en una APK funcional.