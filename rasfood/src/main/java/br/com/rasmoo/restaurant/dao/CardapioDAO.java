package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class CardapioDAO {
    private EntityManager entityManager;

    public CardapioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos() {
        try {
            String jpql = "SELECT c FROM Cardapio c"; //Consulta personalizada JPQL
            return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
        } catch(Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Cardapio> consultarPorValor(BigDecimal filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE valor = :valor";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", filtro).getResultList();
        } catch(Exception e) {
            return Collections.emptyList();
        }
    }

    public Cardapio consultarPorNome(String filtro) {
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("nome", filtro).getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
