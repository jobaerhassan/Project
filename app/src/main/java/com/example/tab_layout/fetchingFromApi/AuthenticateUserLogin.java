package com.example.tab_layout.fetchingFromApi;

public class AuthenticateUserLogin {

        public static User login(String username, String password) {


            if (username.equals("example") && password.equals("password")) {
                User user = new User(1, "example", "password");
                return user;
            } else {
                throw new IllegalArgumentException("Invalid credentials");
            }
        }


}
