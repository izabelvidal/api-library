package br.izabel.library.domain.dto;

import br.izabel.library.domain.Membro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class MembroDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer numMembro;

    @NotEmpty(message="Preenchimento Obrigatório!")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres!")
    private String nome;
    private Integer idade;

    public MembroDto(){}

    public MembroDto(Membro membro){
        this.numMembro = membro.getNumMembro();
        this.nome = membro.getNome();
        this.idade = membro.getIdade();
    }

    public Integer getNumMembro() {
        return numMembro;
    }

    public void setNumMembro(Integer numMembro) {
        this.numMembro = numMembro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
