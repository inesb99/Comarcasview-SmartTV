# ProGuard rules for SmartTV-OpenApp

# Keep the main activity
-keep class com.smarttv.openapp.MainActivity { *; }

# Keep the settings activity
-keep class com.smarttv.openapp.SettingsActivity { *; }

# Keep all public classes and their public methods
-keep public class * {
    public *;
}

# Keep all resources
-keep class * {
    <fields>;
}

# Keep the HTML files in assets
-keep class **.assets.** { *; }

# Keep the AndroidManifest.xml
-keep class **.AndroidManifest { *; }

# Optimize the APK
-dontoptimize
-dontshrink

# Enable obfuscation
-allowobfuscation