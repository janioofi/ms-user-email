package com.ms.user.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Data
public class UserModel implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false)
    private UUID userId;

    private String name;

    @Column(unique = true)
    private String email;
}
