package com.blogapp.myblogapp.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "guests")
@DiscriminatorValue("ADM")
public class Admin extends User {

    public Admin() {
        this.setRole(Role.ROLE_ADMIN);
    }

    public Admin(String username, String password) {
        super(username, password);
        this.setRole(Role.ROLE_ADMIN);
    }

    public Admin(String username, String password, String email) {
        super(username, password, email);
        this.setRole(Role.ROLE_ADMIN);
    }

    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
