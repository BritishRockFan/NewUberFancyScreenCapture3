package ru.smirnovnikita.newscreenshot2.FancyScreen;

import android.os.Environment;

import androidx.test.runner.screenshot.BasicScreenCaptureProcessor;

import java.io.File;

public final class MyScreenCaptureProcessor extends BasicScreenCaptureProcessor {
    protected String getFilename(String prefix) {
        return prefix;
    }

    public MyScreenCaptureProcessor(String parentFolderPath) {
        //super();
        this.mDefaultScreenshotPath = new File((new File(Environment.
                getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "my_app_folder")).getAbsolutePath(), "screenshots/" + parentFolderPath);
    }
}
