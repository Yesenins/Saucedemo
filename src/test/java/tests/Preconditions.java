package tests;

import entity.User;

public class Preconditions extends BaseTest{

    public static User userWithEmptyName = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    public static User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .password("")
            .build();

    public static User userWithEmptyFields = User.builder()
            .username("")
            .password("")
            .build();

    public static User userWithIncorrectFields = User.builder()
            .username("asdasd")
            .password("sgdsfgd")
            .build();

    public static User userSuccess = User.builder()
            .username("standard_user")
            .password("secret_sauce")
            .build();
}
