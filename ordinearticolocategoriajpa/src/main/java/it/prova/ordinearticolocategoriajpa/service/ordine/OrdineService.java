package it.prova.ordinearticolocategoriajpa.service.ordine;

import it.prova.ordinearticolocategoriajpa.dao.ordine.OrdineDAO;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import java.util.List;

public interface OrdineService {

    public List<Ordine> listAll() throws Exception;

    public Ordine caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Ordine ordineInstance) throws Exception;

    public void inserisciNuovo(Ordine ordineInstance) throws Exception;

    public void rimuovi(Ordine ordineInstance) throws Exception;

    public Ordine caricaSingoloOrdineConArticoli(Long id) throws Exception;

    public List<Ordine> caricaOrdiniConCategoria(Categoria categoriaInput) throws Exception;

    // per injection
    public void setOrdineDAO(OrdineDAO ordineDAO);
}
