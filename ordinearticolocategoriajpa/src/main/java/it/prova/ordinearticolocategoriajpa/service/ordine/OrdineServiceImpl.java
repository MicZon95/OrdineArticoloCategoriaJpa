package it.prova.ordinearticolocategoriajpa.service.ordine;

import it.prova.ordinearticolocategoriajpa.dao.EntityManagerUtil;
import it.prova.ordinearticolocategoriajpa.dao.ordine.OrdineDAO;
import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;
import it.prova.ordinearticolocategoriajpa.service.MyServiceFactory;
import it.prova.ordinearticolocategoriajpa.service.articolo.ArticoloService;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdineServiceImpl implements OrdineService{

    private OrdineDAO ordineDAO;

    private ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();

    @Override
    public void setOrdineDAO(OrdineDAO ordineDAO) {
        this.ordineDAO= ordineDAO;
    }

    @Override
    public List<Ordine> listAll() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return ordineDAO.list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Ordine caricaSingoloElemento(Long id) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return ordineDAO.get(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void aggiorna(Ordine ordineInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            ordineDAO.update(ordineInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void inserisciNuovo(Ordine ordineInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            ordineDAO.insert(ordineInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void rimuovi(Ordine ordineInstance) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            List<Articolo> articoliInOrdine = articoloServiceInstance.cercaArticoloConOrdine(ordineInstance);

            if(!articoliInOrdine.isEmpty()){
                for(Articolo articoloItem : articoliInOrdine){
                    articoloItem.setOrdine(null);
                    articoloServiceInstance.aggiorna(articoloItem);
                }
            }

            // eseguo quello che realmente devo fare
            ordineDAO.delete(ordineInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Ordine caricaSingoloOrdineConArticoli(Long id) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return ordineDAO.getEagerArticoli(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Ordine> caricaOrdiniConCategoria(Categoria categoriaInput) throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            ordineDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return ordineDAO.findOrdiniByCategoria(categoriaInput);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            entityManager.close();
        }
    }


}
