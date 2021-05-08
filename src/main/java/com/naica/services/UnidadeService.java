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

import com.naica.domain.Unidade;
import com.naica.domain.dto.UnidadeDTO;
import com.naica.domain.dto.UnidadeNewDTO;
import com.naica.repositories.UnidadeRepository;
import com.naica.services.exception.DataIntegrityException;
import com.naica.services.exception.ObjectNotFoundException;

@Service
public class UnidadeService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UnidadeRepository repository;

    @Autowired
    private UnidadeService unidadeService;

    @Autowired
    private EmailService emailService;


    public Unidade find(Integer id) {
        Optional<Unidade> unidade = repository.findById(id);
        return unidade.orElseThrow(() -> new ObjectNotFoundException("Unidade não encontrado! Id: " + id + ", Tipo: " + Unidade.class.getName()));
    }

    @Transactional
    public Unidade insert(Unidade unidade) {
        unidade.setId(null);
        unidade = repository.save(unidade);
        return unidade;
    }

    public List<Unidade> findAll(){
        return repository.findAll();
    }

    public Unidade update(Unidade unidade) {
        Unidade newUnidade = find(unidade.getId());
        updateDate(newUnidade, unidade);
        return repository.save(newUnidade);
    }


    public Void delete(Integer id) {
        try {
            repository.delete(find(id));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir o usuário");
        }

        return null;
    }

    public Page<Unidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repository.findAll(pageRequest);

    }

    private void updateDate(Unidade newUnidade, Unidade unidade){

        newUnidade.setNome(unidade.getNome());
    }


    public Unidade fromDTO(UnidadeDTO unidadeDTO) {
        return new Unidade(unidadeDTO.getId(), unidadeDTO.getNome(), unidadeDTO.getEndereco());
    }

    public Unidade fromDTO(UnidadeNewDTO unidadeNewDTO) {

         Unidade unidade = new Unidade(null, unidadeNewDTO.getNome(), unidadeNewDTO.getEndereco());

         return unidade;

    }
}
