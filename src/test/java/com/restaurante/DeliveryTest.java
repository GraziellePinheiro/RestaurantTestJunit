package com.restaurante;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryTest {
    private Delivery delivery;
    private Prato prato;
    private Bebida bebida;


    @BeforeEach
    public void setUp(){
        delivery = new Delivery();
        prato = new Prato("Spaghetti la Carbonara", 69.90);
        bebida = new Bebida("Vinho Branco", 129.00);
    }


    @Test 
    @DisplayName("Adicionar produto ao delivery")
    public void testAdicionarProdutoDelivery(){
        delivery.adicionarProduto(prato, 2);
        
        delivery.adicionarProduto(bebida, 1);

        Assertions.assertEquals(2, delivery.getQuantidadeProduto(prato));
        Assertions.assertEquals(1, delivery.getQuantidadeProduto(bebida));
    }

    @Test
    @DisplayName("Deve remover produto do Delivery adicionado")
    public void testRemoverProdutoDoDeliveryAdicionado(){
        delivery.adicionarProduto(prato, 2);
        
        delivery.adicionarProduto(bebida, 1);

        delivery.removerProduto(bebida, 1);

        Assertions.assertFalse(delivery.getProdutos().containsKey(bebida));
        Assertions.assertTrue(delivery.getProdutos().containsKey(prato));
    }

    @Test
    @DisplayName("Deve calcular valor total do delivery")
    public void testCalcularValorTotal() {
        
        delivery.adicionarProduto(prato, 2);
        delivery.adicionarProduto(bebida, 3);

        delivery.setTaxaEntrega(10.0);

        double valorTotalEsperado = (prato.getPreco() * 2) + (bebida.getPreco() * 3) + 10.0;
        double valorTotalCalculado = delivery.calcularValorTotal();

        Assertions.assertEquals(valorTotalEsperado, valorTotalCalculado);
    }

    
}
