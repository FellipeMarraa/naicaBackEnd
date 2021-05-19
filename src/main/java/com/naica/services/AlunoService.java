package com.naica.services;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.naica.domain.Responsavel;
import com.naica.repositories.ResponsavelRepository;
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

import javax.swing.text.html.Option;

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

    public List<Aluno> findAll() {
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
        newAluno.setUnidade(aluno.getUnidade());
        newAluno.setDataNascimento(aluno.getDataNascimento());
        newAluno.setIdadeAtual(aluno.getIdadeAtual());
        newAluno.setIdadeInicial(aluno.getIdadeInicial());
        newAluno.setSexo(aluno.getSexo());
        newAluno.setNisAtendido(aluno.getNisAtendido());
        newAluno.setDataMatricula(aluno.getDataMatricula());
        newAluno.setDesligado(aluno.isDesligado());
        newAluno.setEscola(aluno.getEscola());
        newAluno.setAnoEscolar(aluno.getAnoEscolar());
        newAluno.setPeriodoEscolar(aluno.getPeriodoEscolar());
        newAluno.setDesacompanhado(aluno.isDesacompanhado());
        newAluno.setAutorizadoBuscar(aluno.getAutorizadoBuscar());
        newAluno.setResponsavel(aluno.getResponsavel());
    }


    public Aluno fromDTO(AlunoDTO alunoDTO) {
        return new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getDataNascimento(), alunoDTO.getIdadeAtual(),alunoDTO.getIdadeInicial(), alunoDTO.getSexo(),alunoDTO.getNisAtendido() , alunoDTO.getDataMatricula(), alunoDTO.isDesligado(), alunoDTO.getEscola(), alunoDTO.getAnoEscolar(), alunoDTO.getPeriodoEscolar(), alunoDTO.isDesacompanhado(), alunoDTO.getAutorizadoBuscar(), alunoDTO.getResponsavel(),alunoDTO.getUnidade());

    }

    public Aluno fromDTO(AlunoNewDTO alunoNewDTO) {

         Aluno aluno = new Aluno(null, alunoNewDTO.getNome(), alunoNewDTO.getDataNascimento(), alunoNewDTO.getIdadeAtual(),alunoNewDTO.getIdadeInicial(), alunoNewDTO.getSexo(),alunoNewDTO.getNisAtendido() , alunoNewDTO.getDataMatricula(), alunoNewDTO.isDesligado(), alunoNewDTO.getEscola(), alunoNewDTO.getAnoEscolar(), alunoNewDTO.getPeriodoEscolar(), alunoNewDTO.isDesacompanhado(), alunoNewDTO.getAutorizadoBuscar(), alunoNewDTO.getResponsavel(), alunoNewDTO.getUnidade());

         return aluno;

    }

}
