// Autor: João Vitor Maciel Vianna

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String NOME_ARQUIVO = "alunos";

        CompareByCode compareByCode = new CompareByCode();
        CompareByName compareByName = new CompareByName();

        //Inicialização Arvore
        FReader reader = new FReader();

        Menu.InicializaArvore();

//        long startTime = System.currentTimeMillis();
        Arvore<Aluno> SByCode = reader.reader(NOME_ARQUIVO, compareByCode);
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + " Matricula");
        ArvoreAVL<Aluno> SByCodeAVL = reader.readerAVL(NOME_ARQUIVO, compareByCode);

//        startTime = System.currentTimeMillis();
        Arvore<Aluno> SByName = reader.reader(NOME_ARQUIVO, compareByName);
//        endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime + " Nome");
        ArvoreAVL<Aluno> SByNameAVL = reader.readerAVL(NOME_ARQUIVO, compareByName);



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

                SByCodeAVL.adicionarElemento(aluno);
                SByCode.add(aluno);
                SByNameAVL.adicionarElemento(aluno);
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
                    System.out.println("\n== Comparações Árvore Código ==");
                    Aluno aluno = SByCode.pesquisarElementoIterativo(new Aluno(matricula));
                    System.out.println("\n== Comparações Árvore-AVL Código ==");
                    Aluno alunoAVL = SByCodeAVL.pesquisarElementoIterativo(new Aluno(matricula));
                    if (aluno != null && alunoAVL != null) {
                        System.out.println("\n=== > Árvore Código < ===");
                        System.out.println(aluno.toString());
                        System.out.println("\n");
                        System.out.println("=== > Árvore-AVL Código < ===");
                        System.out.println(alunoAVL.toString());
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
                        System.out.println("\n=== > Árvore Código < ===");
                        Aluno alunoRemovido = SByCode.removeReal(aluno);
                        System.out.println("---> Aluno Removido ✔");
                        System.out.println("\n");
                        System.out.println("=== > Árvore Nome < ===");
                        SByName.removeReal(new Aluno(alunoRemovido.getName()));
                        System.out.println("---> Aluno Removido ✔");
                        System.out.println("\n");
                        System.out.println("=== > ÁrvoreAVL Código < ===");
                        SByCodeAVL.removeReal(aluno);
                        System.out.println("---> Aluno Removido ✔");
                        System.out.println("\n");
                        System.out.println("=== > ÁrvoreAVL Nome < ===");
                        SByNameAVL.removeReal(new Aluno(alunoRemovido.getName()));
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

                    System.out.println("===== ESTATÍSTICAS ÁRVORE-AVL MATRÍCULA =====");
                    System.out.println("O aluno de maior matrícula: " + SByCodeAVL.getHighElement(SByCodeAVL.getRoot()).toString());
                    System.out.println("O aluno de menor matrícula: " + SByCodeAVL.lowElement(SByCodeAVL.getRoot()).toString());
                    System.out.println("A quantidade de elementos da árvore é igual a " + SByCodeAVL.quantElem(SByCodeAVL.getRoot()));
                    System.out.println("A altura da árvore é igual a " + SByCodeAVL.getHeight(SByCodeAVL.getRoot())); // Rever Método de Altura
                    System.out.println("\n\n");

                }

                //CAMINHAR
                else if (userAnsw == 4) {
                    Menu.displaySearchCode();
                    userAnsw = sc.nextInt();
                    if (userAnsw == 1) {
                        System.out.println("=== Level WALK Arvore Código ===");
                        SByCode.initLevelWalk();
                        System.out.println("\n\n");
                        System.out.println("=== Level WALK ArvoreAVL Código ===");
                        SByCodeAVL.initLevelWalk();
                        System.out.println("\n\n");
                    } else if (userAnsw == 2) {
                        System.out.println("=== Straight WALK Arvore Código ===");
                        SByCode.StraightWalk();
                        System.out.println("\n\n");
                        System.out.println("=== Straight WALK ArvoreAVL Código ===");
                        SByCodeAVL.StraightWalk();
                        System.out.println("\n\n");
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
                    System.out.println("\n== Comparações Árvore Nome ==");
                    Aluno aluno = SByName.pesquisarElementoIterativo(new Aluno(nome));
                    System.out.println("\n== Comparações Árvore-AVL Código ==");
                    Aluno alunoAVL = SByNameAVL.pesquisarElementoIterativo(new Aluno(nome));
                    if (aluno != null && alunoAVL != null) {
                        System.out.println("\n=== > Árvore Nome < ===");
                        System.out.println(aluno.toString());
                        System.out.println("\n");
                        System.out.println("=== > Árvore-AVL Nome < ===");
                        System.out.println(alunoAVL.toString());
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
                        System.out.println("\n=== > Árvore Nome < ===");
                        //Remoção Arvore Nome
                        Aluno alunoRemovido = SByName.removeReal(aluno);

                        System.out.println("---> Aluno Removido ✔");
                        System.out.println("\n");
                        System.out.println("=== > Árvore Código < ===");
                        //Remoção Arvore Código
                        SByCode.removeReal(new Aluno(alunoRemovido.getCode()));

                        System.out.println("---> Aluno Removido ✔");
                        System.out.println("\n");
                        System.out.println("=== > ÁrvoreAVL Nome < ===");
                        //Remoção ArvoreAVL Nome
                        SByNameAVL.removeReal(aluno);

                        System.out.println("---> Aluno Removido ✔");
                        System.out.println("\n");
                        System.out.println("=== > ÁrvoreAVL Código < ===");
                        //Remoção ArvoreAVL Code
                        SByCodeAVL.removeReal(new Aluno(alunoRemovido.getCode()));
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

                    System.out.println("===== ESTATÍSTICAS ÁRVORE-AVL NOME =====");
                    System.out.println("O aluno de maior 'NOME': " + SByNameAVL.getHighElement(SByNameAVL.getRoot()).toString());
                    System.out.println("O aluno de maior 'NOME': " + SByNameAVL.lowElement(SByNameAVL.getRoot()).toString());
                    System.out.println("A quantidade de elementos da árvore é igual a " + SByNameAVL.quantElem(SByNameAVL.getRoot()));
                    System.out.println("A altura da árvore é igual a " + SByNameAVL.getHeight(SByNameAVL.getRoot())); // Rever Método de Altura
                    System.out.println("\n\n");
                }

                //CAMINHAR
                else if (userAnsw == 4) {
                    Menu.displaySearchCode();
                    userAnsw = sc.nextInt();
                    if (userAnsw == 1) {
                        System.out.println("=== Level WALK Arvore Nome ===");
                        SByName.initLevelWalk();
                        System.out.println("\n\n");
                        System.out.println("=== Level WALK ArvoreAVL Nome ===");
                        SByNameAVL.initLevelWalk();
                        System.out.println("\n\n");
                    } else if (userAnsw == 2) {
                        System.out.println("=== Straight WALK Arvore Nome ===");
                        SByName.StraightWalk();
                        System.out.println("\n\n");
                        System.out.println("=== Straight WALK ArvoreAVL Nome ===");
                        SByNameAVL.StraightWalk();
                        System.out.println("\n\n");
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