package software.engineering.wk02hw01.model;

import androidx.annotation.NonNull;

public class User {
    @NonNull
    private int id;
    @NonNull
    private String username;
    @NonNull
    private String password;

    public User() {}

    public User(String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
