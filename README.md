# 📺 ComarcasView - Smart TV

Aplicación para visualizar imágenes y videos en Smart TV Android con pantalla completa y acceso a almacenamiento USB.

## 🎯 Características

### 🔒 Sistema de Seguridad
- **Bloqueo con clave**: Protección con clave personalizada "5066109571"
- **Autenticación única**: Solo se solicita la primera vez
- **Almacenamiento seguro**: La autenticación se guarda localmente

### 📺 Visualización Optimizada
- **Pantalla completa real**: Oculta completamente el navegador y barras del sistema
- **Modo inmersivo**: Sin distracciones, solo el contenido
- **Optimizado para TV**: Interfaz diseñada específicamente para Smart TV

### 💾 Acceso a Archivos
- **Almacenamiento interno**: Acceso a Pictures, Movies, DCIM
- **Dispositivos USB**: Detección automática de memorias USB conectadas
- **Múltiples formatos**: JPG, PNG, GIF, BMP, WEBP, MP4, AVI, MKV, MOV, WMV, FLV, WEBM, 3GP

### 🎮 Controles Smart TV
- **Navegación con flechas**: Control remoto compatible
- **Enter/OK**: Seleccionar archivos
- **Escape/Back**: Salir de pantalla completa
- **Interfaz intuitiva**: Fácil de usar con control remoto

## 📱 Instalación

### Descargar APK
1. Ve a [Releases](../../releases)
2. Descarga la última versión del APK
3. O compila desde el código fuente

### Instalar en Smart TV
1. **Copiar a USB**: Guarda el APK en una memoria USB
2. **Conectar a TV**: Inserta la USB en tu Smart TV
3. **Instalar**: Usa el gestor de archivos de la TV para instalar
4. **Habilitar fuentes desconocidas** si es necesario
5. **Primera ejecución**: Ingresa la clave `5066109571`

## 🛠️ Desarrollo

### Requisitos
- Android Studio
- Android SDK 21+
- Java 11+

### Compilar
```bash
# Clonar repositorio
git clone https://github.com/TU_USUARIO/ComarcasView-SmartTV.git
cd ComarcasView-SmartTV

# Compilar APK debug
./gradlew assembleDebug

# Compilar APK release
./gradlew assembleRelease
```

### Estructura del Proyecto
```
app/
├── src/main/
│   ├── java/com/smarttv/openapp/
│   │   └── MainActivity.java          # Lógica principal Android
│   ├── assets/
│   │   └── app.html                   # Interfaz web
│   ├── res/
│   │   ├── layout/
│   │   │   └── activity_main.xml      # Layout principal
│   │   └── values/
│   │       ├── strings.xml            # Recursos de texto
│   │       └── styles.xml             # Estilos
│   └── AndroidManifest.xml            # Configuración de la app
└── build.gradle                       # Configuración de compilación
```

## 🚀 Características Técnicas

- **Plataforma**: Android 5.0+ (API 21+)
- **Arquitectura**: WebView + JavaScript Interface
- **Permisos**: Acceso a almacenamiento externo
- **Optimización**: Smart TV y Android TV
- **Tamaño**: ~2-5 MB

## 📋 Uso

1. **Abrir aplicación** en tu Smart TV
2. **Ingresar clave** `5066109571` (solo la primera vez)
3. **Seleccionar almacenamiento**: Interno o USB
4. **Navegar archivos** con las flechas del control remoto
5. **Seleccionar archivo** con Enter/OK
6. **Disfrutar** en pantalla completa
7. **Salir** con Escape/Back

## 🔧 Solución de Problemas

### APK no se instala
- Habilita "Fuentes desconocidas" en configuración de la TV
- Verifica que la USB esté en formato FAT32 o NTFS
- Asegúrate de que el APK no esté corrupto

### No detecta archivos USB
- Verifica que la USB esté correctamente conectada
- Reinicia la aplicación
- Comprueba los permisos de almacenamiento

### Pantalla completa no funciona
- Presiona Enter/OK sobre una imagen o video
- Usa Escape para salir del modo pantalla completa

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver `LICENSE` para más detalles.

## 🤝 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📞 Soporte

Si tienes problemas o preguntas, abre un [Issue](../../issues) en GitHub.

---

**Desarrollado para Smart TV Android** 📺✨