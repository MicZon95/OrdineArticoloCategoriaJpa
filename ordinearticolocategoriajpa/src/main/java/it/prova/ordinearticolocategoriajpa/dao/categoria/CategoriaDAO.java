package it.prova.ordinearticolocategoriajpa.dao.categoria;

import it.prova.ordinearticolocategoriajpa.dao.IBaseDAO;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import java.util.List;

public interface CategoriaDAO extends IBaseDAO<Categoria> {

    public List<Categoria> findCategorieArticoliByOrdine(Ordine ordineInput) throws Exception;
}
