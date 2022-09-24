package com.example.BugTracker.Models;

import com.example.BugTracker.Roles.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_not_expired")
    private boolean isAccountNonExpired;

    @Column(name = "is_not_locked")
    private boolean isAccountNonLocked;

    @Column(name = "credentials_not_expired")
    private boolean isCredentialNonExpired;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "generic_user_role")
    private UserRole userRole;

    public User() {}

    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        setAccountNonExpired(true);
        setAccountNonLocked(true);
        setCredentialNonExpired(true);
        setEnabled(true);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
