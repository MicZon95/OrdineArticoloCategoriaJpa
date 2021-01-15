package it.prova.ordinearticolocategoriajpa.service.categoria;

import it.prova.ordinearticolocategoriajpa.dao.categoria.CategoriaDAO;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> listAll() throws Exception;

    public Categoria caricaSingoloElemento(Long id) throws Exception;

    public void aggiorna(Categoria categoriaInstance) throws Exception;

    public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

    public void rimuovi(Categoria categoriaInstance) throws Exception;

    public List<Categoria> cercaCategorieArticoliInOrdine(Ordine ordineInput) throws Exception;

    // per injection
    public void setCategoriaDAO(CategoriaDAO categoriaDAO);
}
