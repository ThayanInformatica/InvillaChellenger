package com.invillia.acme.config;

import com.invillia.acme.domain.Usuario;
import com.invillia.acme.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    // Criar repository spring para Usuario
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Criar classe de entidade para Usuario
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null) {
            return User.withUsername(usuario.getEmail()).password(passwordEncoder.encode(usuario.getSenha())).roles("CLIENT").build();
        } else {
            throw new UsernameNotFoundException("Não foi possível encontrar o usuário " + email);
        }
    }
}
