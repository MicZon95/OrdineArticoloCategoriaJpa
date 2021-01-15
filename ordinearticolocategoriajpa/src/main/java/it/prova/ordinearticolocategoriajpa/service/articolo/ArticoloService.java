package it.prova.ordinearticolocategoriajpa.service.articolo;

import it.prova.ordinearticolocategoriajpa.dao.articolo.ArticoloDAO;
import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import java.util.List;

public interface ArticoloService {

    public List<Articolo> listAll() throws Exception;

    public Articolo caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Articolo articoloInstance) throws Exception;

    public void inserisciNuovo(Articolo articoloInstance) throws Exception;

    public void rimuovi(Articolo articoloInstance) throws Exception;

    public void aggiungiArticolo(Articolo articoloInstance, Categoria categoriaInstance) throws Exception;

    public void creaECollegaArticoloECategoria(Articolo articoloInstance, Categoria categoriaInstance) throws Exception;

    public List<Articolo> cercaArticoloConOrdine(Ordine ordineInput) throws Exception;

    public List<Articolo> cercaArticoloConCategoria(Categoria categoriaInput) throws Exception;

    public Integer sommaPrezziArticoliDellaCategoria(Categoria categoriaInput) throws Exception;

    // per injection
    public void setArticoloDAO(ArticoloDAO articoloDAO);
}
