## I Ching: Privacy policy

This is an open source Android app developed by Przemysław Krajenta. The source code is available on GitHub under the MIT license; the app is also available on Google Play.

I hereby state, to the best of my knowledge and belief, that I have not programmed this app to collect any personally identifiable information. All data (app preferences (like theme, etc.) and alarms) created by the you (the user) is stored on your device only, and can be simply erased by clearing the app's data or uninstalling it.

### Explanation of permissions requested in the app

The list of permissions required by the app can be found in the `AndroidManifest.xml` file.

<br/>

| Permission | Why it is required |
| :---: | --- |
| '<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />' | Required to load images on an external server (imgur.com). |
| '<uses-permission android:name="android.permission.INTERNET" />'              | Required to access external server and share content gained in application. |
| '<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />' | Required in order for an action to be started by shaking of the device. |

 <hr style="border:1px solid gray">

If you find any security vulnerability that has been inadvertently caused by me, or have any question regarding how the app protectes your privacy, please send me an email or post a discussion on GitHub, and I will surely try to fix it/help you.

Yours sincerely,  
Przemysław Krajenta  
Poland  
p.krajenta@gmail.com