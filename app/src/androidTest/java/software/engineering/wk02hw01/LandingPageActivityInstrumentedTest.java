package software.engineering.wk02hw01;

import android.content.Context;
import android.content.Intent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
public class LandingPageActivityInstrumentedTest{
    //Test Case 1
    @Test
    public void intent_isCorrect() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Intent intent = LandingPageActivity.getIntent(appContext, 42);
        //default value is the value returned if specified name cannot be found
        assertEquals(42, intent.getIntExtra("INTENT_EXTRA_VALUE", 2));
    }
}
