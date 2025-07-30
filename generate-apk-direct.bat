@echo off
echo Generando APK directamente desde el directorio actual...

REM Verificar si existe gradlew.bat en el directorio padre
cd ..\..\..
if not exist gradlew.bat (
    echo ERROR: No se encontró gradlew.bat en el directorio raíz.
    cd app\comarcasapp\SmartTV-OpenApp
    exit /b 1
)

REM Ejecutar desde el directorio raíz
call gradlew.bat :app:assembleRelease

if %errorlevel% neq 0 (
    echo Error en la construcción del APK.
    cd app\comarcasapp\SmartTV-OpenApp
    exit /b %errorlevel%
)

echo Buscando APK generada...
dir /s *.apk

echo Proceso completado.
cd app\comarcasapp\SmartTV-OpenApp
pause