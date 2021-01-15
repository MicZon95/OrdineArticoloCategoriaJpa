package it.prova.ordinearticolocategoriajpa.dao.ordine;

import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrdineDAOImpl implements OrdineDAO{

    private EntityManager entityManager;

    @Override
    public List<Ordine> list() throws Exception {
        return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
    }

    @Override
    public Ordine get(Long id) throws Exception {
        return entityManager.find(Ordine.class, id);
    }

    @Override
    public void update(Ordine input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        input = entityManager.merge(input);
    }

    @Override
    public void insert(Ordine input) throws Exception {
        if (input == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.persist(input);
    }

    @Override
    public void delete(Ordine input) throws Exception {
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
    public Ordine getEagerArticoli(Long id) throws Exception {
        TypedQuery<Ordine> query = entityManager
                .createQuery("from Ordine o left join fetch o.articoli where o.id = ?1", Ordine.class);
        query.setParameter(1, id);

        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<Ordine> findOrdiniByCategoria(Categoria categoriaInput) throws Exception {
        TypedQuery<Ordine> query = entityManager
                .createQuery("select o from Ordine o left join fetch o.articoli a left join fetch a.categorie c where c = :categoria", Ordine.class);
        query.setParameter("categoria", categoriaInput);

        return query.getResultList();
    }


}
