package com.mycompany.padariareges;
import java.util.ArrayList;
import java.util.List;


class Prateleira {
    private final List<Item> itens;

    public Prateleira() {
        itens = new ArrayList<>();
    }
    
    public void cadastrarItem(int codigo, String nome, double preco) {
        Item item = new Item(codigo, nome, preco);
        itens.add(item);
    }
    

    public void listarItens() {
        System.out.println("Código\tNome\t\tPreço");
        for (Item item : itens) {
            System.out.println(item.getCodigo() + "\t" + item.getNome() + "\t" + item.getPreco());
        }
    }

    public Item getItem(int codigo) {
        for (Item item : itens) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

   
}
