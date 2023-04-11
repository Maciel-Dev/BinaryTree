// Autor: João Vitor Maciel Vianna

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // Inicialização de Comparadores
        CompareByCode compareByCode = new CompareByCode();
        CompareByName compareByName = new CompareByName();

        //Inicialização Arvore
        FReader reader = new FReader();

        Menu.InicializaArvore();

        Arvore<Aluno> SByCode = reader.reader("entradaBalanceada50", compareByCode);
        Arvore<Aluno> SByName = reader.reader("entradaBalanceada50", compareByName);

        //Inicializa Ações
        Scanner sc = new Scanner(System.in);

        //Inicialização do Menu
        Menu.textoInicial();
        Menu.acoes();
        int userAnswMenu = sc.nextInt();

        while(userAnswMenu != 4){

            if(userAnswMenu == 1){
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
            else if(userAnswMenu == 2){

                Menu.selecaoMatricula();

                int userAnsw = sc.nextInt();

                if(userAnsw == 1){
                    Menu.buscarMatricula();
                    int matricula = sc.nextInt();
                    Aluno matAluno = new Aluno(matricula);
                    SByCode.search(matAluno);
                }
                else if(userAnsw == 2){
                    System.out.println("Não está pronto");
                }
                else if(userAnsw == 3){
                    SByCode.initHigh();
                    SByCode.initLow();
                }
            }

            else if(userAnswMenu == 3){

                Menu.selecaoNome();

                int userAnsw = sc.nextInt();
                sc.nextLine();

                if(userAnsw == 1){
                    Menu.buscarNome();
                    String nome = sc.nextLine();
                    Aluno matAluno = new Aluno(nome);
                    SByName.search(matAluno);
                }
                else if(userAnsw == 2){
                    System.out.println("Não está pronto");
                }
                else if(userAnsw == 3){
                    SByName.initHigh();
                    SByName.initLow();
                }
            }

            else{
                System.exit(0);
            }
        }
    }
}