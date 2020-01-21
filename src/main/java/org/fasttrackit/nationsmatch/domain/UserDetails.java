package org.fasttrackit.nationsmatch.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails extends User implements org.springframework.security.core.userdetails.UserDetails {

    public UserDetails(final User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
//                getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
//                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
