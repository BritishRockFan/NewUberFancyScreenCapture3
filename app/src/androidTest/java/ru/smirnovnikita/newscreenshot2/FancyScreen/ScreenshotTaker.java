package ru.smirnovnikita.newscreenshot2.FancyScreen;

import android.util.Log;

import androidx.test.runner.screenshot.ScreenCapture;
import androidx.test.runner.screenshot.Screenshot;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public final class ScreenshotTaker {
    private static final String TAG = "Screenshots";

    public static final void takeScreenshot(String parentFolderPath, String screenShotName) {
        Log.d("Screenshots", "Taking screenshot of '" + screenShotName + '\'');
        ScreenCapture screenCapture = Screenshot.capture();
        Set processors = Collections.singleton(new MyScreenCaptureProcessor(parentFolderPath));

        try {
            screenCapture.setName(screenShotName);
            screenCapture.process(processors);
            Log.d("Screenshots", "Screenshot taken");
        } catch (IOException var9) {
            Log.e("Screenshots", "Could not take a screenshot", (Throwable) var9);
        }

    }
}

