package com.lode.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lode.backend.model.Equipamento;

public interface EquipamentoRepository
        extends JpaRepository<Equipamento, Long> {
}