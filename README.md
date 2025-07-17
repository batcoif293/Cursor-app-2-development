# Simple Browser - Android Internet Browser

A lightweight, fast, and user-friendly Android internet browser built with modern Android development practices.

## Features

- **Full Web Browsing**: Navigate any website with JavaScript support
- **Modern UI**: Clean, intuitive interface with Material Design and hamburger menu
- **Hidden Navigation**: Space-saving design with collapsible navigation controls
- **Smart URL Bar**: Automatically detects URLs or performs Google search
- **Pull-to-Refresh**: Swipe down to refresh the current page
- **WebView Integration**: Uses Android's built-in WebView for optimal performance
- **Intent Support**: Can be set as default browser for web links
- **Customizable Settings**: Change homepage and color themes with local storage
- **Multiple Themes**: Choose from 6 color themes (Blue, Green, Purple, Orange, Red, Dark)
- **Homepage Presets**: Quick selection of popular search engines (Google, DuckDuckGo, Bing, Yahoo) or custom URL

## Screenshots

The browser features:
- Clean navigation toolbar with hamburger menu and URL input field (color theme customizable)
- Hidden navigation menu with back, forward, refresh, home, and settings buttons
- Progress bar showing page loading status
- Full-screen web content area for maximum browsing space
- Swipe-to-refresh functionality
- Settings screen with homepage and theme customization options

## Installation

### Option 1: Direct APK Installation

1. Download the `SimpleBrowser.apk` file
2. On your Android device, go to **Settings > Security**
3. Enable **"Unknown Sources"** or **"Install unknown apps"**
4. Transfer the APK file to your device
5. Open the APK file and follow the installation prompts

### Option 2: ADB Installation (for developers)

```bash
adb install SimpleBrowser.apk
```

## Technical Specifications

- **Minimum Android Version**: Android 5.0 (API 21)
- **Target Android Version**: Android 14 (API 34)
- **Architecture**: Universal (supports all Android architectures)
- **Permissions Required**:
  - Internet access
  - Network state access
- **File Size**: ~3.4 MB

## Features in Detail

### Smart URL Handling
- Enter full URLs (http://example.com or https://example.com)
- Enter domain names (example.com - automatically adds https://)
- Enter search terms (automatically searches on Google)

### Navigation
- **Hamburger Menu**: Tap the menu icon to show/hide navigation controls
- **Back Button**: Navigate to previous page (disabled when no history)
- **Forward Button**: Navigate to next page (disabled when no forward history)
- **Refresh Button**: Reload current page
- **Home Button**: Navigate to your configured homepage
- **Settings Button**: Access homepage and theme customization options
- **Clean Interface**: Navigation buttons are hidden by default for a cleaner browsing experience

### Settings & Customization
- **Homepage Options**: Choose from Google, DuckDuckGo, Bing, Yahoo, or set a custom URL
- **Color Themes**: Select from 6 beautiful color schemes:
  - Blue (Default) - Classic blue theme
  - Green - Nature-inspired green theme
  - Purple - Modern purple theme  
  - Orange - Vibrant orange theme
  - Red - Bold red theme
  - Dark - Sleek dark theme
- **Local Storage**: All settings are saved locally on your device
- **Instant Apply**: Homepage changes take effect immediately
- **Theme Restart**: Color theme changes require app restart to fully apply

### Web Standards Support
- HTML5, CSS3, JavaScript
- Local storage and session storage
- Responsive design support
- Modern web APIs through WebView

## Development Information

This browser was built using:
- **Language**: Java
- **IDE**: Android Studio compatible
- **Build System**: Gradle
- **UI Framework**: Android Views with Material Design
- **Web Engine**: Android WebView

### Project Structure
```
android_browser/
├── app/
│   ├── src/main/
│   │   ├── java/com/simplebrowser/app/
│   │   │   └── MainActivity.java
│   │   ├── res/
│   │   │   ├── layout/activity_main.xml
│   │   │   ├── values/colors.xml
│   │   │   ├── values/strings.xml
│   │   │   └── values/themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle
└── settings.gradle
```

## Privacy & Security

- No data collection or tracking
- Uses Android's secure WebView component
- Supports HTTPS websites
- No ads or analytics
- Open source architecture

## Troubleshooting

### Installation Issues
- Ensure "Unknown Sources" is enabled in Android settings
- Check that you have sufficient storage space
- Verify the APK file is not corrupted

### Performance Issues
- Clear browser cache by reinstalling the app
- Ensure you have a stable internet connection
- Close other apps to free up memory

## Future Enhancements

Potential features for future versions:
- Bookmarks management
- Download manager
- Private browsing mode
- Multiple tabs support
- History management
- Advanced security settings
- Export/import settings

## License

This project is open source and available under the MIT License.

## Support

For issues or questions:
1. Check the troubleshooting section above
2. Verify your Android version meets the minimum requirements
3. Ensure you have a stable internet connection

---

**Version**: 1.0  
**Build Date**: 2024  
**Compatibility**: Android 5.0+ (API 21+)