package br.izabel.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer isbn;
    private String titulo;
    private String autores;
    private String editora;

    @OneToMany(mappedBy="livro", cascade=CascadeType.ALL)
    private List<Emprestado> emprestimos;

    public Livro(Integer isbn, String titulo, String autores, String editora) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return isbn.equals(livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
