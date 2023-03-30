package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Ordem;
import br.com.rasmoo.restaurant.vo.ItensPrincipaisVO;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDAO {
    private EntityManager entityManager;

    public OrdemDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultar(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos() {
        String jpql = "SELECT c FROM Ordem o"; //Consulta personalizada JPQL
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public List<ItensPrincipaisVO> consultarItensMaisVendidos() {
        String jpql = "SELECT new br.com.rasmoo.restaurant.vo.ItensPrincipaisVO(c.nome, SUM(oc.quantidade)) " +
                      "FROM Ordem o " +
                      "JOIN OrdensCardapio oc ON o.id = oc.cardapio.id " +
                      "JOIN oc.cardapio c " +
                      "GROUP BY c.nome " +
                      "ORDER BY SUM(oc.quantidade) DESC"; //Consulta personalizada JPQL
        return this.entityManager.createQuery(jpql, ItensPrincipaisVO.class).getResultList();
    }

    public Ordem joinFetchedCliente(final Integer id) {
        String jpql = "SELECT o FROM Ordem o JOIN FETCH o.cliente WHERE o.id = :id"; //Consulta personalizada JPQL
        return this.entityManager.createQuery(jpql, Ordem.class).setParameter("id", id).getSingleResult();
    }

    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
