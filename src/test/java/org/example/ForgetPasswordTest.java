package org.example;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


import static org.mockito.Mockito.*;

public class ForgetPasswordTest {
    private static AuthenticationSystem Auth_system;
    private static EmailServiceMock emailService;

    @BeforeAll
    public static void setUp() {
        Auth_system = new AuthenticationSystem();
        emailService = mock(EmailServiceMock.class);
        // Creating a mock object for the EmailService interface using Mockito.
        // This allows us to simulate the behavior of the EmailService in our tests

        Auth_system.setEmailService(emailService);
    }

    @Test
    public void testForgetPassword_ValidEmail() {
        String email = "user@example.com";
        Auth_system.forgetPassword(email);

        // Verify that the email sending method is called with the correct email address
        verify(emailService, times(1)).sendPasswordResetEmail(eq(email));

        // Assert that a success message is displayed after sending the email
        assertEquals("Password reset email successfully sent to " + email + " to set new password.", Auth_system.getlastActionMessage());
    }

    @Test
    public void testForgetPassword_InValidEmail()
    {
        String email = "user_new@example.com";
        Auth_system.forgetPassword(email);

        // Assert that a success message is displayed after sending the email
        assertEquals("Email address not found.", Auth_system.getlastActionMessage());
    }

}
