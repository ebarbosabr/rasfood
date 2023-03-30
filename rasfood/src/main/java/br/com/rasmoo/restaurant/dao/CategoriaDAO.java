package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Cardapio;
import br.com.rasmoo.restaurant.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDAO {
    private EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos() {
        String query = "SELECT c FROM Categoria c"; //Consulta personalizada JPQL
        return this.entityManager.createQuery(query, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
