package com.naica.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.naica.domain.Unidade;
import com.naica.domain.dto.UnidadeDTO;
import com.naica.domain.dto.UnidadeNewDTO;
import com.naica.services.UnidadeService;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeResource {

    @Autowired
    private UnidadeService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Unidade getById(@PathVariable Integer id) {
        return service.find(id);
    }

    @RequestMapping(value = "/list", method=RequestMethod.GET)
    public ResponseEntity<List<UnidadeDTO>> findAll() {
        List<Unidade> list = service.findAll();
        List<UnidadeDTO> listDto = list.stream().map(obj -> new UnidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public ResponseEntity<Unidade> insert(@Valid @RequestBody UnidadeNewDTO unidadeNewDTO) {
        Unidade unidade = service.fromDTO(unidadeNewDTO);
        unidade = service.insert(unidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(unidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody UnidadeDTO unidadeDTO, @PathVariable Integer id){
        Unidade unidade = service.fromDTO(unidadeDTO);
        unidade.setId(id);
        unidade = service.update(unidade);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Void delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Unidade> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                         @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                         @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                         @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Unidade> list = service.findPage(page, linesPerPage, orderBy, direction);

        return list;
    }


}
