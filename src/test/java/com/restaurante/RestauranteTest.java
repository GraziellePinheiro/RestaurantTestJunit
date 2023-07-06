package com.restaurante;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestauranteTest {
    private Restaurante restaurante;


    @BeforeEach
    public void setUp(){
        restaurante = new Restaurante();
    }

    @Test
    @DisplayName("Deve cadastrar prato")
    public void testCadastrarPrato(){
        Prato prato = new Prato("MassaArtesanal", 69.90);
        restaurante.cadastrarPrato(prato);
        List<Prato> pratos = new ArrayList<>();
        pratos.add(prato);

        Assertions.assertEquals(pratos.size(), 1);
    }

    @Test
    @DisplayName("Deve cadastrar bebida")
    public void testCadastrarBebida(){
        Bebida bebida = new Bebida("GuaranaAntartica", 12.0);
        restaurante.cadastrarBebida(bebida);
        List<Bebida> bebidas = new ArrayList<Bebida>();
        bebidas.add(bebida);

        Assertions.assertEquals(bebidas.size(), 1);
    }

    @Test
    @DisplayName("Cadastrar diversos produtos de uma só vez")
    public void testCadastrarVariosProdutos(){
        List<Prato> pratos = new ArrayList<>();
        pratos.add(new Prato("MassaArtesanal", 69.90));
        pratos.add(new Prato("Nhoque a Bolognese Individual", 79.90));
        pratos.add(new Prato("Spaghetti la Carbonara", 69.90));

        for(Prato prato : pratos){
            restaurante.cadastrarPrato(prato);
        }


        // Verificar se os pratos foram cadastrados corretamente
        List<Prato> pratosCadastrados = restaurante.getPratos();
        Assertions.assertEquals(pratos, pratosCadastrados);

    
        // Verificar se a quantidade de pratos cadastrados é a mesma que a quantidade esperada
        int quantEsperada = pratos.size();
        int quantCadastrada = pratosCadastrados.size();
        Assertions.assertEquals(quantEsperada, quantCadastrada);

        //Verificar se o prato especifico foi cadastrado
        Prato pratoEspecifico = new Prato("Spaghetti la Carbonara", 69.90);
        Assertions.assertTrue(pratosCadastrados.contains(pratoEspecifico));
    }

    @Test
    @DisplayName("Deve calcular valor da conta sem desconto e com serviço")
    public void testCalcularValorContaComum(){
        Prato prato = new Prato("Spaghetti la Carbonara", 69.90);
        Bebida bebida = new Bebida("VinhoBranco", 42.00);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(prato);
        produtos.add(bebida);

        double valorTotal = prato.getPreco() + bebida.getPreco();
        double valorComServico = valorTotal + (valorTotal * 0.1);

        double conta = restaurante.calcularValorConta(produtos, true, false);
        Assertions.assertEquals(conta, valorComServico);
    }

    @Test
    @DisplayName("Deve calcular valor da conta com desconto e sem serviço")
    public void testCalcularValorContaComDescSemServ(){
        Prato prato = new Prato("Spaghetti la Carbonara", 69.90);
        Bebida bebida = new Bebida("VinhoBranco", 42.00);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(prato);
        produtos.add(bebida);

        double valorTotal = prato.getPreco() + bebida.getPreco();
        double valorComDesconto = valorTotal - (valorTotal * 0.05);
        

        double conta = restaurante.calcularValorConta(produtos, false, true);

        Assertions.assertEquals(conta, valorComDesconto);
    }

    @Test
    @DisplayName("Deve calcular valor da conta sem desconto e sem serviço")
    public void testCalcularValorContaSemServiSemDesc(){

        Prato prato = new Prato("Spaghetti la Carbonara", 69.90);
        Bebida bebida = new Bebida("VinhoBranco", 42.00);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(prato);
        produtos.add(bebida);

        double valorTotal = prato.getPreco() + bebida.getPreco();

        double conta = restaurante.calcularValorConta(produtos, false, false);
        Assertions.assertEquals(conta, valorTotal);
    }

    @Test
    @DisplayName("Deve calcular valor da conta com desconto e com serviço")
    public void testCalcularValorContaComServiComDesc(){

        Prato prato = new Prato("Spaghetti la Carbonara", 69.90);
        Bebida bebida = new Bebida("VinhoBranco", 42.00);

        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(prato);
        produtos.add(bebida);

        double valorTotal = prato.getPreco() + bebida.getPreco();
        double valorTotalComServico = valorTotal + (valorTotal * 0.1); 
        double valorComDesconComServ = valorTotalComServico - (valorTotalComServico * 0.05);
        

        double conta = restaurante.calcularValorConta(produtos, true, true);

        Assertions.assertEquals(conta, valorComDesconComServ);

    }

}
