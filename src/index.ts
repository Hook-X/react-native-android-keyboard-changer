import { NativeModules, Platform } from 'react-native';

type keys = keyof IAndroidKeyboardModeChanger;

export type AndroidKeyboardModeChangerType = { [key in keys]: () => Promise<boolean | undefined> };

export interface IAndroidKeyboardModeChanger {
  resetToDefault(): Promise<boolean>;
  setStateUnspecified(): Promise<boolean>;
  setAdjustNothing(): Promise<boolean>;
  setAdjustPan(): Promise<boolean>;
  setAdjustResize(): Promise<boolean>;
  setAdjustUnspecified(): Promise<boolean>;
  setAlwaysHidden(): Promise<boolean>;
  setUnchanged(): Promise<boolean>;
}

function getAndroidKeyboardModeChanger() {
  if ((Platform.OS === 'android')){
    return NativeModules.AndroidKeyboardModeChanger as IAndroidKeyboardModeChanger;
  }

  return undefined
}

export { getAndroidKeyboardModeChanger };
