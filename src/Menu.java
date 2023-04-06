public abstract interface Menu {

    public static void textoInicial() {
        System.out.println("Selecione uma opção para realizar uma ação: ");
    }

    public static void acoes(){
        System.out.println("1 - Adicionar Elemento na árvore");
    }

    public static void adicionarElemento(){
        System.out.println("Digite a matrícula do aluno, nome e nota: ");
    }
}
