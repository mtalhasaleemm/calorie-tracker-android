# Calorie Tracker Android App

A basic Android application for tracking calorie intake.

## Project Structure

This is a complete Android project with the following structure:

```
calorie-tracker/
├── app/
│   ├── build.gradle                 # App-level build configuration
│   ├── proguard-rules.pro          # ProGuard rules
│   └── src/main/
│       ├── AndroidManifest.xml     # App manifest
│       ├── java/com/example/calorietracker/
│       │   └── MainActivity.kt     # Main activity
│       └── res/
│           ├── layout/
│           │   └── activity_main.xml    # Main layout
│           ├── values/
│           │   ├── strings.xml          # String resources
│           │   ├── colors.xml           # Color resources
│           │   └── themes.xml           # Theme definitions
│           └── xml/
│               ├── backup_rules.xml     # Backup rules
│               └── data_extraction_rules.xml
├── build.gradle                     # Project-level build configuration
├── settings.gradle                  # Project settings
├── gradle.properties               # Gradle properties
└── gradle/wrapper/
    └── gradle-wrapper.properties   # Gradle wrapper configuration
```

## Features

- Simple UI with app title and "Log Food" button
- Toast message when button is clicked
- Material Design 3 theme
- View binding enabled
- Minimum SDK 24 (Android 7.0)

## Setup Instructions

1. Open the project in Android Studio
2. Sync the project with Gradle files
3. Build and run the app on an emulator or device

## Requirements

- Android Studio Arctic Fox or later
- Android SDK 24 or higher
- Kotlin support

## Next Steps

This is a basic foundation. You can extend it by adding:
- Food database integration
- Calorie calculation logic
- Data persistence
- User profiles
- Charts and statistics
