package com.lode.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.lode.backend.model.Equipamento;
import com.lode.backend.model.StatusEquipamento;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class EquipamentoTest {

    @Test
    void naoDevePermitirNomeVazio() {

        Equipamento equipamento = new Equipamento();

        equipamento.setNome("");

        Validator validator = Validation
                .buildDefaultValidatorFactory()
                .getValidator();

        Set<ConstraintViolation<Equipamento>> violations =
                validator.validate(equipamento);

        assertFalse(violations.isEmpty());
    }

    @Test
    void deveAlterarStatusCorretamente() {

        Equipamento equipamento = new Equipamento();

        equipamento.setStatus(
                StatusEquipamento.OPERACIONAL);

        equipamento.setStatus(
                StatusEquipamento.CRITICO);

        assertEquals(
                StatusEquipamento.CRITICO,
                equipamento.getStatus());
    }
}