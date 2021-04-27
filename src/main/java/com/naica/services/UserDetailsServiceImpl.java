package com.naica.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.naica.domain.Coordenador;
import com.naica.repositories.CoordenadorRepository;
import com.naica.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Coordenador coordenador = coordenadorRepository.findByEmail(email);
        if (coordenador == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(coordenador.getId(), coordenador.getEmail(), coordenador.getSenha());
    }

}
