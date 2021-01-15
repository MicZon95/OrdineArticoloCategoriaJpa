package it.prova.ordinearticolocategoriajpa.dao.articolo;

import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArticoloDAOImpl implements ArticoloDAO{

    private EntityManager entityManager;


    @Override
    public List<Articolo> list() throws Exception {
        return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
    }

    @Override
    public Articolo get(Long id) throws Exception {
        return entityManager.find(Articolo.class, id);
    }

    @Override
    public void update(Articolo input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Articolo input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Articolo input) throws Exception {
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
    public List<Articolo> findArticoliInOrdine(Ordine ordineInput) throws Exception {
        TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join a.ordine o where o = :ordine",Articolo.class);
        query.setParameter("ordine", ordineInput);
        return query.getResultList();
    }

    @Override
    public List<Articolo> findArticoliConCategoria(Categoria categoriaInput) throws Exception {
        TypedQuery<Articolo> query = entityManager.createQuery("select a FROM Articolo a join a.categorie c where c = :categoria",Articolo.class);
        query.setParameter("categoria", categoriaInput);
        return query.getResultList();
    }

    @Override
    public Integer countPrezziArticoliByCategoria(Categoria categoriaInput) throws Exception {
        TypedQuery<Long> query = entityManager.createQuery("select SUM(a.prezzoSingolo) FROM Articolo a join a.categorie c where c = :categoria",Long.class);
        query.setParameter("categoria", categoriaInput);
        return query.getSingleResult().intValue();
    }
}
