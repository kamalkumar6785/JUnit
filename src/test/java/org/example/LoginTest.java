package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class LoginTest {
    private static AuthenticationSystem Auth_system;

    @BeforeAll
    public static void setUp()
    {
         // Before all the testcases this statement will be executed.
        Auth_system = new AuthenticationSystem();

    }

    @Test
    public void testLogin_Valid()     // testing for valid credentials
    {
        String email = "user@example.com";
        String password = "password123";

        assertTrue(Auth_system.login(email, password));
        assertEquals("User logged in successfully!!", Auth_system.getlastActionMessage());
    }

    @Test
    public void testLogin_InvalidEmail() {          // testing an email which is not
                                                        // present in the database

        String email = "invalid@example.com";
        String password = "randompassword";

        assertFalse(Auth_system.login(email, password));
        assertEquals("Email not found", Auth_system.getlastActionMessage());
    }

    @Test
    public void testLogin_InvalidPassword() {      // if email is present in the
                                                    // database and password is incorrect
        String email = "user@example.com";
        String wrongPassword = "wrongTestPassword";

        assertFalse(Auth_system.login(email, wrongPassword));
        assertEquals("Incorrect password", Auth_system.getlastActionMessage());
    }

}
