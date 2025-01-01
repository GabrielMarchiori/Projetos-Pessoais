package aplicacao;

import estrutura.Aluguel;
import estrutura.Clientes;
import estrutura.Funcionarios;
import estrutura.Livros;
import modelos.Excecoes;
import modelos.enums.Cargos;
import modelos.enums.Genero;
import modelos.enums.Materiais;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Funcionarios> funcionarios = new ArrayList<>();
        List<Aluguel> aluguels = new ArrayList<>();
        List<Clientes> clientes = new ArrayList<>();
        List<Livros> livros = new ArrayList<>();
        funcionarios.add(new Funcionarios("00000000000", "administrador", 'M', Cargos.ADMINISTRADOR, new Date(), 00.00));

        String login = null;
        boolean autenticado = false;
        int menu = 1;

        do {
            while (!autenticado) {
                try {
                    System.out.printf("Digite o nome do funcionario que esta utilizando o sistema: ");
                    login = sc.nextLine();
                    autenticado = validador(funcionarios, login);
                    if (autenticado == false) {
                        throw new Excecoes("Usuario nao existe");
                    }
                } catch (Excecoes e) {
                    System.out.println("Erro ao autenticar: " + e.getMessage());
                }
            }

            System.out.println();
            System.out.println("Ola, " + login + " bem vindo, o que deseja realizar no momento?");

            int opcao = 0;

            System.out.println("1. Realizar o cadastro de funcionario");
            System.out.println("2. Realizar o cadastro de cliente");
            System.out.println("3. Realizar o cadastro de livro");
            System.out.println("4. Realizar o cadastro de aluguel");
            System.out.println("6. Verificar um aluguel");
            System.out.println("7. Verificar o status de um livro");
            System.out.println("8. Estimativa de uma devolucao");
            System.out.println("9. Alterar funcionario");
            System.out.println("0. Sair");

            int escolha = sc.nextInt();
            int funcionarioLogado = 0;

            switch (escolha) {
                case 1:
                    cadastrarFuncionario(funcionarios);
                    break;
                case 2:
                    for (Funcionarios func : funcionarios) {
                        if (func.getNome() == login) {
                            funcionarioLogado = funcionarios.indexOf(func);
                        }
                    }
                    cadastrarCliente(clientes, funcionarios, funcionarios.get(funcionarioLogado).getNome());
                    break;
                case 3:
                    for (Funcionarios func : funcionarios) {
                        if (func.getNome() == login) {
                            funcionarioLogado = funcionarios.indexOf(func);
                        }
                    }
                    cadastrarLivro(livros, funcionarios, funcionarios.get(funcionarioLogado).getNome());
                    break;
                case 4:
                    for (Funcionarios func : funcionarios) {
                        if (func.getNome() == login) {
                            funcionarioLogado = funcionarios.indexOf(func);
                        }
                    }
                    cadastrarAluguel(livros, funcionarios, clientes, funcionarios.get(funcionarioLogado).getNome(), aluguels);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    autenticado = false;
                    sc.nextLine();
                    break;
                case 0:
                    menu = 0;
                    break;
                default:
                    break;

            }


        } while (menu != 0);
        sc.close();

    }

    public static boolean validador(List<Funcionarios> funcionarios, String login) {
        boolean autenticado = false;
        for (Funcionarios funcionario : funcionarios) {
            if (funcionario.getNome().equals(login)) {
                autenticado = true;
            }
        }
        return autenticado;
    }

    public static void cadastrarFuncionario(List<Funcionarios> funcionarios) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Para realizar o cadastro de um funcionario e necessario informar os seguintes dados");
        System.out.printf("Nome: ");
        String nome = sc.nextLine();
        System.out.printf("CPF do funcionario: ");
        String cpf = sc.nextLine();
        System.out.printf("Sexo do funcionario (M/F): ");
        Character sexo = sc.next().charAt(0);
        System.out.printf("Salario: ");
        Double salario = sc.nextDouble();
        sc.nextLine();
        System.out.printf("Cargo:\n" +
                "1. bibliotecario\n" +
                "2. chefe_bibliotecario\n" +
                "3. auxiliar_bibliotecario\n" +
                "4. atendimento_usuario\n");
        int opcao = sc.nextInt();
        Cargos cargo = null;
        if (opcao == 1) {
            cargo = Cargos.bibliotecario;
        }
        if (opcao == 2) {
            cargo = Cargos.chefe_bibliotecario;
        }
        if (opcao == 3) {
            cargo = Cargos.auxiliar_bibliotecario;
        }
        if (opcao == 4) {
            cargo = Cargos.atendimento_usuario;
        }

        funcionarios.add(new Funcionarios(cpf, nome, sexo, cargo, new Date(), salario));
        System.out.println("Funcionarios cadastrados com sucesso!");
        int ultimo = funcionarios.size() - 1;
        System.out.println(funcionarios.get(ultimo).toString());

        System.out.println("Retornando para o menu");
    }

    public static void cadastrarCliente(List<Clientes> clientes, List<Funcionarios> funcionarios, String funcionario) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Para realizar o cadastro de um cliente e necessario informar os seguintes dados");
            System.out.printf("Nome: ");
            String nome = sc.nextLine();
            System.out.printf("CPF do cliente: ");
            String cpf = sc.nextLine();
            System.out.printf("Sexo do cliente (M/F): ");
            Character sexo = sc.next().charAt(0);
            System.out.printf("Telefone: ");
            String telefone = sc.nextLine();


            clientes.add(new Clientes(cpf, nome, sexo, telefone, new Date(), new Date(), funcionario, funcionarios));
            System.out.println("Cliente cadastrado com sucesso!");
            int ultimo = clientes.size() - 1;
            System.out.println(clientes.get(ultimo).toString());

        } catch (Excecoes e) {
            System.out.println("Erro ao criar usuario: " + e.getMessage());
        } finally {
            System.out.println("Retornando para o menu");
        }
    }

    public static void cadastrarLivro(List<Livros> livros, List<Funcionarios> funcionarios, String funcionario) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Para realizar o cadastro de um livro e necessario informar os seguintes dados");

        System.out.printf("Titulo: ");
        String titulo = sc.nextLine();
        System.out.printf("Autor: ");
        String autor = sc.nextLine();
        System.out.printf("Editora: ");
        String editora = sc.nextLine();
        System.out.printf("Genero:\n" +
                "1. Romance\n" +
                "2. Ficcao Cientifica\n" +
                "3. Fantasia\n" +
                "4. Terror\n" +
                "5. Policial\n" +
                "6. Historico\n" +
                "7. Aventura\n" +
                "8. Poesia\n" +
                "9. Autobiografia\n" +
                "10.Didatico\n" +
                "11.Biografia\n");
        int opcao = sc.nextInt();
        Genero genero = null;
        try {
            switch (opcao) {
                case 1:
                    genero = Genero.Romance;
                    break;
                case 2:
                    genero = Genero.Ficcao_Cientifica;
                    break;
                case 3:
                    genero = Genero.Fantasia;
                    break;
                case 4:
                    genero = Genero.Terror;
                    break;
                case 5:
                    genero = Genero.Policial;
                    break;
                case 6:
                    genero = Genero.Historico;
                    break;
                case 7:
                    genero = Genero.Aventura;
                    break;
                case 8:
                    genero = Genero.Poesia;
                    break;
                case 9:
                    genero = Genero.Autobiografia;
                    break;
                case 10:
                    genero = Genero.Didatico;
                    break;
                case 11:
                    genero = Genero.Biografia;
                default:
                    throw new Excecoes("Genero opcao: " + opcao + " nao existe");
            }
            System.out.printf("Tipo de material:\n " +
                    "1. Livros\n" +
                    "2. Revistas\n" +
                    "3. Quadrinhos\n" +
                    "4. Mangas\n");
            opcao = sc.nextInt();
            Materiais materiais = null;

            switch (opcao) {
                case 1:
                    materiais = Materiais.Livros;
                    break;
                    case 2:
                        materiais = Materiais.Revistas;
                        break;
                        case 3:
                            materiais = Materiais.Quadrinhos;
                            break;
                            case 4:
                                materiais = Materiais.Mangas;
                                break;
                                default:
                                    throw new Excecoes("Material opcao: " + opcao + " nao existe");
            }

            livros.add(new Livros(autor, editora, funcionario, genero, funcionarios, materiais, titulo));

            System.out.println("Livro cadastrado com sucesso!");
            int ultimo = livros.size() - 1;
            System.out.println(livros.get(ultimo).toString());
        }catch (Excecoes e) {
            System.out.println("Erro ao criar usuario: " + e.getMessage());
        }finally {
            System.out.println("Retornando para o menu");
        }

    }

    public static void cadastrarAluguel(List<Livros> livros, List<Funcionarios> funcionarios, List<Clientes> clientes, String funcionario, List<Aluguel> aluguels) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Para realizar o cadastro de um aluguel e necessario informar os seguintes dados");
            System.out.printf("Cliente (escolha o numero do seu cliente): ");
            Clientes.consultarClientes(clientes);
            int opcaoCliente = sc.nextInt();
            Clientes clienteAluguel = clientes.get(opcaoCliente);
            System.out.printf("Livro(s) (escolha o numero do(s) livro(s))" +
                    "\n(serao aceitos apenas os 3 primeiros numeros, pois é limite de livros que podem ser alugados):\n");
            Livros.consultarLivros(livros);
            System.out.println("Separe os numeros por virgula 'v'");
            sc.nextLine();
            String opcaoLivros = sc.nextLine();

            int tamanhoMaximo = 3;
            String[] livrosParaAlugarProvisorio = opcaoLivros.split(",");
            int[] livrosParaAlugar = new int[Math.min(livrosParaAlugarProvisorio.length, tamanhoMaximo)];

            for (int i = 0; i < livrosParaAlugar.length; i++) {
                livrosParaAlugar[i] = Integer.parseInt(livrosParaAlugarProvisorio[i].trim());
            }

            aluguels.add(new Aluguel(clienteAluguel, LocalDate.now(), funcionario, livros, livrosParaAlugar, funcionarios));
        }catch (Excecoes e) {
            if (e.getMessage() == "Funcionario nao tem permisao para regristrar alugeis"){
                System.out.println("Erro ao criar alguel: " + e.getMessage());
            }else {
                System.out.println("Erro ao alugar livro: " + e.getMessage());
            }

        }



    }

}
