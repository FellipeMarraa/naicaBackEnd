package com.naica.services;



import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;

    private Random rand = new Random();

    public void sendNewPassword(String email) {

        Coordenador coordenador = coordenadorRepository.findByEmail(email);
        if (coordenador == null) {
            throw new ObjectNotFoundException("email não encontrado");
        }

        String newPass = newPassword();
        coordenador.setSenha(bCryptPasswordEncoder.encode(newPass));

        coordenadorRepository.save(coordenador);

        Coordenador coordenadorEmail = coordenadorRepository.findByEmail(coordenador.getEmail());

        emailService.sendNewPasswordEmail(coordenadorEmail, newPass);
    }



    private String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = rand.nextInt(3);
        if (opt == 0) { // gera um digito
            return (char) (rand.nextInt(10) + 48);
        }
        else if (opt == 1) { // gera letra maiuscula
            return (char) (rand.nextInt(26) + 65);
        }
        else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
}
