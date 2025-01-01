package estrutura;

import modelos.Excecoes;
import modelos.enums.Cargos;

import java.util.Date;
import java.util.List;

public class Clientes extends Pessoa {
    private Date dataNascimento;
    private Date dataCadastro;

    private String funcionarioRealizouCadastro;

    public Clientes(String cpf, String nome, char sexo, String telefone, Date dataCadastro, Date dataNascimento, String funcionarioRealizouCadastro, List<Funcionarios> funcionarios) {
        super(cpf, nome, sexo, telefone);
        for (Funcionarios func : funcionarios){
            if (func.getCargo() != Cargos.auxiliar_bibliotecario){
                this.dataCadastro = dataCadastro;
                this.dataNascimento = dataNascimento;
                this.funcionarioRealizouCadastro = funcionarioRealizouCadastro;
                break;
            }
            else{
                throw new Excecoes("Funcionario nao tem permisao para cadastrar clientes");
            }
        }
    }



    public Clientes(String cpf, String nome, char sexo, Date dataCadastro, Date dataNascimento, String funcionarioRealizouCadastro, List<Funcionarios> funcionarios) {
        super(cpf, nome, sexo);
        for (Funcionarios funcionarios1 : funcionarios){
            if (funcionarios1.getNome().equals(funcionarioRealizouCadastro)){
                this.dataCadastro = dataCadastro;
                this.dataNascimento = dataNascimento;
                this.funcionarioRealizouCadastro = funcionarioRealizouCadastro;
            }
            else{
                throw new Excecoes("Funcionario nao tem permisao para cadastrar clientes");
            }
        }


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

    public String getFuncionarioRealizouCadastro() {
        return funcionarioRealizouCadastro;
    }

    public static String consultarClientes(List<Clientes> clientes) {
        int posicao = 0;
        for (Clientes client : clientes) {
            System.out.println(client.getNome() + " numero: " + posicao);
            posicao++;
        }
        return "";
    }

    @Override
    public String toString() {
        return "nome: " + getNome() +
                String.format("\nCPF: ") + getCpf() +
                String.format("\nFuncionario que realizou o cadastro: ") + getFuncionarioRealizouCadastro();
    }
}
