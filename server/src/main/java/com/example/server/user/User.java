package com.example.server.user;

import jakarta.persistence.*;

@Entity 
@Table (
    name = "users",
    indexes = {
        @Index(
            name = "idx_user_email",
            columnList = "email"
        ),

        @Index(
            name = "idx_user_username",
            columnList = "username"
        )
    }
)
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column (nullable = false , unique = true)
    private String username;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
