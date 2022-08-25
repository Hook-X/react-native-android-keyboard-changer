import { NativeModules, Platform } from 'react-native';
function getAndroidKeyboardModeChanger() {
    if ((Platform.OS === 'android')) {
        return NativeModules.AndroidKeyboardModeChanger;
    }
    return undefined;
}
export { getAndroidKeyboardModeChanger };
