package br.com.rasmoo.restaurant.service.test;

import br.com.rasmoo.restaurant.dao.CardapioDAO;
import br.com.rasmoo.restaurant.util.CargaDeDadosUtil;
import br.com.rasmoo.restaurant.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasfood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDAO cardapioDAO = new CardapioDAO(entityManager);
        //System.out.println("Lista de produtos por valor: " + cardapioDAO.consultarPorValor(BigDecimal.valueOf(20.00)));
        System.out.println("O produto pesquisado foi: " + cardapioDAO.consultarPorNome("moqueCa"));
        entityManager.close();
    }
}
