@echo off
echo Generando APK desde el directorio actual...

REM Verificar si existe gradlew.bat
if not exist gradlew.bat (
    echo Creando gradlew.bat...
    copy ..\..\..\gradlew.bat gradlew.bat
)

REM Crear directorio gradle/wrapper si no existe
if not exist gradle\wrapper (
    mkdir gradle\wrapper
    copy ..\..\..\gradle\wrapper\gradle-wrapper.properties gradle\wrapper\gradle-wrapper.properties
)

REM Crear archivos de configuración necesarios
echo rootProject.name = "SmartTV-OpenApp" > settings.gradle
echo include ':app' >> settings.gradle

REM Crear build.gradle raíz
echo plugins { > build.gradle
echo     id 'com.android.application' version '8.1.2' apply false >> build.gradle
echo } >> build.gradle

REM Ejecutar construcción
call gradlew.bat assembleRelease

if %errorlevel% neq 0 (
    echo Error en la construcción del APK.
    exit /b %errorlevel%
)

echo Buscando APK generada...
dir /s *.apk

echo Proceso completado.
pause