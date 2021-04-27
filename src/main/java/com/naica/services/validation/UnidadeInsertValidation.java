package com.naica.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.naica.domain.Unidade;
import com.naica.domain.dto.UnidadeNewDTO;
import com.naica.repositories.UnidadeRepository;
import com.naica.resources.exception.FieldMessage;

public class UnidadeInsertValidation implements ConstraintValidator<UnidadeInsert, UnidadeNewDTO> {

    @Autowired
    private UnidadeRepository repository;

    @Override
    public void initialize(UnidadeInsert unidadeInsert) {

    }

    @Override
    public boolean isValid(UnidadeNewDTO unidadeNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Unidade verificaNome = repository.findByNome(unidadeNewDTO.getNome());
        if (verificaNome != null) {
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
