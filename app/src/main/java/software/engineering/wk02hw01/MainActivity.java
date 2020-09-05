package software.engineering.wk02hw01;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import software.engineering.wk02hw01.model.User;

public class MainActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();   //list of predefined accounts
    public static String username = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadUsers();
        //add text fields and button for login
        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.username);
                EditText password = findViewById(R.id.password);

                //save input from user into variables
                String name = username.getText().toString();
                String pw = password.getText().toString();

//                authentication(name, pw, username, password);
                int x = authenticate(name, pw, users);
                if(x == 1){
                    MainActivity.username = username.getText().toString();
//                    Intent intent = new Intent(MainActivity.this, LandingPageActivity.class);
//                    Intent intent = LandingPageActivity.getIntent(getApplicationContext());
                    Intent intent = LandingPageActivity.getIntent(getApplicationContext(), 42);
                    startActivity(intent);
                    finish();
                }else if(x == 2){
                    username.setError("INVALID USERNAME");
                }else if(x == 3){
                    password.setError("INVALID PASSWORD");
                }
            }
        });
    }

    //method to populate users list
    public void loadUsers(){
        //create dummy accounts
        User account1 = new User("din_djarin", "baby_yoda_ftw");

        //add dummy accounts to users list
        users.add(0, account1);

        //check if added successfully
        if(users.size() > 0){
            Log.d("MainActivity", "users successfully loaded");
        } else{
            Log.d("MainActivity", "loadUsers failed");
        }
    }

    //1 = valid
    //2 = username error
    //3 = password error
    public static int authenticate(String name, String pw, List<User> users){
        for(int i=0; i<users.size(); i++){
//            //found user
            if(users.get(i).getUsername().equals(name)){
                //check password for matching username
                if(users.get(i).getPassword().equals(pw)){
                    //login successful
                    return 1;
                }else{
                    //invalid password
                    return 3;
                }
            }
        }
        //no matching username
        return 2;
    }

    public static boolean userExists(String name, List<User> users){
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(name)){
                return true;
            }
        }
        return false;
    }
}
