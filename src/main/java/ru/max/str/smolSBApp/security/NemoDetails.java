package ru.max.str.smolSBApp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.max.str.smolSBApp.models.Nemo;

import java.util.Collection;

public class NemoDetails implements UserDetails {

    private final Nemo nemo;

    public NemoDetails(Nemo nemo) {
        this.nemo = nemo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.nemo.getPassword();
    }

    @Override
    public String getUsername() {
        return this.nemo.getUsername();
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

    public Nemo getNemo() {
        return this.nemo;
    }

}
