package it.prova.ordinearticolocategoriajpa.service.articolo;

import it.prova.ordinearticolocategoriajpa.dao.EntityManagerUtil;
import it.prova.ordinearticolocategoriajpa.dao.articolo.ArticoloDAO;
import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class ArticoloServiceImpl implements ArticoloService{

    private ArticoloDAO articoloDAO;


    @Override
    public List<Articolo> listAll() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return articoloDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Articolo caricaSingoloElemento(Long id) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return articoloDAO.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiorna(Articolo articoloInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            articoloDAO.update(articoloInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void inserisciNuovo(Articolo articoloInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            articoloDAO.insert(articoloInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void rimuovi(Articolo articoloInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            articoloDAO.delete(articoloInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void aggiungiArticolo(Articolo articoloInstance, Categoria categoriaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();


            articoloDAO.setEntityManager(entityManager);

            articoloInstance = entityManager.merge(articoloInstance);

            categoriaInstance = entityManager.merge(categoriaInstance);

            articoloInstance.getCategorie().add(categoriaInstance);


            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void creaECollegaArticoloECategoria(Articolo articoloInstance, Categoria categoriaInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            articoloDAO.setEntityManager(entityManager);

            //collego le due entità: questa cosa funziona grazie al fatto che ho
            //CascadeType.PERSIST, CascadeType.MERGE dentro l'owner della relazione
            articoloInstance.getCategorie().add(categoriaInstance);

            articoloDAO.insert(articoloInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Articolo> cercaArticoloConOrdine(Ordine ordineInput) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return articoloDAO.findArticoliInOrdine(ordineInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Articolo> cercaArticoloConCategoria(Categoria categoriaInput) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return articoloDAO.findArticoliConCategoria(categoriaInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Integer sommaPrezziArticoliDellaCategoria(Categoria categoriaInput) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return articoloDAO.countPrezziArticoliByCategoria(categoriaInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void setArticoloDAO(ArticoloDAO articoloDAO) {
        this.articoloDAO = articoloDAO;
    }
}
