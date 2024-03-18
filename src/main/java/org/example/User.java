package org.example;

class User
{        // class to store info related to a user
    private String email;
    private String password;

    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    // method to set the password
    public void setPassword(String password) {
        this.password = password;
    }
}
