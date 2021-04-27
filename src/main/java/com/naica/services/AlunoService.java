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

import com.naica.domain.Aluno;
import com.naica.domain.dto.AlunoDTO;
import com.naica.domain.dto.AlunoNewDTO;
import com.naica.repositories.AlunoRepository;
import com.naica.services.exception.DataIntegrityException;
import com.naica.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EmailService emailService;


    public Aluno find(Integer id) {
        Optional<Aluno> aluno = repository.findById(id);
        return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    @Transactional
    public Aluno insert(Aluno aluno) {
        aluno.setId(null);
        aluno = repository.save(aluno);
        return aluno;
    }

    public List<Aluno> findAll(){
        return repository.findAll();
    }


    public Aluno update(Aluno aluno) {
        Aluno newAluno = find(aluno.getId());
        updateData(newAluno, aluno);
        return repository.save(aluno);
    }


    public Void delete(Integer id) {
        try {
            repository.delete(find(id));
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não foi possível excluir o usuário");
        }

        return null;
    }

    public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repository.findAll(pageRequest);

    }

    private void updateData(Aluno newAluno, Aluno aluno){

        newAluno.setNome(aluno.getNome());
//        newAluno.setEmail(aluno.getEmail());
//        newAluno.setSenha(aluno.getSenha());
    }


    public Aluno fromDTO(AlunoDTO alunoDTO) {
        return new Aluno( );
    }

    public Aluno fromDTO(AlunoNewDTO alunoNewDTO) {

         Aluno aluno = new Aluno(null, alunoNewDTO.getNome(), null, null, null, null, null, null, null, false, null, null, null, false, null);

         return aluno;

    }
}
