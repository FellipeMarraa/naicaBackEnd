package com.naica.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.naica.domain.Responsavel;
import com.naica.domain.dto.ResponsavelNewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.naica.domain.Aluno;
import com.naica.domain.dto.AlunoDTO;
import com.naica.domain.dto.AlunoNewDTO;
import com.naica.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Aluno getById(@PathVariable Integer id) {
        return service.find(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Aluno> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public ResponseEntity<Aluno> insert(@Valid @RequestBody AlunoNewDTO alunoNewDTO) {
        Aluno aluno = service.fromDTO(alunoNewDTO);
        aluno = service.insert(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Aluno> update(@Valid @RequestBody AlunoDTO alunoDTO, @PathVariable Integer id) {
        Aluno aluno = service.fromDTO(alunoDTO);
        aluno.setId(id);
        aluno = service.update(aluno);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Aluno> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Aluno> list = service.findPage(page, linesPerPage, orderBy, direction);

        return list;
    }


}
