package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class User {
    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }
    public static Builder newBuilder() {
        return new User().new Builder();
    }
    public class Builder {

        private Builder() {
        }

        public Builder setUsername(String username) {
            User.this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;

            return this;
        }

        public User build() {
            User user = new User();
            user.username = User.this.username;
            user.password = User.this.password;
            return user;
        }
    }
}
