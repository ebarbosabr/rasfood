package br.com.rasmoo.restaurant.dao;

import br.com.rasmoo.restaurant.entity.Categoria;
import br.com.rasmoo.restaurant.entity.Cliente;
import br.com.rasmoo.restaurant.entity.ClienteId;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cliente cliente) {

        this.entityManager.persist(cliente);
    }

    public Cliente consultarPorId(final ClienteId id) {

        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        String query = "SELECT c FROM Cliente c"; //Consulta personalizada JPQL
        return this.entityManager.createQuery(query, Cliente.class).getResultList();
    }

    public List<Cliente> consultarPorNome(final String nome) {
        String query = "SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE UPPER(:nome)"; //Consulta personalizada JPQL
        return this.entityManager.createQuery(query, Cliente.class).setParameter("nome", "%"+nome+"%").getResultList();
    }

    public void atualizar(final Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }
}
