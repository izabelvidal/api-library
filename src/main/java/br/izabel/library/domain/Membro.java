package br.izabel.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Membro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numMembro;
    private String nome;
    private Integer idade;

    @OneToMany(mappedBy="membro", cascade=CascadeType.ALL)
    private List<Emprestado> emprestimos;

    public Membro(Integer numMembro, String nome, Integer idade){
        this.numMembro = numMembro;
        this.nome = nome;
        this.idade = idade;
    }

    public void setNumMembro(Integer numMembro) {
        this.numMembro = numMembro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getNumMembro() {
        return numMembro;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membro membro = (Membro) o;
        return numMembro.equals(membro.numMembro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numMembro);
    }
}
