package com.smarttv.openapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final String[] REQUIRED_PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Configurar pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        // Ocultar barra de navegación
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        setupWebView();
        
        // Solicitar permisos
        requestPermissions();
    }

    private void setupWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        
        // Agregar interfaz JavaScript
        webView.addJavascriptInterface(new FileSystemInterface(), "AndroidFileSystem");
        
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                super.onShowCustomView(view, callback);
                // Manejar pantalla completa para videos
            }
        });
        
        webView.loadUrl("file:///android_asset/app.html");
    }

    private void requestPermissions() {
        List<String> permissionsNeeded = new ArrayList<>();
        
        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsNeeded.add(permission);
            }
        }
        
        if (!permissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, 
                    permissionsNeeded.toArray(new String[0]), 
                    PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Los permisos han sido procesados
        }
    }

    public class FileSystemInterface {
        
        @JavascriptInterface
        public String getInternalFiles() {
            return getFilesFromDirectory(getInternalStoragePaths());
        }
        
        @JavascriptInterface
        public String getUSBFiles() {
            return getFilesFromDirectory(getUSBStoragePaths());
        }
        
        private List<String> getInternalStoragePaths() {
            List<String> paths = new ArrayList<>();
            
            // Almacenamiento interno principal
            paths.add(Environment.getExternalStorageDirectory().getAbsolutePath());
            
            // Directorio de imágenes
            paths.add(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
            
            // Directorio de videos
            paths.add(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
            
            // Directorio DCIM (cámara)
            paths.add(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
            
            return paths;
        }
        
        private List<String> getUSBStoragePaths() {
            List<String> paths = new ArrayList<>();
            
            // Rutas comunes para dispositivos USB en Android TV
            String[] possibleUSBPaths = {
                "/storage/usb",
                "/storage/usbotg",
                "/storage/usb1",
                "/storage/usb2",
                "/mnt/usb",
                "/mnt/usbhost",
                "/mnt/media_rw",
                "/storage/external_storage"
            };
            
            for (String path : possibleUSBPaths) {
                File usbDir = new File(path);
                if (usbDir.exists() && usbDir.isDirectory()) {
                    paths.add(path);
                    // También buscar subdirectorios
                    File[] subDirs = usbDir.listFiles();
                    if (subDirs != null) {
                        for (File subDir : subDirs) {
                            if (subDir.isDirectory()) {
                                paths.add(subDir.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            
            return paths;
        }
        
        private String getFilesFromDirectory(List<String> directories) {
            JSONArray filesArray = new JSONArray();
            
            // Extensiones de archivos soportadas
            List<String> imageExtensions = Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "webp");
            List<String> videoExtensions = Arrays.asList("mp4", "avi", "mkv", "mov", "wmv", "flv", "webm", "3gp");
            
            for (String dirPath : directories) {
                File directory = new File(dirPath);
                if (directory.exists() && directory.isDirectory()) {
                    scanDirectory(directory, filesArray, imageExtensions, videoExtensions);
                }
            }
            
            return filesArray.toString();
        }
        
        private void scanDirectory(File directory, JSONArray filesArray, 
                                 List<String> imageExtensions, List<String> videoExtensions) {
            try {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            // Recursivamente escanear subdirectorios
                            scanDirectory(file, filesArray, imageExtensions, videoExtensions);
                        } else if (file.isFile()) {
                            String fileName = file.getName().toLowerCase();
                            String extension = "";
                            int lastDot = fileName.lastIndexOf('.');
                            if (lastDot > 0) {
                                extension = fileName.substring(lastDot + 1);
                            }
                            
                            String fileType = null;
                            if (imageExtensions.contains(extension)) {
                                fileType = "image";
                            } else if (videoExtensions.contains(extension)) {
                                fileType = "video";
                            }
                            
                            if (fileType != null) {
                                JSONObject fileObj = new JSONObject();
                                fileObj.put("name", file.getName());
                                fileObj.put("type", fileType);
                                fileObj.put("path", "file://" + file.getAbsolutePath());
                                fileObj.put("size", file.length());
                                fileObj.put("lastModified", file.lastModified());
                                filesArray.put(fileObj);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        
        @JavascriptInterface
        public boolean fileExists(String filePath) {
            try {
                File file = new File(filePath.replace("file://", ""));
                return file.exists();
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (webView != null) {
            webView.onResume();
        }
        
        // Mantener pantalla completa
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.destroy();
        }
    }
    
    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
    
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}