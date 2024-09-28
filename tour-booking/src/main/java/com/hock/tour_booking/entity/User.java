package com.hock.tour_booking.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {


    @Id
    private UUID id;
    private String fullname;
    private String email;
    private String password_hash;
    private String phone;
    private String address;
    private boolean is_active;
    private LocalDateTime created_at;
    private LocalDateTime last_login;

    public User(UUID id, String fullname, String email, String password_hash, String phone, String address, boolean is_active, LocalDateTime created_at, LocalDateTime last_login, Set<Role>roles) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password_hash = password_hash;
        this.phone = phone;
        this.address = address;
        this.is_active = is_active;
        this.created_at = created_at;
        this.last_login = last_login;
        this.roles = roles;
    }

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        this.roles.stream().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return List.of(new SimpleGrantedAuthority(authorities.toString()));
    }

    @Override
    public String getPassword() {
        return this.password_hash;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
