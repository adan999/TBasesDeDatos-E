package com.uabc.database.example.examplejpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(
        columnNames = {"role", "username"}
))
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true, nullable = false)
    private Integer userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole(){}

    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }
}
