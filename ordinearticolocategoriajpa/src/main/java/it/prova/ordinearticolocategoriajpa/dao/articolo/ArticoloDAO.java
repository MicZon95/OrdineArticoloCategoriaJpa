package it.prova.ordinearticolocategoriajpa.dao.articolo;

import it.prova.ordinearticolocategoriajpa.dao.IBaseDAO;
import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import java.util.List;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

    public List<Articolo> findArticoliInOrdine(Ordine ordineInput) throws Exception;

    public List<Articolo> findArticoliConCategoria(Categoria categoriaInput) throws Exception;

    public Integer countPrezziArticoliByCategoria(Categoria categoriaInput) throws Exception;
}
