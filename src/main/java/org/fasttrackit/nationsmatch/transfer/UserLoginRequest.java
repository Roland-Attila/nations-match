package org.fasttrackit.nationsmatch.transfer;

import javax.validation.constraints.NotBlank;

public class UserLoginRequest {

    private long id;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
