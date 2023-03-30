package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.ClienteDAO;
import br.com.rasmoo.restaurant.dao.EnderecoDAO;
import br.com.rasmoo.restaurant.dao.OrdemDAO;
import br.com.rasmoo.restaurant.entity.ClienteId;
import br.com.rasmoo.restaurant.entity.Ordem;
import br.com.rasmoo.restaurant.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);
        //OrdemDAO ordemDao = new OrdemDAO(entityManager);
        //ordemDao.consultarItensMaisVendidos().forEach(item->System.out.println("Item: "+item[0]+"\t-\tQuantidade: "+item[1]));
        //Ordem ordem = ordemDao.joinFetchedCliente(2);
        //ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        //clienteDAO.consultarPorNome("TAy")
        //EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);
        //System.out.println("1: " + enderecoDAO.consultarClientes(null, null, "Lapa"));
        //System.out.println("2: " + enderecoDAO.consultarClientesUsandoCriteria(null, null, "LApA"));

        ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        System.out.println("Todos: " + clienteDAO.consultarTodos());
        System.out.println(clienteDAO.consultarPorId(new ClienteId("111111111123","tayane@gmail.com")));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}