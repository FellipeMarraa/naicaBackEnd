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

import com.naica.domain.Coordenador;
import com.naica.domain.dto.CoordenadorDTO;
import com.naica.domain.dto.CoordenadorNewDTO;
import com.naica.services.CoordenadorService;

@RestController
@RequestMapping(value = "/coordenador")
public class CoordenadorResource {

    @Autowired
    private CoordenadorService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Coordenador getById(@PathVariable Integer id) {
        return service.find(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Coordenador> list() {
        return service.findAll();
    }

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public ResponseEntity<Coordenador> insert(@Valid @RequestBody CoordenadorNewDTO coordenadorNewDTO) {
        Coordenador coordenador = service.fromDTO(coordenadorNewDTO);
        coordenador = service.insert(coordenador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(coordenador.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Coordenador> update(@Valid @RequestBody CoordenadorDTO coordenadorDTO, @PathVariable Integer id) {
        Coordenador coordenador = service.fromDTO(coordenadorDTO);
        coordenador.setId(id);
        coordenador = service.update(coordenador);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Coordenador> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Coordenador> list = service.findPage(page, linesPerPage, orderBy, direction);

        return list;
    }


}
