package aimbraFluent.builders;

import aimbraFluent.entities.UserEntity;

/**
 * This class is required for test scenarios
 */
public class UserBuilder {

    private UserEntity user;

    private UserBuilder(){}

    public static UserBuilder oneUser() {
        UserBuilder builder = new UserBuilder();
        builder.user = new UserEntity();
        builder.user.setEmail("thiagosantoscunha@outlook.com");
        builder.user.setSenha("123123");
        builder.user.setUsername("thiagocunha");
        return builder;
    }

    public UserBuilder usernameIsNull() {
        user.setUsername(null);
        return this;
    }

    public UserBuilder usernameIsEmpty() {
        user.setUsername("");
        return this;
    }

    public UserEntity now() {
        return user;
    }

}
