package it.prova.ordinearticolocategoriajpa.dao.ordine;

import it.prova.ordinearticolocategoriajpa.dao.IBaseDAO;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;

import java.util.List;

public interface OrdineDAO extends IBaseDAO<Ordine> {

    public Ordine getEagerArticoli(Long id) throws Exception;

    public List<Ordine> findOrdiniByCategoria(Categoria categoriaInput) throws Exception;


}
