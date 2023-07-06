package com.restaurante;

import com.google.common.base.Objects;

public class Prato extends Produto{

    public Prato(String nome, double preco) {
        super(nome, preco);
        //TODO Auto-generated constructor stub
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Prato other = (Prato) obj;
        return Objects.equal(getNome(), other.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNome());
    }
}
