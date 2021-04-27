package com.naica.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.naica.domain.Coordenador;
import com.naica.domain.dto.CoordenadorNewDTO;
import com.naica.repositories.CoordenadorRepository;
import com.naica.resources.exception.FieldMessage;

public class CoordenadorInsertValidation implements ConstraintValidator<CoordenadorInsert, CoordenadorNewDTO> {

    @Autowired
    private CoordenadorRepository repository;

    @Override
    public void initialize(CoordenadorInsert coordenadorInsert) {

    }

    @Override
    public boolean isValid(CoordenadorNewDTO coordenadorNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Coordenador verificaNome = repository.findByNome(coordenadorNewDTO.getNome());
        if (verificaNome != null) {
            list.add(new FieldMessage("nome", "Coordenador já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


            return list.isEmpty();
        }

}
