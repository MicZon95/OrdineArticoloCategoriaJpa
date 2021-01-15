package it.prova.ordinearticolocategoriajpa.service;

import it.prova.ordinearticolocategoriajpa.dao.MyDAOFactory;
import it.prova.ordinearticolocategoriajpa.service.articolo.ArticoloService;
import it.prova.ordinearticolocategoriajpa.service.articolo.ArticoloServiceImpl;
import it.prova.ordinearticolocategoriajpa.service.categoria.CategoriaService;
import it.prova.ordinearticolocategoriajpa.service.categoria.CategoriaServiceImpl;
import it.prova.ordinearticolocategoriajpa.service.ordine.OrdineService;
import it.prova.ordinearticolocategoriajpa.service.ordine.OrdineServiceImpl;

public class MyServiceFactory {

    private static ArticoloService articoloServiceInstance = null;
    private static CategoriaService categoriaServiceInstance = null;
    private static OrdineService ordineServiceInstance= null;

    public static ArticoloService getArticoloServiceInstance() {
        if(articoloServiceInstance == null){
            articoloServiceInstance = new ArticoloServiceImpl();
        }

        articoloServiceInstance.setArticoloDAO(MyDAOFactory.getArticoloDAOInstance());

        return articoloServiceInstance;
    }

    public static CategoriaService getCategoriaServiceInstance() {
        if(categoriaServiceInstance == null){
            categoriaServiceInstance = new CategoriaServiceImpl();
        }

        categoriaServiceInstance.setCategoriaDAO(MyDAOFactory.getCategoriaDAOInstance());

        return categoriaServiceInstance;
    }

    public static  OrdineService getOrdineServiceInstance() {
        if(ordineServiceInstance == null){
            ordineServiceInstance = new OrdineServiceImpl();
        }

        ordineServiceInstance.setOrdineDAO(MyDAOFactory.getOrdineDAOInstance());

        return ordineServiceInstance;
    }
}
