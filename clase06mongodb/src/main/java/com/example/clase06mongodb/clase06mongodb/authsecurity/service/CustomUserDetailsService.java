package com.example.clase06mongodb.clase06mongodb.authsecurity.service;


import com.example.clase06mongodb.clase06mongodb.model.User;
import com.example.clase06mongodb.clase06mongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;
    // MEJORES NO REALIZADA: cualquier usuario loggeado puede hacer sin limites. deberia solo modificar las cosas de su cuenta cada usuario.
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.debug("Intentando cargar usuario por nombre: {}", username);


    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> {
          log.error("Usuario no encontrado con nombre: {}", username);
          return new UsernameNotFoundException("User not found with username: " + username);

        });

    log.info("Usuario cargado exitosamente: {}", username);
    user.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .forEach(authority -> log.info("User authority en custom user details: {}", authority));
    return user;
  }
}