public abstract interface Menu {

    public static void textoInicial() {
        System.out.println("=*=*=*= SELECIONE UMA OPÇÃO PARA REALIZAR UMA AÇÃO: =*=*=*=");
    }

    public static void acoes(){
        System.out.println("1 - Adicionar Aluno; \n2 - Selecionar Árvore por Matrícula; \n3 - Selecionar Árvore por Nome; \n4 - Sair\n ");
    }

    public static void adicionarElemento(){
        System.out.println("Digite a matrícula do aluno, nome e nota: ");
    }

    public static void selecaoMatricula() {
        System.out.println("*Árvore por Matrícula*: ");
        System.out.println("1 - Buscar");
        System.out.println("2 - Excluir");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Percorrer Árvore");
    }

    public static void selecaoNome() {
        System.out.println("*Árvore por Nome*: ");
        System.out.println("1 - Buscar");
        System.out.println("2 - Excluir");
        System.out.println("3 - Estatísticas");
        System.out.println("4 - Percorrer Árvore");
    }

    public static void displaySearchCode(){
        System.out.println("Digite 1 para busca em nível\nDigite 2 para busca em ordem\n");
    }

    public static void buscarMatricula(){
        System.out.println("Digite a matrícula a ser buscada: ");
    }

    public static void buscarNome(){
        System.out.println("Digite o Nome a ser buscado: ");
    }

    public static void exibirAltura() {
        System.out.println("A altura da árvore é igual a ");
    }

    public static void BuscarMat() {
        System.out.println("Digite a matrícula a ser buscada: ");
    }

    public static void InicializaArvore(){
        System.out.println("Fazendo a inicialização das Árvores!");
    }

    public static void contAcoes(int answ){
        if(answ == 1){
            adicionarElemento();
        }
    }

}
