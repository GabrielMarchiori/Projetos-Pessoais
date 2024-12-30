package aplicacao;

import estrutura.Funcionarios;
import modelos.Excecoes;
import modelos.enums.Cargos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Funcionarios> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionarios("00000000000", "administrador", 'M', Cargos.ADMINISTRADOR, new Date(), 00.00));

        validador(funcionarios);
        if (validador(funcionarios) == true) {

        }





        System.out.println();
        System.out.println("Ola, " + login + " bem vindo, o que deseja realizar no momento?");
        System.out.println("1. Realizar o cadastro de funcionario");
        System.out.println("2. Realizar o cadastro de cliente");
        System.out.println("3. Realizar o cadastro de livro");
        System.out.println("4. Realizar o cadastro de aluguel");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
        }


        sc.close();
    }
    public static boolean validador(List<Funcionarios> funcionarios){
        Scanner sc = new Scanner(System.in);
        boolean autenticado = false;
        do {
            try {
                System.out.printf("Digite o nome do funcionario que esta utilizando o sistema: ");
                String login = sc.nextLine();
                for (Funcionarios funcionario : funcionarios) {
                    if (funcionario.getNome().equals(login)) {
                        autenticado = true;
                        break;
                    }
                }
                if (autenticado == false) {
                    throw new Excecoes("Usuario nao existe");
                }
            }catch (Excecoes e){
                System.out.println("Erro ao autenticar: " + e.getMessage());
                return false;
            }
        }while (autenticado == false);
        return true;
    }
}
