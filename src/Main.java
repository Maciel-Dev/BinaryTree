import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<Integer>();
        Random random = new Random();

        for(int i = 0; i <= 15; i++){
            arvore.add(random.nextInt(20));
        }


        arvore.StraightWalk();
    }
}