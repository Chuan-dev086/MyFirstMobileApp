# MyFirstMobileApp

A simple to-do list app built with Kotlin and Jetpack Compose, created as a learning project for Android development.

## 📱 Screenshots

_Screenshots coming soon._

## ✨ Features

- Add tasks to a to-do list
- Mark tasks as done / undone (completed tasks are shown with strikethrough)
- Delete tasks with a "Delete" button
- Undo a deletion via a Snackbar action
- Light / dark theme following the system setting
- Dynamic color support on Android 12+

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose (Material 3)
- **State management:** `State`, `MutableStateListOf` (in-memory)
- **Async:** Kotlin Coroutines
- **Min SDK:** _(fill in from `app/build.gradle.kts`, e.g. 24)_
- **Target SDK:** _(fill in from `app/build.gradle.kts`, e.g. 36)_

## 📂 Project Structure

```

app/src/main/java/com/example/myfirstmobileapp/
├── MainActivity.kt # Entry point + Todo UI + Task model (all in one file)
└── ui/theme/
├── Color.kt
├── Theme.kt
└── Type.kt

```

Note: the app logic currently lives in `MainActivity.kt`. A refactor into
`model/`, `data/`, and `ui/` layers is planned — see Roadmap.

## 🚀 Getting Started

### Requirements

- Android Studio (latest stable)
- JDK 17+
- Android SDK matching the project's `compileSdk`

## 🛠️ Build & Run

Please ensure you have **JDK 17** (or the required version for your project) configured on your system before proceeding.

### 1. Command Line Build

Open your terminal and run the following commands:

```bash
# Clone the repository
git clone https://github.com
 cd MyFirstMobileApp

# Build and generate the Debug APK
# For macOS / Linux:
 ./gradlew assembleDebug

# For Windows (PowerShell or CMD):
 .\gradlew.bat assembleDebug
```

Once the build completes successfully, you can find the generated APK file at:
`app/build/outputs/apk/debug/app-debug.apk`

### 2. Run via Android Studio

1. Launch **Android Studio**.
2. Click **Open** and select the root directory of this project.
3. Wait for the **Gradle Sync** process to finish.
4. Select your device or emulator from the top toolbar, then click **Run ▶** (`Shift + F10`).

### ⚠️ Known Limitations

- **No persistence.** Tasks are kept in memory only — they are lost when the app is closed or the device restarts.
- **No configuration-change handling.** Rotating the screen recreates the Activity and clears the current list and input field.
- **No task editing.** A task must be deleted and re-added to change its title.
- **No filtering / sorting / search.**
- **Hardcoded UI strings.** Text is not yet extracted to `strings.xml`.
- **No tests or CI.**

## 🗺️ Roadmap

- [ ] Refactor into `model/` / `data/` / `ui/` layers
- [ ] Introduce `ViewModel` and `StateFlow`
- [ ] Persist tasks with Room
- [ ] Edit existing tasks
- [ ] Filter: All / Active / Completed
- [ ] Empty-state UI
- [ ] IME "Done" action to submit a task
- [ ] Move UI strings to `strings.xml` (i18n)
- [ ] Priority and due date
- [ ] Search and sort
- [ ] Local reminder notifications
- [ ] Unit tests for ViewModel + GitHub Actions CI

## 📄 License

This project is for learning purposes. No license specified yet.
