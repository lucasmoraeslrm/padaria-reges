package com.mycompany.padariareges;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class Cliente extends Pessoa {
    private int pontos;
    private final List<Item> itensComprados;
    private final List<Integer> quantidadesCompradas;

    public Cliente(String nomeCompleto, String email, String endereco, String telefone, Calendar dataNasc,
                   String documento, String rgIe) {
        super(nomeCompleto, email, endereco, telefone, dataNasc, documento, rgIe);
        this.pontos = 0;
        this.itensComprados = new ArrayList<>();
        this.quantidadesCompradas = new ArrayList<>();
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int quantidade) {
        pontos += quantidade;
    }
    
    public List<Item> getItensComprados() {
        return itensComprados;
    }


    public List<Integer> getQuantidadesCompradas() {
        return quantidadesCompradas;
    }
}
