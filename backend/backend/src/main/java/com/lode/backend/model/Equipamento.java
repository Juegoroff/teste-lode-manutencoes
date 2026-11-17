package com.lode.backend.model;

	import java.time.LocalDate;

	import jakarta.persistence.Entity;
	import jakarta.persistence.EnumType;
	import jakarta.persistence.Enumerated;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	import jakarta.validation.constraints.NotBlank;

	@Entity
	@Table(name = "equipamentos")
	public class Equipamento {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Nome é obrigatório")
	    private String nome;

	    @Enumerated(EnumType.STRING)
	    private TipoEquipamento tipo;

	    private LocalDate dataInstalacao;

	    @Enumerated(EnumType.STRING)
	    private StatusEquipamento status;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public TipoEquipamento getTipo() {
	        return tipo;
	    }

	    public void setTipo(TipoEquipamento tipo) {
	        this.tipo = tipo;
	    }

	    public LocalDate getDataInstalacao() {
	        return dataInstalacao;
	    }

	    public void setDataInstalacao(LocalDate dataInstalacao) {
	        this.dataInstalacao = dataInstalacao;
	    }

	    public StatusEquipamento getStatus() {
	        return status;
	    }

	    public void setStatus(StatusEquipamento status) {
	        this.status = status;
	    }
	}

