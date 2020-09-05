package software.engineering.wk02hw01;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import software.engineering.wk02hw01.model.User;

import static org.junit.Assert.*;

public class  MainActivityUnitTest {
    private List<User> users = new ArrayList<>();   //list of predefined accounts

    //Test Case 1
    @Test
    public void username_isCorrect() {
        User account1 = new User("din_djarin", "baby_yoda_ftw");
        //add dummy accounts to users list
        users.add(0, account1);

        assertTrue("should return true", MainActivity.userExists("din_djarin", users));
    }
    //Test Case 2
    @Test
    public void username_isNotCorrect() {
        User account1 = new User("din_djarin", "baby_yoda_ftw");
        //add dummy accounts to users list
        users.add(0, account1);

        assertFalse("should return false", MainActivity.userExists("diiin_djaaaarin", users));
    }
    //Test Case 3
    @Test
    public void password_isCorrect() {
        User account1 = new User("din_djarin", "baby_yoda_ftw");
        //add dummy accounts to users list
        users.add(0, account1);

        assertEquals(1, MainActivity.authenticate("din_djarin", "baby_yoda_ftw", users));
    }
    //Test Case 4
    @Test
    public void password_isNotCorrect() {
        User account1 = new User("din_djarin", "baby_yoda_ftw");
        //add dummy accounts to users list
        users.add(0, account1);

        assertEquals(3, MainActivity.authenticate("din_djarin", "baaaaby_yooooda_ftw", users));
    }
}