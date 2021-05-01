package com.naica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naica.domain.Coordenador;
import com.naica.domain.dto.CoordenadorDTO;
import com.naica.domain.dto.CoordenadorNewDTO;
import com.naica.repositories.CoordenadorRepository;
import com.naica.services.exception.DataIntegrityException;
import com.naica.services.exception.ObjectNotFoundException;

@Service
public class CoordenadorService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CoordenadorRepository repository;

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
    private EmailService emailService;


    public Coordenador find(Integer id) {
        Optional<Coordenador> coordenador = repository.findById(id);
        return coordenador.orElseThrow(() -> new ObjectNotFoundException("Coordenador não encontrado! Id: " + id + ", Tipo: " + Coordenador.class.getName()));
    }

    @Transactional
    public Coordenador insert(Coordenador coordenador) {
        coordenador.setId(null);
        coordenador = repository.save(coordenador);
//        emailService.sendOrderConfirmationHtmlEmail(coordenador);
        return coordenador;
    }

    public List<Coordenador> findAll(){
        return repository.findAll();
    }


    public Coordenador update(Coordenador coordenador) {
        Coordenador newCoordenador = find(coordenador.getId());
        updateData(newCoordenador, coordenador);
        return repository.save(coordenador);
    }


    public Void delete(Integer id) {
        try {
            repository.delete(find(id));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir o usuário");
        }

        return null;
    }

    public Page<Coordenador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repository.findAll(pageRequest);

    }

    private void updateData(Coordenador newCoordenador, Coordenador coordenador){

        newCoordenador.setNome(coordenador.getNome());
        newCoordenador.setUsuario(coordenador.getUsuario());
        newCoordenador.setUnidade(coordenador.getUnidade());
        newCoordenador.setEmail(coordenador.getEmail());
        newCoordenador.setSenha(coordenador.getSenha());
    }


    public Coordenador fromDTO(CoordenadorDTO coordenadorDTO) {
        return new Coordenador( );
    }

    public Coordenador fromDTO(CoordenadorNewDTO coordenadorNewDTO) {

         Coordenador coordenador = new Coordenador(null, coordenadorNewDTO.getNome(), coordenadorNewDTO.getUsuario(), coordenadorNewDTO.getUnidade(), coordenadorNewDTO.getEmail(), bCryptPasswordEncoder.encode(coordenadorNewDTO.getSenha()));

         return coordenador;

    }
}
