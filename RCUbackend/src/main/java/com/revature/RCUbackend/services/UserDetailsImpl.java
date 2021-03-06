package com.revature.RCUbackend.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.RCUbackend.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private int user_id;

    private String first_name;

    private String last_name;

    private String email;

    private String username;

    @JsonIgnore
    private String password;

    private String phone_number;



    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(int user_id, String first_name, String last_name,
                           String email, String username, String password, String phone_number,
                           Collection<? extends GrantedAuthority> authorities) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.authorities = authorities;
    }

    // ------------------------------------------------------------------------

    public static UserDetailsImpl build(User user) {

        List<GrantedAuthority> authorities =
                user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getUserID(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoneNumber(),
                authorities);
    }

//    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(user_id, user.user_id);
    }


//    public String getUsername() {
//    }
}
