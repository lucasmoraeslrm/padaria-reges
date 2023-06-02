
package com.mycompany.padariareges;

class Item {
    private final int codigo;
    private final String nome;
    private final double preco;

    public Item(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
