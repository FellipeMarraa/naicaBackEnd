package com.naica.services.validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.naica.domain.Coordenador;
import com.naica.domain.dto.CoordenadorDTO;
import com.naica.repositories.CoordenadorRepository;
import com.naica.resources.exception.FieldMessage;

public class CoordenadorUpdateValidation implements ConstraintValidator<CoordenadorUpdate, CoordenadorDTO> {

    @Autowired
    private CoordenadorRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(CoordenadorUpdate coordenadorUpdate) {

    }

    @Override
    public boolean isValid(CoordenadorDTO coordenadorDTO, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

//
        Coordenador verificaNome = repository.findByNome(coordenadorDTO.getNome());
        if (verificaNome != null && !verificaNome .equals(uriId)) {
            list.add(new FieldMessage("nome", "Coordenador já cadastrado!"));
        }
        
        Coordenador verificaEmail = repository.findByEmail(coordenadorDTO.getNome());
        if (verificaEmail != null && !verificaEmail .equals(uriId)) {
            list.add(new FieldMessage("email", "Coordenador já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


        return list.isEmpty();
    }

}
