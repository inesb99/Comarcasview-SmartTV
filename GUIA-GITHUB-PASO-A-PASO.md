# 📚 Guía Completa: Subir Proyecto a GitHub y Generar APK

## 🎯 Paso 1: Crear Cuenta en GitHub

1. **Ir a GitHub**: Ve a https://github.com
2. **Registrarse**: Haz clic en "Sign up"
3. **Crear cuenta**: Completa el formulario con:
   - Username (nombre de usuario)
   - Email
   - Contraseña
4. **Verificar email**: Revisa tu correo y verifica la cuenta

## 📁 Paso 2: Crear Repositorio en GitHub

1. **Iniciar sesión** en GitHub
2. **Crear nuevo repositorio**:
   - Haz clic en el botón verde "New" o "+"
   - Selecciona "New repository"
3. **Configurar repositorio**:
   - **Repository name**: `ComarcasView-SmartTV`
   - **Description**: `Aplicación para Smart TV con visualización en pantalla completa`
   - **Visibilidad**: Public (para usar GitHub Actions gratis)
   - ✅ **Add a README file** (marcar)
   - ✅ **Add .gitignore** → seleccionar "Android"
   - **License**: MIT License (opcional)
4. **Crear**: Haz clic en "Create repository"

## 💻 Paso 3: Instalar Git en tu PC

### Opción A: Descargar Git
1. Ve a: https://git-scm.com/download/windows
2. Descarga e instala Git para Windows
3. Durante la instalación, acepta las opciones por defecto

### Opción B: Usar GitHub Desktop (Más Fácil)
1. Ve a: https://desktop.github.com/
2. Descarga e instala GitHub Desktop
3. Inicia sesión con tu cuenta de GitHub

## 📤 Paso 4: Subir el Proyecto (Método Fácil - GitHub Desktop)

### 4.1 Clonar el repositorio vacío
1. **Abrir GitHub Desktop**
2. **Clone repository**:
   - Haz clic en "Clone a repository from the Internet"
   - Selecciona tu repositorio `ComarcasView-SmartTV`
   - Elige una carpeta en tu PC (ej: `C:\GitHub\ComarcasView-SmartTV`)
   - Haz clic en "Clone"

### 4.2 Copiar archivos del proyecto
1. **Abrir dos ventanas del explorador**:
   - Ventana 1: Tu proyecto actual (`c:\Users\Ines Pamela Bravo M\Documents\ComarcasView-AndroidTV\app\comarcasapp\SmartTV-OpenApp`)
   - Ventana 2: Repositorio clonado (ej: `C:\GitHub\ComarcasView-SmartTV`)

2. **Copiar TODOS los archivos** desde la Ventana 1 a la Ventana 2:
   - Selecciona todo (Ctrl+A) en tu proyecto actual
   - Copia (Ctrl+C)
   - Pega (Ctrl+V) en el repositorio clonado
   - **Reemplaza** el README.md existente cuando te pregunte

### 4.3 Subir cambios
1. **Volver a GitHub Desktop**
2. **Verás todos los archivos** listados como cambios
3. **Commit**:
   - En "Summary": escribe `Implementación completa de ComarcasView Smart TV`
   - En "Description": 
     ```
     - Sistema de bloqueo con clave personalizada
     - Visualización en pantalla completa
     - Acceso a almacenamiento USB e interno
     - Controles optimizados para Smart TV
     - GitHub Actions para compilación automática
     ```
4. **Haz clic en "Commit to main"**
5. **Push**: Haz clic en "Push origin" para subir al servidor

## 📤 Paso 5: Subir el Proyecto (Método Línea de Comandos)

Si prefieres usar comandos, abre **Command Prompt** en tu carpeta del proyecto:

```bash
# Inicializar repositorio Git
git init

# Agregar todos los archivos
git add .

# Hacer commit inicial
git commit -m "Implementación completa de ComarcasView Smart TV"

# Conectar con GitHub (reemplaza TU_USUARIO con tu nombre de usuario)
git remote add origin https://github.com/TU_USUARIO/ComarcasView-SmartTV.git

# Subir archivos
git branch -M main
git push -u origin main
```

## 🚀 Paso 6: Generar APK Automáticamente

### 6.1 Activar GitHub Actions
1. **Ve a tu repositorio** en GitHub
2. **Pestaña "Actions"**: Haz clic en la pestaña "Actions"
3. **Habilitar workflows**: Si aparece un botón, haz clic en "I understand my workflows, go ahead and enable them"

### 6.2 Ejecutar la compilación
1. **Pestaña "Actions"** → **"Build Android APK"**
2. **Run workflow**:
   - Haz clic en "Run workflow"
   - Selecciona "main" branch
   - Haz clic en "Run workflow" (botón verde)

### 6.3 Esperar la compilación
- **Tiempo**: 5-10 minutos aproximadamente
- **Estado**: Verás un círculo amarillo (en progreso) → verde (exitoso) o rojo (error)

### 6.4 Descargar APK
1. **Haz clic en el workflow completado** (círculo verde)
2. **Artifacts**: Verás dos archivos:
   - `ComarcasView-Debug-APK` (para pruebas)
   - `ComarcasView-Release-APK` (versión final)
3. **Descargar**: Haz clic en el que prefieras para descargar
4. **Extraer**: El archivo descargado es un ZIP, extráelo para obtener el APK

## 📱 Paso 7: Instalar APK en Smart TV

### 7.1 Preparar USB
1. **Formatear USB** en FAT32 (si es necesario)
2. **Copiar APK** a la raíz de la USB
3. **Renombrar** (opcional): `ComarcasView-SmartTV.apk`

### 7.2 Instalar en TV
1. **Conectar USB** a Smart TV
2. **Abrir gestor de archivos** de la TV
3. **Navegar a USB** y buscar el APK
4. **Instalar**: Seleccionar APK → Instalar
5. **Habilitar fuentes desconocidas** si es necesario
6. **Abrir aplicación**
7. **Ingresar clave**: `5066109571`

## 🔄 Paso 8: Actualizaciones Futuras

Para hacer cambios y generar nuevos APKs:

1. **Hacer cambios** en tu código local
2. **GitHub Desktop**:
   - Commit cambios
   - Push origin
3. **GitHub Actions** compilará automáticamente
4. **Descargar nuevo APK** desde Actions

## ❓ Solución de Problemas

### GitHub Actions falla
- **Revisa los logs** en la pestaña Actions
- **Verifica** que todos los archivos se subieron correctamente
- **Intenta nuevamente** con "Re-run all jobs"

### APK no se instala
- **Verifica** que descargaste el APK correcto (no el ZIP)
- **Habilita** "Fuentes desconocidas" en la TV
- **Usa** la versión Debug si Release no funciona

### No puedes subir archivos
- **Verifica** tu conexión a internet
- **Revisa** que tienes permisos en el repositorio
- **Intenta** con GitHub Desktop si los comandos fallan

## 🎉 ¡Listo!

Una vez completados estos pasos, tendrás:
- ✅ Proyecto en GitHub
- ✅ APK funcional generado automáticamente
- ✅ Aplicación lista para instalar en Smart TV
- ✅ Sistema de actualizaciones automáticas

**¡Tu aplicación ComarcasView estará funcionando en tu Smart TV!** 📺✨