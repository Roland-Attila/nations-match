package org.fasttrackit.nationsmatch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.validation.constraints.NotBlank;

@Entity
public class Login {
    @Id
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @MapsId
    @ManyToMany
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                '}';
    }
}
