package com.restaurante;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Delivery {
    private Map<Produto, Integer> produtos;
    private double taxaEntrega;

    public Delivery(){
        produtos = new HashMap<>();
        taxaEntrega = 0;
    }

    public void adicionarProduto(Produto produto, int quantidade){
        produtos.put(produto, quantidade);
    }

    public void removerProduto(Produto produto, int quantidade){
        produtos.remove(produto, quantidade);
    }

    public double calcularValorTotal(){
        double valorTotal = 0;

        for(Map.Entry<Produto, Integer> entry : produtos.entrySet()){
            Produto produto = entry.getKey();
            int quantidade = entry.getValue();
            valorTotal += produto.getPreco() * quantidade;
        }

        valorTotal += taxaEntrega;
        return valorTotal;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }
    
    public int getQuantidadeProduto(Produto produto){
        return produtos.getOrDefault(produto, 0);
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }

}
