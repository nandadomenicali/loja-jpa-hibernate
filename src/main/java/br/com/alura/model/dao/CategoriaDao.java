package br.com.alura.model.dao;

import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria){

    }
}
