package com.example.clase06mongodb.clase06mongodb.model;

import com.example.clase06mongodb.clase06mongodb.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Document(collection = "users")// Especificar nombre de colección
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    private String id;

    @NotBlank (message = "Name es obligatorio")
    @Size(min = 3, max = 20)
    private String username;

    @Indexed(unique = true)
    @Email (message = "Email debe ser válido")
    private String email;

    @Size(min = 8, max = 20, message = "Password debe tener entre 8 y 20 caracteres")
    private String password;


    @Field("roles") // Mapea el campo roles en la colección MongoDB
    private Set<Role> roles;

    private  boolean active=true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                .collect(Collectors.toSet());
    }

    // Refactor para evitar duplicación
    private boolean isUserActive() {
        return active;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isUserActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isUserActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isUserActive();
    }

    @Override
    public boolean isEnabled() {
        return isUserActive();
    }

    @Builder.Default
    private Instant createdAt = Instant.now();
}