package tests;

import entity.User;

public class Preconditions extends BaseTest{

    protected final User userWithEmptyUserName = User.newBuilder()
            .setUsername("")
            .setPassword(PASSWORD)
            .build();

    protected final User userWithEmptyPassword = User.newBuilder()
            .setUsername(USERNAME)
            .setPassword("")
            .build();

    protected final User userWithEmptyFields = User.newBuilder()
            .setUsername("")
            .setPassword("")
            .build();

    protected final User userWithIncorrectFields = User.newBuilder()
            .setUsername("asdasd")
            .setPassword("gdsfg")
            .build();

    protected static final User userSuccess = User.newBuilder()
            .setUsername("standard_user")
            .setPassword("secret_sauce")
            .build();
}
