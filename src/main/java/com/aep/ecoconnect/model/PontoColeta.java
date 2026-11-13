package com.aep.ecoconnect.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "pontos_coleta")
public class PontoColeta {

    @Id
    private String id;
    private String nome;
    private String tipoResiduo;
    private String endereco;
    private String capacidadeKg;
    private List<HorarioFuncionamento> horarios = new ArrayList<>();

    public PontoColeta() {}

    public PontoColeta(String id, String nome, String tipoResiduo, String endereco, String capacidadeKg) {
        this.id = id;
        this.nome = nome;
        this.tipoResiduo = tipoResiduo;
        this.endereco = endereco;
        this.capacidadeKg = capacidadeKg;
    }

    public PontoColeta(String id, String nome, String tipoResiduo, String endereco, String capacidadeKg, List<HorarioFuncionamento> horarios) {
        this.id = id;
        this.nome = nome;
        this.tipoResiduo = tipoResiduo;
        this.endereco = endereco;
        this.capacidadeKg = capacidadeKg;
        this.horarios = horarios;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipoResiduo() { return tipoResiduo; }
    public void setTipoResiduo(String tipoResiduo) { this.tipoResiduo = tipoResiduo; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCapacidadeKg() { return capacidadeKg; }
    public void setCapacidadeKg(String capacidadeKg) { this.capacidadeKg = capacidadeKg; }

    public List<HorarioFuncionamento> getHorarios() { return horarios; }
    public void setHorarios(List<HorarioFuncionamento> horarios) { this.horarios = horarios; }
}