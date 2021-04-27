package com.naica.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.naica.domain.Responsavel;
import com.naica.domain.dto.ResponsavelDTO;
import com.naica.domain.dto.ResponsavelNewDTO;
import com.naica.services.ResponsavelService;

@RestController
@RequestMapping(value = "/responsavel")
public class ResponsavelResource {

    @Autowired
    private ResponsavelService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Responsavel getById(@PathVariable Integer id) {
        return service.find(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Responsavel> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public ResponseEntity<Responsavel> insert(@Valid @RequestBody ResponsavelNewDTO responsavelNewDTO) {
        Responsavel responsavel = service.fromDTO(responsavelNewDTO);
        responsavel = service.insert(responsavel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(responsavel.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Responsavel> update(@Valid @RequestBody ResponsavelDTO responsavelDTO, @PathVariable Integer id) {
        Responsavel responsavel = service.fromDTO(responsavelDTO);
        responsavel.setId(id);
        responsavel = service.update(responsavel);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Responsavel> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Responsavel> list = service.findPage(page, linesPerPage, orderBy, direction);

        return list;
    }
}