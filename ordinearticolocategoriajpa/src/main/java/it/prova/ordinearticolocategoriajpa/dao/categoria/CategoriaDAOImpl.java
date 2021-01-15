package it.prova.ordinearticolocategoriajpa.dao.categoria;

import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriaDAOImpl implements CategoriaDAO{

    private EntityManager entityManager;

    @Override
    public List<Categoria> list() throws Exception {
        return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }

    @Override
    public Categoria get(Long id) throws Exception {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void update(Categoria input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Categoria input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Categoria input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(input));
    }

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Categoria> findCategorieArticoliByOrdine(Ordine ordineInput) throws Exception {
        TypedQuery<Categoria> query = entityManager
                .createQuery("select c from Categoria c left join fetch c.articoli a left join fetch a.ordine o where o = :ordine", Categoria.class);
        query.setParameter("ordine", ordineInput);
        return query.getResultList();
    }
}
