package it.prova.ordinearticolocategoriajpa.service.categoria;

import it.prova.ordinearticolocategoriajpa.dao.EntityManagerUtil;
import it.prova.ordinearticolocategoriajpa.dao.articolo.ArticoloDAO;
import it.prova.ordinearticolocategoriajpa.dao.articolo.ArticoloDAOImpl;
import it.prova.ordinearticolocategoriajpa.dao.categoria.CategoriaDAO;
import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaDAO categoriaDAO;


    @Override
    public List<Categoria> listAll() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            categoriaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return categoriaDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Categoria caricaSingoloElemento(Long id) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            categoriaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return categoriaDAO.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiorna(Categoria categoriaInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            categoriaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            categoriaDAO.update(categoriaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            categoriaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            categoriaDAO.insert(categoriaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void rimuovi(Categoria categoriaInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        ArticoloDAO articoloDAO = new ArticoloDAOImpl();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            articoloDAO.setEntityManager(entityManager);

            List<Articolo> articoliInOrdine = articoloDAO.findArticoliConCategoria(categoriaInstance);

            if(!articoliInOrdine.isEmpty()){
                for(Articolo articoloItem : articoliInOrdine){
                    articoloItem.getCategorie().remove(categoriaInstance);
                    articoloDAO.update(articoloItem);
                }
            }
            categoriaDAO.setEntityManager(entityManager);
            // eseguo quello che realmente devo fare
            categoriaDAO.delete(categoriaInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Categoria> cercaCategorieArticoliInOrdine(Ordine ordineInput) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            categoriaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return categoriaDAO.findCategorieArticoliByOrdine(ordineInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
}
