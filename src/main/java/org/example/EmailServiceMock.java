package org.example;

public class EmailServiceMock implements EmailService {
    @Override
    public void sendPasswordResetEmail(String email) {
        System.out.println("Password reset email successfully sent to " + email + " to set new password.");
    }
}