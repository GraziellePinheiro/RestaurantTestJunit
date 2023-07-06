package com.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Prato> pratos;
    private List<Bebida> bebidas;


    public Restaurante(){
        pratos = new ArrayList<>();
        bebidas = new ArrayList<>();
    }

    public void cadastrarPrato(Prato prato){
        pratos.add(prato);
    }

    public void cadastrarBebida(Bebida bebida){
        bebidas.add(bebida);
    }

    public double calcularValorConta(List<Produto> produtosSelecionados, boolean adicionarServico, boolean pagamentoEmDinheiro){
        double valorTotal = 0;

        for(Produto produto : produtosSelecionados){
            valorTotal += produto.getPreco();
        }

        if(adicionarServico){
            valorTotal += valorTotal * 0.1; //Adiciona 10%
        }

        if(pagamentoEmDinheiro){
            valorTotal -= valorTotal * 0.05; //Aplica 5% de desconto
        }

        return valorTotal;
    }

    public boolean removerProduto(Produto produto){
        if(produto instanceof Prato){
            return pratos.remove(produto);
        }else if (produto instanceof Bebida){
            return bebidas.remove(produto);
        }
        return false;
    }
    
    public void registrarPerda(Produto produto){
        if(produto instanceof Prato){
            pratos.remove(produto);
        }else if (produto instanceof Bebida){
            bebidas.remove(produto);
        }
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }
}
