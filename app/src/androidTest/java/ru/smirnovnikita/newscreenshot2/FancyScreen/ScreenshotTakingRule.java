package ru.smirnovnikita.newscreenshot2.FancyScreen;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public final class ScreenshotTakingRule extends TestWatcher {
    protected void failed(Throwable e, Description description) {
        String parentFolderPath = "failures/" + description.getClassName();
        String var10001 = description.getMethodName();
        ScreenshotTaker.takeScreenshot(parentFolderPath, var10001);
    }
}