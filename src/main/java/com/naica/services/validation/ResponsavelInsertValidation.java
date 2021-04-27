package com.naica.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.naica.domain.Responsavel;
import com.naica.domain.dto.ResponsavelNewDTO;
import com.naica.repositories.ResponsavelRepository;
import com.naica.resources.exception.FieldMessage;

public class ResponsavelInsertValidation implements ConstraintValidator<ResponsavelInsert, ResponsavelNewDTO> {

    @Autowired
    private ResponsavelRepository repository;

    @Override
    public void initialize(ResponsavelInsert responsavelInsert) {

    }

    @Override
    public boolean isValid(ResponsavelNewDTO responsavelNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Responsavel verificaNome = repository.findByNome(responsavelNewDTO.getNome());
        if (verificaNome != null) {
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
