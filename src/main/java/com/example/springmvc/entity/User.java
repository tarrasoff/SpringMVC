package com.example.springmvc.entity;

import com.example.springmvc.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserSummary.class)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    @JsonView(Views.UserSummary.class)
    private String name;

    @NotEmpty
    @Email
    @Column(name = "email", nullable = false, unique = true)
    @JsonView(Views.UserSummary.class)
    private String email;
}