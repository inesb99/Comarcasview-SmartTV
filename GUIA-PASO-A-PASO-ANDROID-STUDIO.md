# 📱 Guía Paso a Paso: Android Studio para Generar APK

## 🚀 PASO 1: Descargar e Instalar Android Studio

### 1.1 Descarga
1. Ve a: **https://developer.android.com/studio**
2. Haz clic en **"Download Android Studio"**
3. Acepta los términos y condiciones
4. Descarga el archivo (aproximadamente 1GB)

### 1.2 Instalación
1. Ejecuta el archivo descargado como **Administrador**
2. Sigue el asistente de instalación:
   - ✅ Acepta la ubicación por defecto
   - ✅ Instala Android Virtual Device (AVD)
   - ✅ Instala Android SDK
3. **Tiempo estimado**: 15-30 minutos

## 🔧 PASO 2: Configuración Inicial

### 2.1 Primer Inicio
1. Abre **Android Studio**
2. En la pantalla de bienvenida, selecciona:
   - **"Standard"** setup type
   - Acepta las licencias
   - Espera a que descargue los componentes SDK

### 2.2 Verificar Instalación
1. Ve a **File** → **Settings** → **Appearance & Behavior** → **System Settings** → **Android SDK**
2. Verifica que estén instalados:
   - ✅ Android 14.0 (API 34)
   - ✅ Android 5.0 (API 21)
   - ✅ Android SDK Build-Tools

## 📂 PASO 3: Abrir el Proyecto SmartTV-OpenApp

### 3.1 Abrir Proyecto
1. En Android Studio, haz clic en **"Open"**
2. Navega a la carpeta:
   ```
   c:\Users\Ines Pamela Bravo M\Documents\ComarcasView-AndroidTV
   ```
3. Selecciona la carpeta y haz clic en **"OK"**

### 3.2 Sincronización Automática
1. Android Studio detectará automáticamente que es un proyecto Android
2. Aparecerá un banner: **"Gradle sync in progress..."**
3. **Espera** a que termine la sincronización (2-5 minutos)
4. Si aparecen errores, haz clic en **"Sync Now"**

## 🔨 PASO 4: Generar la APK

### 4.1 Método Rápido (APK sin firmar)
1. Ve al menú **Build** → **Build Bundle(s) / APK(s)** → **Build APK(s)**
2. Espera a que compile (1-3 minutos)
3. Aparecerá una notificación: **"APK(s) generated successfully"**
4. Haz clic en **"locate"** para ver la APK

### 4.2 Método Profesional (APK Firmada) - RECOMENDADO
1. Ve a **Build** → **Generate Signed Bundle / APK...**
2. Selecciona **"APK"** y haz clic en **"Next"**

#### 4.2.1 Crear Keystore (Primera vez)
1. Haz clic en **"Create new..."**
2. Completa los datos:
   ```
   Key store path: C:\Users\[TuUsuario]\smarttv-keystore.jks
   Password: [tu-contraseña-segura]
   Key alias: smarttv-key
   Key password: [misma-contraseña]
   Validity (years): 25
   
   Certificate:
   First and Last Name: Tu Nombre
   Organizational Unit: SmartTV App
   Organization: Tu Organización
   City: Tu Ciudad
   State: Tu Estado
   Country Code: VE (o tu país)
   ```
3. Haz clic en **"OK"**

#### 4.2.2 Generar APK Firmada
1. Selecciona el keystore creado
2. Ingresa las contraseñas
3. Haz clic en **"Next"**
4. Selecciona **"release"** como build variant
5. Marca **"V1 (Jar Signature)"** y **"V2 (Full APK Signature)"**
6. Haz clic en **"Create"**

## 📍 PASO 5: Localizar la APK Generada

### 5.1 Ubicación de la APK
La APK se generará en:
```
c:\Users\Ines Pamela Bravo M\Documents\ComarcasView-AndroidTV\app\build\outputs\apk\release\app-release.apk
```

### 5.2 Verificar la APK
1. Ve a la carpeta donde se generó
2. Verifica que el archivo tenga un tamaño de **5-20 MB**
3. El nombre será: **app-release.apk**

## 📱 PASO 6: Preparar para Smart TV

### 6.1 Copiar a USB
1. Formatea una memoria USB en **FAT32**
2. Copia **app-release.apk** a la raíz del USB
3. Renómbrala a **SmartTV-OpenApp.apk** (opcional, para identificarla mejor)

### 6.2 Crear Carpeta de Instalación
```
USB/
├── SmartTV-OpenApp.apk
├── INSTRUCCIONES.txt (opcional)
└── README.txt (opcional)
```

## 🔧 PASO 7: Solución de Problemas Comunes

### 7.1 Error: "Gradle sync failed"
**Solución:**
1. Ve a **File** → **Invalidate Caches and Restart**
2. Selecciona **"Invalidate and Restart"**
3. Espera a que reinicie y vuelve a sincronizar

### 7.2 Error: "SDK not found"
**Solución:**
1. Ve a **File** → **Project Structure** → **SDK Location**
2. Verifica que la ruta del Android SDK sea correcta
3. Usualmente: `C:\Users\[Usuario]\AppData\Local\Android\Sdk`

### 7.3 Error: "Build failed"
**Solución:**
1. Ve a **Build** → **Clean Project**
2. Luego **Build** → **Rebuild Project**
3. Intenta generar la APK nuevamente

### 7.4 La APK es muy pequeña (menos de 1MB)
**Problema:** La APK no se compiló correctamente
**Solución:**
1. Verifica que todos los archivos fuente estén en su lugar
2. Ejecuta **Clean Project** y **Rebuild Project**
3. Genera la APK nuevamente

## ⏱️ Tiempos Estimados

- **Descarga Android Studio**: 10-20 minutos
- **Instalación**: 15-30 minutos
- **Configuración inicial**: 10-15 minutos
- **Abrir proyecto**: 2-5 minutos
- **Generar APK**: 1-3 minutos
- **Total**: 40-75 minutos (primera vez)

## 📞 Si Necesitas Ayuda

### Recursos Útiles:
- **Documentación oficial**: https://developer.android.com/studio/run
- **Video tutoriales**: YouTube "Android Studio APK generation"
- **Foros**: Stack Overflow, Reddit r/androiddev

### Información del Proyecto:
- **Nombre**: SmartTV-OpenApp
- **Package**: com.smarttv.openapp
- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 34 (Android 14)

---

## ✅ Checklist Final

Antes de instalar en Smart TV, verifica:
- [ ] APK generada exitosamente
- [ ] Tamaño de APK entre 5-20 MB
- [ ] APK firmada (si usaste el método profesional)
- [ ] USB formateado en FAT32
- [ ] APK copiada al USB
- [ ] Smart TV con "Fuentes desconocidas" habilitado

¡Tu APK estará lista para instalar en cualquier Smart TV con Android TV!