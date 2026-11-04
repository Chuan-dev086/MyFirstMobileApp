# MyFirstMobileApp

A modern, persistent To-Do list app built with Kotlin and Jetpack Compose. Originally created as a learning project, it has evolved into a fully functional application utilizing modern Android architecture (MVVM) and local data persistence (Room).

## ✨ Features

- **Full CRUD Operations**: Add new tasks, mark them as done/undone, and delete them.
- **Data Persistence**: Tasks are saved in a local Room database and survive app restarts.
- **Modern UI**: Built entirely with Jetpack Compose and Material 3.
- **Completion Status**: Completed tasks are clearly indicated with a checked box and strikethrough text.
- **Undo Delete**: Accidentally deleted a task? Instantly undo it via the Snackbar action.
- **Responsive Theming**: Supports dynamic color (Android 12+) and seamlessly adapts to system Light/Dark mode.

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose (Material 3)
- **Architecture:** MVVM (Model-View-ViewModel)
- **State Management:** `ViewModel` + `StateFlow` + `collectAsStateWithLifecycle`
- **Local Database:** Room (with KSP for annotation processing)
- **Async:** Kotlin Coroutines
- **Min SDK:** 25
- **Target SDK:** 37 (Ultra-modern SDK)

## 📂 Project Structure

```text
app/src/main/java/com/example/myfirstmobileapp/
├── MainActivity.kt      # Entry point, Compose UI, and UI events
├── TaskDatabase.kt      # Room Entity (Task), DAO, and Database setup
├── TaskViewModel.kt     # ViewModel handling state and database interactions
└── ui/theme/
    ├── Color.kt
    ├── Theme.kt
    └── Type.kt
```

## 🚀 Getting Started

### Requirements

- Android Studio (Latest Preview or Stable version matching AGP 9.x)
- JDK 17+
- Android SDK matching the project's `compileSdk`

### 1. Command Line Build

Open your terminal and run the following commands:

```bash
# Clone the repository
git clone https://github.com/Chuan-dev086/MyFirstMobileApp.git
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
4. Select your physical device or emulator from the top toolbar, then click **Run ▶** (`Shift + F10`).

## ⚠️ Known Limitations

- **No task editing yet.** A task must be deleted and re-added to change its title.
- **No filtering / sorting / search.**
- **Hardcoded UI strings.** Text is not yet extracted to `strings.xml` for i18n.

## 🗺️ Roadmap

- [x] Refactor into distinct UI / Data / ViewModel layers
- [x] Introduce `ViewModel` and `StateFlow`
- [x] Persist tasks with Room
- [ ] Edit existing tasks (Inline or Dialog)
- [ ] Swipe-to-delete gesture
- [ ] Floating Action Button (FAB) for adding tasks
- [ ] Filter: All / Active / Completed
- [ ] Empty-state UI
- [ ] Move UI strings to `strings.xml` (i18n)
- [ ] Priority and due date
- [ ] Local reminder notifications
- [ ] Unit tests for ViewModel + GitHub Actions CI

## 📄 License

This project is for learning purposes. No license specified yet.
