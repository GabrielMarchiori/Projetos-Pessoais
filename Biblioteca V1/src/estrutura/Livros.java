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

    private Funcionarios funcionarioRealizouCriacao;

    public Livros(String autor, String editora, Funcionarios funcionarioRealizouCriacao, Genero genero, Materiais materiais, String titulo) {
        this.autor = autor;
        this.editora = editora;
        this.funcionarioRealizouCriacao = funcionarioRealizouCriacao;
        this.genero = genero;
        this.materiais = materiais;
        this.titulo = titulo;

        this.status = Status.Disponivel;
    }


    public String getAutor() {
        return autor;
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

    public void alterarStatus(Status novoStatus) {
        this.status = novoStatus;
    }

    public String StatusLivro() {
        Livros livro = this;
        return livro.status.toString();
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo()
                + "\nAutor: " + getAutor()
                + "\nEditora: " + getEditora()
                + "\nGenero: " + getGenero();
    }
}
