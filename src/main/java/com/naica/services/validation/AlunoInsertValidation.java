package com.naica.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.naica.repository.AlunoRepository;
import com.naica.resources.exception.FieldMessage;

public class AlunoInsertValidation implements ConstraintValidator<AlunoInsert, AlunoNewDTO> {

    @Autowired
    private AlunoRepository repository;

    @Override
    public void initialize(AlunoInsert alunoInsert) {

    }

    @Override
    public boolean isValid(AlunoNewDTO alunoNewDTO, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Aluno verificaNome = repository.findByNome(alunoNewDTO.getNome());
        if (verificaNome != null) {
            list.add(new FieldMessage("nome", "Aluno já cadastrado!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }


            return list.isEmpty();
        }

}
