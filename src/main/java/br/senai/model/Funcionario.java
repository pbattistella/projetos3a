package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    @Size(max = 100)
    @NotNull
    private String nome;
    @Size(max = 15)
    private String cpf;
    @Size(max = 100)
    private String email;
    @Size(max = 30)
    private String telefone;

    @ManyToMany(mappedBy = "funcionarios")
    private List<Projeto> projetos;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
