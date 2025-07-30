@echo off
echo Generando APK para la aplicación SmartTV-OpenApp...

REM Ir a la raíz del proyecto (ajusta la ruta según tu estructura)
cd /d "%~dp0\..\..\.."

REM Verifica si gradlew.bat existe
if not exist gradlew.bat (
    echo ERROR: No se encontró gradlew.bat en la raíz del proyecto.
    echo Ejecuta 'gradle wrapper' o abre el proyecto en Android Studio para generarlo.
    pause
    exit /b 1
)

REM Genera el wrapper si no existe (ya configurado manualmente)
REM gradle wrapper

REM Ejecuta el wrapper de Gradle desde la raíz
call gradlew.bat assembleRelease

if %errorlevel% neq 0 (
    echo Error en la construcción del APK. Verifica los mensajes anteriores.
    exit /b %errorlevel%
)

echo APK generado exitosamente en: app\build\outputs\apk\release\app-release.apk
echo Proceso completado. Puedes encontrar el APK en la carpeta correspondiente.
pause