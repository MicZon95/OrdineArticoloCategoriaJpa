package it.prova.ordinearticolocategoriajpa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "descrizione")
    private String descrizione;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
    private Set<Articolo> articoli = new HashSet<>();

    public Categoria() {}

    public Categoria(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Set<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(Set<Articolo> articoli) {
        this.articoli = articoli;
    }

    @Override
    public String toString() {
        return "Categoria: [id = " +id+ ", descrizione = "+descrizione+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
