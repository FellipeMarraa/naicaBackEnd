package com.naica.services.validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.naica.domain.Unidade;
import com.naica.domain.dto.UnidadeDTO;
import com.naica.repositories.UnidadeRepository;
import com.naica.resources.exception.FieldMessage;

public class UnidadeUpdateValidation implements ConstraintValidator<UnidadeUpdate, UnidadeDTO> {

    @Autowired
    private UnidadeRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(UnidadeUpdate unidadeUpdate) {

    }

    @Override
    public boolean isValid(UnidadeDTO unidadeDTO, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

//
        Unidade verificaNome = repository.findByNome(unidadeDTO.getNome());
        if (verificaNome != null && !verificaNome .equals(uriId)) {
            list.add(new FieldMessage("nome", "Unidade já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


        return list.isEmpty();
    }

}
