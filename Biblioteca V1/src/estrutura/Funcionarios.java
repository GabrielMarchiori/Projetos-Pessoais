package estrutura;

import modelos.enums.Cargos;

import java.util.Date;

public class Funcionarios extends Pessoa {
    private double salario;
    private Date registro;
    private Cargos cargo;

    public Funcionarios(String cpf, String nome, char sexo, Cargos cargo, Date registro, double salario) {
        super(cpf, nome, sexo);
        this.cargo = cargo;
        this.registro = registro;
        this.salario = salario;
    }

    public Funcionarios(String cpf, String nome, char sexo, String telefone, Cargos cargo, Date registro, double salario) {
        super(cpf, nome, sexo, telefone);
        this.cargo = cargo;
        this.registro = registro;
        this.salario = salario;
    }
}
