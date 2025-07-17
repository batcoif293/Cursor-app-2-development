# Simple Browser - Android Internet Browser

A lightweight, fast, and user-friendly Android internet browser built with modern Android development practices.

## Features

- **Full Web Browsing**: Navigate any website with JavaScript support
- **Modern UI**: Clean, intuitive interface with Material Design
- **Navigation Controls**: Back, forward, refresh, and home buttons
- **Smart URL Bar**: Automatically detects URLs or performs Google search
- **Pull-to-Refresh**: Swipe down to refresh the current page
- **WebView Integration**: Uses Android's built-in WebView for optimal performance
- **Intent Support**: Can be set as default browser for web links

## Screenshots

The browser features:
- Blue navigation toolbar with URL input field
- Navigation buttons (back, forward, refresh, home)
- Progress bar showing page loading status
- Full-screen web content area
- Swipe-to-refresh functionality

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
- **Back Button**: Navigate to previous page (disabled when no history)
- **Forward Button**: Navigate to next page (disabled when no forward history)
- **Refresh Button**: Reload current page
- **Home Button**: Navigate to Google homepage

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
- Custom search engines
- Theme customization
- History management

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