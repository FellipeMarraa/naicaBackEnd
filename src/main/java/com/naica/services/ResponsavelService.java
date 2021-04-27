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

import com.naica.domain.Responsavel;
import com.naica.domain.dto.ResponsavelDTO;
import com.naica.domain.dto.ResponsavelNewDTO;
import com.naica.repository.ResponsavelRepository;
import com.naica.services.exception.DataIntegrityException;
import com.naica.services.exception.ObjectNotFoundException;

@Service
public class ResponsavelService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ResponsavelRepository repository;

    @Autowired
    private ResponsavelService responsavelService;

    @Autowired
    private EmailService emailService;


    public Responsavel find(Integer id) {
        Optional<Responsavel> responsavel = repository.findById(id);
        return responsavel.orElseThrow(() -> new ObjectNotFoundException("Responsavel não encontrado! Id: " + id + ", Tipo: " + Responsavel.class.getName()));
    }

    @Transactional
    public Responsavel insert(Responsavel responsavel) {
        responsavel.setId(null);
        responsavel = repository.save(responsavel);
        return responsavel;
    }

    public List<Responsavel> findAll(){
        return repository.findAll();
    }


    public Responsavel update(Responsavel responsavel) {
        Responsavel newResponsavel = find(responsavel.getId());
        updateData(newResponsavel, responsavel);
        return repository.save(responsavel);
    }


    public Void delete(Integer id) {
        try {
            repository.delete(find(id));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir o usuário");
        }

        return null;
    }

    public Page<Responsavel> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repository.findAll(pageRequest);

    }

    private void updateData(Responsavel newResponsavel, Responsavel responsavel){

        newResponsavel.setNome(responsavel.getNome());
        newResponsavel.setEmail(responsavel.getEmail());
        newResponsavel.setDataNascimento(responsavel.getDataNascimento());
        newResponsavel.setCpf(responsavel.getCpf());
        newResponsavel.setIdentidade(responsavel.getIdentidade());
        newResponsavel.setDataEmissao(responsavel.getDataEmissao());
        newResponsavel.setUf(responsavel.getUf());
        newResponsavel.setOrgaoExpeditor(responsavel.getOrgaoExpeditor());
        newResponsavel.setCtps(responsavel.getCtps());
        newResponsavel.setNisResponsavel(responsavel.getNisResponsavel());
        newResponsavel.setEndereco(responsavel.getEndereco());
        newResponsavel.setEmail(responsavel.getEmail());
        newResponsavel.setObservacao(responsavel.getObservacao());
        
    }


    public Responsavel fromDTO(ResponsavelDTO responsavelDTO) {
        return new Responsavel( );
    }

    public Responsavel fromDTO(ResponsavelNewDTO responsavelNewDTO) {

         Responsavel responsavel = new Responsavel(null, responsavelNewDTO.getNome(), responsavelNewDTO.getDataNascimento(), responsavelNewDTO.getCpf(), responsavelNewDTO.getIdentidade(), responsavelNewDTO.getDataEmissao(), responsavelNewDTO.getUf(), responsavelNewDTO.getOrgaoExpeditor(), responsavelNewDTO.getCtps(), responsavelNewDTO.getNisResponsavel(), responsavelNewDTO.getEndereco(), responsavelNewDTO.getEmail(), responsavelNewDTO.getObservacao() );

         return responsavel;

    }
}
