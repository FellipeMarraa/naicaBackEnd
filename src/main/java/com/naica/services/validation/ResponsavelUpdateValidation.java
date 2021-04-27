package com.naica.services.validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.naica.domain.Responsavel;
import com.naica.domain.dto.ResponsavelDTO;
import com.naica.repositories.ResponsavelRepository;
import com.naica.resources.exception.FieldMessage;

public class ResponsavelUpdateValidation implements ConstraintValidator<ResponsavelUpdate, ResponsavelDTO> {

    @Autowired
    private ResponsavelRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(ResponsavelUpdate responsavelUpdate) {

    }

    @Override
    public boolean isValid(ResponsavelDTO responsavelDTO, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

//
        Responsavel verificaNome = repository.findByNome(responsavelDTO.getNome());
        if (verificaNome != null && !verificaNome .equals(uriId)) {
            list.add(new FieldMessage("nome", "Responsavel já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


        return list.isEmpty();
    }

}
