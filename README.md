# MovieBuffs 🎥🍿

MovieBuffs is a dynamic Android app that allows users to explore and discover movies. The app adapts seamlessly to different screen sizes and orientations, delivering an engaging user experience across various devices. Built with **Jetpack Compose**, **Material3**, and **Kotlin**, MovieBuffs integrates network features to fetch live movie data from an external API.

---

## **Features**

- 🌟 **Responsive Design**: Adapts to different screen sizes:
  - Compact: List-only layout
  - Medium: Feed layout
  - Expanded: Combined list-and-detail layout
- 🎬 **Live Movie Data**: Fetches real-time movie details from the network.
- 🔄 **Retry Mechanism**: Displays error states and allows users to retry failed network requests.
- 🖼️ **Visual Elements**:
  - Movie posters and descriptions
  - User-friendly detail view for selected movies
- 🧭 **Seamless Navigation**: Supports easy navigation between movie lists and detailed views.
- 💡 **Modern Architecture**: MVVM architecture using Jetpack libraries like **StateFlow** and **ViewModel**.

---

## **Screenshots**

| **List View**               | **Detail View**             |
|------------------------------|-----------------------------|
| ![List View](screenshots/list_view.png) | ![Detail View](screenshots/detail_view.png) |
!(screenshots/screenshot.png)

---

## **Tech Stack**

- **Kotlin**
- **Jetpack Compose**
- **Material3**
- **Retrofit** for networking
- **Coil** for image loading
- **MVVM Architecture**

---

## **Getting Started**

### **Prerequisites**
- Android Studio (latest version recommended)
- Kotlin 1.9+
- Minimum SDK: 24
- Target SDK: 35

### **Setup Instructions**
1. Clone the repository:
   ```bash
   git clone https://github.com/benellis1993/MovieBuffs.git
