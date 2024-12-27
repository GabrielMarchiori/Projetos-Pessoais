package estrutura;

import java.util.Date;

public class Clientes extends Pessoa {
    private Date dataNascimento;
    private Date dataCadastro;

    private Funcionarios funcionarioRealizouCadastro;

    public Clientes(String cpf, String nome, char sexo, String telefone, Date dataCadastro, Date dataNascimento, Funcionarios funcionarioRealizouCadastro) {
        super(cpf, nome, sexo, telefone);
        this.dataCadastro = dataCadastro;
        this.dataNascimento = dataNascimento;
        this.funcionarioRealizouCadastro = funcionarioRealizouCadastro;
    }

    public Clientes(String cpf, String nome, char sexo, Date dataCadastro, Date dataNascimento, Funcionarios funcionarioRealizouCadastro) {
        super(cpf, nome, sexo);
        this.dataCadastro = dataCadastro;
        this.dataNascimento = dataNascimento;
        this.funcionarioRealizouCadastro = funcionarioRealizouCadastro;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionarios getFuncionarioRealizouCadastro() {
        return funcionarioRealizouCadastro;
    }
}
