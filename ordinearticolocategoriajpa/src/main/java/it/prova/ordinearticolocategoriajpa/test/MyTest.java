package it.prova.ordinearticolocategoriajpa.test;

import it.prova.ordinearticolocategoriajpa.dao.EntityManagerUtil;
import it.prova.ordinearticolocategoriajpa.model.Articolo;
import it.prova.ordinearticolocategoriajpa.model.Categoria;
import it.prova.ordinearticolocategoriajpa.model.Ordine;
import it.prova.ordinearticolocategoriajpa.service.MyServiceFactory;
import it.prova.ordinearticolocategoriajpa.service.articolo.ArticoloService;
import it.prova.ordinearticolocategoriajpa.service.categoria.CategoriaService;
import it.prova.ordinearticolocategoriajpa.service.ordine.OrdineService;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {

        ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
        CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
        OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

        try {
            // INSERIMENTO ORDINE
            /*System.out.println("Inserimento nuovo ordine");
            Ordine ordineInstance = new Ordine("nome destinatario 1", "indirizzo spedizione 1");
            ordineServiceInstance.inserisciNuovo(ordineInstance);
            if(ordineServiceInstance.caricaSingoloElemento(ordineInstance.getId()) != null)
				System.out.println("Inserimento ordine cd...OK: "+ordineInstance);*/

            // INSERIMENTO ARTICOLO
            /*System.out.println("Inserimento nuovo articolo");
            Articolo articoloInstance = new Articolo("descrizione 2", 2);
            articoloServiceInstance.inserisciNuovo(articoloInstance);
            if(articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId()) != null)
                System.out.println("Inserimento articolo cd...OK: "+articoloInstance);*/

            // INSERIMENTO CATEGORIA
            /*System.out.println("Inserimento nuova categoria");
            Categoria categoriaInstance = new Categoria("descrizione 1");
            categoriaServiceInstance.inserisciNuovo(categoriaInstance);
            if(categoriaServiceInstance.caricaSingoloElemento(categoriaInstance.getId()) != null)
                System.out.println("Inserimento categoria cd...OK: "+categoriaInstance);*/

            // AGGIORNAMENTO ORDINE
            /*System.out.println("Modifica ordine");
            Ordine ordineDaAggiornare = ordineServiceInstance.caricaSingoloElemento(1L);
            if (ordineDaAggiornare != null) {
                ordineDaAggiornare.setNomeDestinatario("modificato");
                ordineServiceInstance.aggiorna(ordineDaAggiornare);
                System.out.println("ordine modificato");
            } else {
                System.out.println("ordine non presente");
            }*/

            // AGGIORNAMENTO ARTICOLO
            /*System.out.println("Modifica articolo");
            Articolo articoloDaAggiornare = articoloServiceInstance.caricaSingoloElemento(1L);
            if (articoloDaAggiornare != null) {
                articoloDaAggiornare.setDescrizione("modificato");
                articoloServiceInstance.aggiorna(articoloDaAggiornare);
                System.out.println("articolo modificato");
            } else {
                System.out.println("articolo non presente");
            }*/

            // AGGIORNAMENTO CATEGORIA
            /*System.out.println("Modifica categoria");
            Categoria categoriaDaAggiornare = categoriaServiceInstance.caricaSingoloElemento(1L);
            if (categoriaDaAggiornare != null) {
                categoriaDaAggiornare.setDescrizione("modificato");
                categoriaServiceInstance.aggiorna(categoriaDaAggiornare);
                System.out.println("categoria modificato");
            } else {
                System.out.println("categoria non presente");
            }*/

            // LIST ORDINI
            System.out.println("Elenca ordini: ");
            for (Ordine ordineItem : ordineServiceInstance.listAll()) {
                System.out.println(ordineItem);
            }
            // LIST ARTICOLI
            System.out.println("Elenca articoli: ");
            for (Articolo articoloItem : articoloServiceInstance.listAll()) {
                System.out.println(articoloItem);
            }
            // LIST CATEGORIA
            System.out.println("Elenca categorie: ");
            for (Categoria categoriaItem : categoriaServiceInstance.listAll()) {
                System.out.println(categoriaItem);
            }

            // AGGIUNGERE ARTICOLO IN UN ORDINE
            /*Articolo articolo = articoloServiceInstance.caricaSingoloElemento(1L);
            articolo.setOrdine(ordineServiceInstance.caricaSingoloElemento(1L));
            articoloServiceInstance.aggiorna(articolo);*/

            // CARICAMENTO EAGER DELL'ORDINE
            /*Ordine ordine = ordineServiceInstance.caricaSingoloOrdineConArticoli(1L);
            System.out
            		.println("Stampo gli articoli dell'ordine appena ricaricato:" + ordine.getArticoli());*/

            // RIMOZIONE ORDINE
            /*System.out.println("Rimozione ordine");
            Ordine ordine = ordineServiceInstance.caricaSingoloOrdineConArticoli(7L);
            if(ordine != null){
                ordineServiceInstance.rimuovi(ordine);
                ordine = ordineServiceInstance.caricaSingoloOrdineConArticoli(7L);
                if (ordine == null)
                    System.out.println("Cancellazione ok");
                else
                    System.out.println("Cancellazione fallita!!!");
            } else {
                System.out.println("Ordine non trovato");
            }*/

            // RIMOZIONE ARTICOLO
            /*System.out.println("Rimozione articolo");
            Articolo articolo = articoloServiceInstance.caricaSingoloElemento(5L);
            if(articolo != null){
                articoloServiceInstance.rimuovi(articolo);
                articolo = articoloServiceInstance.caricaSingoloElemento(5L);
                if (articolo == null)
                    System.out.println("Cancellazione ok");
                else
                    System.out.println("Cancellazione fallita!!!");
            } else {
                System.out.println("articolo non trovato");
            }*/

            // RIMOZIONE CATEGORIA
           /* System.out.println("Rimozione categoria");
            Categoria categoria = categoriaServiceInstance.caricaSingoloElemento(2L);
            if(categoria != null){
                categoriaServiceInstance.rimuovi(categoria);
                categoria = categoriaServiceInstance.caricaSingoloElemento(2L);
                if (categoria == null)
                    System.out.println("Cancellazione ok");
                else
                    System.out.println("Cancellazione fallita!!!");
            } else {
                System.out.println("Categoria non trovato");
            }*/

            //COLLEGHIAMO CATEGORIA AD ARTICOLO
            /*Articolo articolo = articoloServiceInstance.caricaSingoloElemento(1L);
			Categoria categoria = categoriaServiceInstance.caricaSingoloElemento(1L);
			if(articolo != null) {
				articoloServiceInstance.aggiungiArticolo(articolo, categoria);
			}*/

            //CREAZIONE ARTICOLO E CREAZIONE CATEGORIA  IN UN SOLO COLPO
            /*Articolo articoloInstance = new Articolo("descrizione 7", 7);
            Categoria categoriaInstance = new Categoria("descrizione 7");
            articoloServiceInstance.creaECollegaArticoloECategoria(articoloInstance, categoriaInstance);*/

            // CARICA TUTTI GLI ORDINI DATA UNA CATEGORIA
            /*System.out.println("Carica tutti gli ordini data una categoria");
            List<Ordine> ordineList = ordineServiceInstance.caricaOrdiniConCategoria(categoriaServiceInstance.caricaSingoloElemento(3L));
            for (Ordine ordineItem : ordineList) {
                System.out.println(ordineItem);
            }*/

            // CARICA LA LISTA DELLE CATEGORIE DEGLI ARTICOLI IN UN ORDINE
            /*System.out.println("Carica la lista delle categorie degli articoli in un ordine");
            List<Categoria> categorieList = categoriaServiceInstance.cercaCategorieArticoliInOrdine(ordineServiceInstance.caricaSingoloElemento(9L));
            for (Categoria categoria : categorieList) {
                System.out.println(categoria);
            }*/

            // SOMMA PREZZI ARTICOLI DI UNA CATEGORIA
           /* System.out.println("Somma prezzi artricoli di una categoria: "+
                    articoloServiceInstance.sommaPrezziArticoliDellaCategoria(categoriaServiceInstance.caricaSingoloElemento(1L)));*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
            // main
            EntityManagerUtil.shutdown();
        }
    }
}
