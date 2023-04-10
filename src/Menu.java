public abstract interface Menu {

    public static void textoInicial() {
        System.out.println("Selecione uma opção para realizar uma ação: ");
    }

    public static void acoes(){
        System.out.println("1 - Adicionar Elemento na árvore; \n2 - Selecionar Árvore por Matrícula; \n3 - Selecionar Árvore por Nome; \n4 - Sair\n ");
    }

    public static void adicionarElemento(){
        System.out.println("Digite a matrícula do aluno, nome e nota: ");
    }

    public static void selecaoMatricula() {
        System.out.println("*Árvore por Matrícula*: ");
        System.out.println("1 - Buscar");
        System.out.println("2 - Excluir");
        System.out.println("3 - Estatísticas");
    }

    public static void BuscarMat() {
        System.out.println("Digite a matrícula a ser buscada: ");
    }

}
