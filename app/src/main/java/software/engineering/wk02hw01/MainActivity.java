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

                //see if user exists by looking for username
                boolean validPw = true; //bool variable to see if password was valid or not
                for(int i=0; i<users.size(); i++){
                    //found user
                    if(users.get(i).getUsername().equals(name)){
                        //check password for matching username
                        if(users.get(i).getPassword().equals(pw)){
                            //login successful
                            MainActivity.username = username.getText().toString();
                            //change to landing page
//                            finish();
                            Intent intent = new Intent(MainActivity.this, LandingPageActivity.class);
                            startActivity(intent);
                            finish();
                            return;//need return here so remainder code does not run
                        }else{
                            validPw = false;
                            if(!validPw) {
                                password.setError("INVALID PASSWORD");
                                break; //break out of for loop
                            }
                        }
                    }
                }
                if(validPw){
                    username.setError("INVALID USERNAME");
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

}
