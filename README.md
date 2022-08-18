# react-native-android-keyboard-mode-changer

Package to change android soft input mode

## Installation

```sh
npm install react-native-android-keyboard-mode-changer
```

## Usage

```js
import { getAndroidKeyboardModeChanger } from "react-native-android-keyboard-mode-changer";

// ...
// Returns undefined for any platform beside android. So you will have to use as optional with ?
const androidKeyboardModeChanger = getAndroidKeyboardModeChanger();

androidKeyboardModeChanger?.setAdjustPan().then()

// if your app defaul soft input mode is different from what you are setting, than run resetToDefault when leaving screen
androidKeyboardModeChanger?.resetToDefault().then()
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
