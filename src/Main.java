// Autor: João Vitor Maciel Vianna

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        CompareByCode compareByCode = new CompareByCode();
        CompareByName compareByName = new CompareByName();

        //Inicialização Arvore
        FReader reader = new FReader();

        Menu.InicializaArvore();

//        long startTime = System.currentTimeMillis();
        Arvore<Aluno> SByCode = reader.reader("alunos", compareByCode);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + " Matricula");

//        startTime = System.currentTimeMillis();
        Arvore<Aluno> SByName = reader.reader("alunos", compareByName);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + " Nome");


        //Inicializa Ações
        Scanner sc = new Scanner(System.in);

        //Inicialização do Menu
        Menu.textoInicial();
        Menu.acoes();
        int userAnswMenu = sc.nextInt();

        while (userAnswMenu != 4) {

            //ADICIONAR ALUNO
            if (userAnswMenu == 1) {
                Menu.contAcoes(userAnswMenu);
                System.out.println("Digite a matrícula do aluno: ");
                int matricula = sc.nextInt();
                System.out.println("Digite o nome do aluno: ");
                sc.nextLine();
                String nomeAluno = sc.nextLine();
                System.out.println("Digite a nota do aluno: ");
                Double grade = sc.nextDouble();

                Aluno aluno = new Aluno(matricula, nomeAluno, grade);

                SByCode.add(aluno);
                SByName.add(aluno);
            }

            // SELECIONAR ARVORE MATRICULA
            else if (userAnswMenu == 2) {

                Menu.selecaoMatricula();

                int userAnsw = sc.nextInt();

                //BUSCAR
                if (userAnsw == 1) {
                    Menu.buscarMatricula();
                    int matricula = sc.nextInt();
                    System.out.println("\n\n");
                    System.out.println("=== Buscando Aluno ===");
                    Aluno aluno = SByCode.pesquisarElementoIterativo(new Aluno(matricula));
                    if (aluno != null) {
                        System.out.println(aluno.toString());
                    }
                    System.out.println("\n\n");
                }

                //REMOÇÃO
                else if (userAnsw == 2) {
                    System.out.println("Digite a matrícula do aluno a ser removido: ");
                    int code = sc.nextInt();
                    Aluno matAluno = new Aluno(code);

                    Aluno aluno = SByCode.pesquisarElementoIterativo(matAluno);

                    System.out.println("==*Removendo Aluno*==");
                    if (aluno != null) {
                        Aluno alunoRemovido = SByCode.initRemove(aluno);
                        SByName.initRemove(new Aluno(alunoRemovido.getName()));
                        System.out.println("---> Aluno Removido ✔");
                    } else {
                        System.out.println("---> Não foi possível realizar a remoção! ✘");
                    }
                    System.out.println("\n\n");
                }

                //ESTATÍSTICAS
                else if (userAnsw == 3) {
                    System.out.println("===== ESTATÍSTICAS ÁRVORE MATRÍCULA =====");
                    System.out.println("O aluno de maior matrícula: " + SByCode.getHighElement(SByCode.getRoot()).toString());
                    System.out.println("O aluno de menor matrícula: " + SByCode.lowElement(SByCode.getRoot()).toString());
                    System.out.println("A quantidade de elementos da árvore é igual a " + SByCode.quantElem(SByCode.getRoot()));
                    System.out.println("A altura da árvore é igual a " + SByCode.getHeight(SByCode.getRoot())); // Rever Método de Altura
                    System.out.println("\n\n");

                }

                //CAMINHAR
                else if (userAnsw == 4) {
                    Menu.displaySearchCode();
                    userAnsw = sc.nextInt();
                    if (userAnsw == 1) {
                        SByCode.initLevelWalk();
                    } else if (userAnsw == 2) {
                        SByCode.StraightWalk();
                    }
                }
            }

            //SELECIONAR ARVORE NOME
            else if (userAnswMenu == 3) {

                Menu.selecaoNome();

                int userAnsw = sc.nextInt();
                sc.nextLine();

                // PESQUISAR
                if (userAnsw == 1) {
                    Menu.buscarNome();
                    String nome = sc.nextLine();
                    System.out.println("\n\n");
                    System.out.println("=== Buscando Aluno ===");
                    Aluno aluno = SByCode.pesquisarElementoIterativo(new Aluno(nome));
                    if (aluno != null) {
                        System.out.println(aluno.toString());
                    }
                    System.out.println("\n\n");
                }

                // REMOÇÃO
                else if (userAnsw == 2) {
                    System.out.println("Digite o nome do aluno a ser removido: ");
                    String name = sc.nextLine();
                    System.out.println("==Pesquisando Aluno==");
                    Aluno aluno = SByName.pesquisarElementoIterativo(new Aluno(name));
                    //Verificação De Aluno para poupar processamento
                    System.out.println("==*Removendo Aluno*==");
                    if (aluno != null) {
                        Aluno alunoRemovido = SByName.initRemove(aluno);
                        SByCode.initRemove(new Aluno(alunoRemovido.getCode()));
                        System.out.println("---> Aluno Removido ✔");
                    } else {
                        System.out.println("---> Não foi possível realizar a remoção! ✘");
                    }
                    System.out.println("\n\n");
                }

                // ESTATÍSTICAS
                else if (userAnsw == 3) {
                    System.out.println("===== ESTATÍSTICAS ÁRVORE NOME =====");
                    System.out.println("O aluno de maior 'NOME': " + SByName.getHighElement(SByName.getRoot()).toString());
                    System.out.println("O aluno de menor 'NOME': " + SByName.lowElement(SByName.getRoot()).toString());
                    System.out.println("A quantidade de elementos da árvore é igual a " + SByName.quantElem(SByName.getRoot()));
                    System.out.println("A altura da árvore é igual a " + SByName.getHeight(SByName.getRoot())); // Rever Método de Altura
                    System.out.println("\n\n");
                }

                // CAMINHAR
                else if (userAnsw == 4) {
                    Menu.displaySearchCode();
                    userAnsw = sc.nextInt();
                    if (userAnsw == 1) {
                        SByName.initLevelWalk();
                    } else if (userAnsw == 2) {
                        SByName.StraightWalk();
                    }
                }
            } else {
                System.out.println("Comando não encontrado");
            }
            Menu.textoInicial();
            Menu.acoes();
            userAnswMenu = sc.nextInt();
        }
        SByCode.initSave("alunos.txt");
        System.exit(0);
    }
}