package br.com.alura.model.dao;

import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto){
        this.em.persist(produto);
    }

    public void atualizar(Produto produto){
        this.em.merge(produto);
    }

    public void remover(Produto produto){
        produto = em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT * FROM Produto p";
        return em.createQuery("jpql").getResultList();
    }

    public List<Produto> busrcarPorNome(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery("jpql")
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> busrcarPorNomeDaCategoria(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
        return em.createQuery("jpql")
                .setParameter("nome", nome)
                .getResultList();
    }

}
