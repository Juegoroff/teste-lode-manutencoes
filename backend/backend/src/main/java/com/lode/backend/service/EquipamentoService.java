package com.lode.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lode.backend.model.Equipamento;
import com.lode.backend.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    public List<Equipamento> listarTodos() {
        return repository.findAll();
    }

    public Equipamento salvar(Equipamento equipamento) {
        return repository.save(equipamento);
    }

    public Equipamento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public Equipamento atualizar(Long id, Equipamento equipamento) {

        Equipamento existente = buscarPorId(id);

        existente.setNome(equipamento.getNome());
        existente.setTipo(equipamento.getTipo());
        existente.setDataInstalacao(
                equipamento.getDataInstalacao());
        existente.setStatus(
                equipamento.getStatus());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}