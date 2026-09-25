package br.com.exemplo.avl.model;

import java.time.LocalDateTime;

public class Solicitacao {
    private int numero;
    private String solicitante;
    private String descricao;
    private LocalDateTime dataAbertura;

    public Solicitacao(int numero, String solicitante, String descricao) {
        this.numero = numero;
        this.solicitante = solicitante;
        this.descricao = descricao;
        this.dataAbertura = LocalDateTime.now();
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }



    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
