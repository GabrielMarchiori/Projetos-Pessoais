package estrutura;

import modelos.enums.Genero;
import modelos.enums.Materiais;
import modelos.enums.Status;

public class Livros {
    private String titulo;
    private String autor;
    private String editora;
    private Genero genero;
    private Materiais materiais;
    private Status status;

    private Clientes clientes;
    private Funcionarios funcionarioRealizouCriacao;

    public String getAutor() {
        return autor;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public String getEditora() {
        return editora;
    }

    public Funcionarios getFuncionarioRealizouCriacao() {
        return funcionarioRealizouCriacao;
    }

    public Genero getGenero() {
        return genero;
    }

    public Materiais getMateriais() {
        return materiais;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }


}
