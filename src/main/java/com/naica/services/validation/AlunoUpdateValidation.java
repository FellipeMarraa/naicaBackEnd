package com.naica.services.validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.naica.repository.AlunoRepository;
import com.naica.resources.exception.FieldMessage;

public class AlunoUpdateValidation implements ConstraintValidator<AlunoUpdate, AlunoDTO> {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(AlunoUpdate alunoUpdate) {

    }

    @Override
    public boolean isValid(AlunoDTO alunoDTO, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

//
        Aluno verificaNome = repository.findByNome(alunoDTO.getNome());
        if (verificaNome != null && !verificaNome .equals(uriId)) {
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
