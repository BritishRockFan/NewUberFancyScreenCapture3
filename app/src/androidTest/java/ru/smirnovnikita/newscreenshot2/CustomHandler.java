package ru.smirnovnikita.newscreenshot2;

import android.app.Instrumentation;
import android.graphics.Bitmap;
import android.view.View;

import androidx.test.espresso.FailureHandler;
import androidx.test.espresso.base.DefaultFailureHandler;
import org.hamcrest.Matcher;
import static ru.smirnovnikita.newscreenshot2.TakeScreenshots.saveBitmap;

public class CustomHandler implements FailureHandler {
    private DefaultFailureHandler customFailure;
    private MainActivity curActivity;
    private View screenView;


    //Constructor
    public CustomHandler(final Instrumentation instrumentation, MainActivity activity) {
        customFailure = new DefaultFailureHandler(instrumentation.getTargetContext());
        curActivity = activity;
        screenView = curActivity.findViewById(R.id.main).getRootView();
    }

    private void screenshot(){
        Bitmap bitmap = TakeScreenshots.takeScreenshot(screenView);
        saveBitmap(bitmap);
    }

    @Override
    public void handle(final Throwable error, final Matcher<View> viewMatcher) {
        // Take Screenshot
        screenshot();

        // Perform normal failure handling
        customFailure.handle(error, viewMatcher);
    }

}
