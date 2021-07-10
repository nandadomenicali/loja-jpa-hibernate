package br.com.alura.model.testes;

import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;
import br.com.alura.model.dao.CategoriaDao;
import br.com.alura.model.dao.ProdutoDao;
import br.com.alura.model.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {

    public static void main(String[] args){
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println(p.getPreco());

        List<Produto> todos = produtoDao.buscarTodos();
        todos.forEach(p2 -> System.out.println(p.getNome()));

        BigDecimal precoProduto = produtoDao.busrcarPrecoDoProdutoComNome("iPhone");
        System.out.println("preco do produto: " + precoProduto);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("iPhone 12", "Novo iPhone de 2021",
                new BigDecimal("4000"), celulares );

       EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
