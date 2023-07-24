package com.ailing.userAuth.data.persistence.model;

import com.datastax.oss.driver.api.mapper.annotations.Entity;
import com.datastax.oss.driver.api.mapper.annotations.PartitionKey;
import com.datastax.oss.driver.api.mapper.annotations.Transient;

import java.time.Instant;
import java.util.UUID;

@Entity
public class User {
    @PartitionKey
    private UUID userId;

    private String name;

    private String email;

    private Instant creationDate;

    private String saltedPwd;

    @Transient
    private String password;

    public User(){
    }

    public User(UUID userId, String name, String email, Instant creationDate, String saltedPwd, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.creationDate = creationDate;
        this.saltedPwd = saltedPwd;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getSaltedPwd() {
        return saltedPwd;
    }

    public void setSaltedPwd(String saltedPwd) {
        this.saltedPwd = saltedPwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", saltedPwd='" + saltedPwd + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
