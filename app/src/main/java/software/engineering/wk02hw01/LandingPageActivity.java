package software.engineering.wk02hw01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LandingPageActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView message = findViewById(R.id.welcomeMessage);
        message.setText("Welcome "+MainActivity.username);

        Button login_button = findViewById(R.id.exit_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
//    public static Intent getIntent(Context context){
//        return new Intent(context, LandingPageActivity.class);
//    }

    public static Intent getIntent(Context context, int value){
        Intent intent = new Intent(context, LandingPageActivity.class);
        intent.putExtra("INTENT_EXTRA_VALUE", value);
        return intent;
    }

}
