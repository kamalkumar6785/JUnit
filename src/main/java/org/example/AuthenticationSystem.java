package org.example;

import java.util.*;
import java.util.UUID;






public class AuthenticationSystem {
    // Simulate a basic user store


    private Map<String, User> users = new HashMap<>();
    private EmailService emailService;
    private String lastActionMessage;

    public AuthenticationSystem() {
        // Creating a new dummy user
        users.put("user@example.com", new User("user@example.com", "password123"));
    }

    // Method to set the email service
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    //    Getter method for last message
    public String getlastActionMessage() {
        return lastActionMessage;
    }

    public void forgetPassword(String email)
    {
        if (users.containsKey(email))
        {
            // Generate a new password and set it for the user
            // UUID here means Universally Unique Identifier

            String newPassword = UUID.randomUUID().toString();
            users.get(email).setPassword(newPassword);

            // Send password reset email
            emailService.sendPasswordResetEmail(email);

            // Simulate sending an email
            lastActionMessage = "Password reset email successfully sent to " + email + " to set new password.";
            System.out.println(lastActionMessage);
        }
        else
        {
            lastActionMessage = "Email address not found.";
            System.out.println(lastActionMessage);
        }
    }

    public boolean login(String email, String password)
    {
        if (users.containsKey(email) && users.get(email).getPassword().equals(password))

        {
            // Successful login
            lastActionMessage = "User logged in successfully!!";
            System.out.println(lastActionMessage);
            return true;
        }
        else if (users.containsKey(email))
        {

            lastActionMessage = "Incorrect password";
            System.out.println(lastActionMessage);
            return  false;
        }
        else
        {
            // Login failed
            lastActionMessage = "Email not found";
            System.out.println(lastActionMessage);
            return false;
        }

    }
}

