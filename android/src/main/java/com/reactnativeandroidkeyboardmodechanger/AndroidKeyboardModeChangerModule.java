package com.reactnativeandroidkeyboardmodechanger;

import android.app.Activity;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = AndroidKeyboardModeChangerModule.NAME)
public class AndroidKeyboardModeChangerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "AndroidKeyboardModeChanger";
    private int _mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
    private int _defaultMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
    private boolean _isFirstRun = true;

    public AndroidKeyboardModeChangerModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

  @ReactMethod
  public void resetToDefault(Promise promise) {
    _mode = _defaultMode;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setStateUnspecified(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setAdjustNothing(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setAdjustPan(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setAdjustResize(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setAdjustUnspecified(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setAlwaysHidden(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setAlwaysVisible(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setVisible(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setHidden(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN;
    _getActivityAndRunMode(promise);
  }

  @ReactMethod
  public void setUnchanged(Promise promise) {
    _mode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED;
    _getActivityAndRunMode(promise);
  }

  private void _getActivityAndRunMode(Promise promise) {
      final Activity activity = getCurrentActivity();

    if(_isFirstRun) {
      _defaultMode = activity.getWindow().getAttributes().softInputMode;
      _isFirstRun = false;
    }

      activity.runOnUiThread(new Runnable() {
        @Override
        public void run() {
          try {
            activity.getWindow().setSoftInputMode(_mode);
            promise.resolve(true);
          }
          catch(Exception e) {
            promise.reject("AndroidKeyboardModeChangerModule error", e);
          }
        }
      });
  }
}
