package com.trexgui.spring.service.userDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.trexgui.spring.domain.Role;
import com.trexgui.spring.domain.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private User user;
    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        List<Role> roles = user.getRoles();
        for( Role role : roles ) {
            authorities.add( new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        return user.isEnabled();
    }
}
