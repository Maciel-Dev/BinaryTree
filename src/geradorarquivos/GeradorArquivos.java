/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradorarquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoriocarvalho
 */
public class GeradorArquivos {

    final char[] vogais = {'a', 'e', 'i', 'o','u','A','E','I','O','U'};
    final Random rand = new Random();
    final int matriculaBase = 2000000000;

    public enum TipoArquivo{ORDENADO, BALANCEADO}

    private boolean ehVogal (char c){
        for (char l: vogais){
            if (l==c) return true;
        }
        return false;
    }

    private char geraVogal(boolean min){
        if (min)
            return vogais[rand.nextInt(5)];
        else
            return vogais[5+rand.nextInt(5)];
    }

    private char geraLetra(boolean min){
        if (min)
            return (char) ('a'+rand.nextInt(26));
        else
            return (char) ('A'+rand.nextInt(26));
    }


    private String geraPalavra(int tam){
        int cont;
        StringBuilder palavra = new StringBuilder();

        palavra.append(geraLetra(false));
        for(cont=1;cont<tam;cont++){
            if (ehVogal(palavra.charAt(cont-1)))
                palavra.append(geraLetra(true));
            else
                palavra.append(geraVogal(true));
        }
        return palavra.toString();
    }

    private String geraNomeCompleto(){
        String nome="";
        nome+= geraPalavra(3+rand.nextInt(6));
        nome+=" ";
        nome+= geraPalavra(3+rand.nextInt(6));
        return nome;
    }

    public void geraArqOrdenado(int n){
        int i,nota,matricula= matriculaBase;
        String nome;

        FileWriter arq;
        try {
            arq = new FileWriter("entradaOrdenada"+n+".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(n);
            for(i=1;i<=n;i++){
                matricula++;
                nome = geraNomeCompleto();
                nota = 10 + rand.nextInt(91);
                gravarArq.printf("%d;%s;%d%n",matricula, nome, nota);
            }
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void geraArqBalanceado(int n){
        int i,nota,matricula= 2000000000;
        String nome;

        FileWriter arq;
        try {
            arq = new FileWriter("entradaBalanceada"+n+".txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(n);
            geraBalanceado(1,n,gravarArq);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void geraBalanceado(int min, int max,PrintWriter gravarArq){
        if (min <= max){
            int media = (min+max)/2;
            int matricula = matriculaBase+media;
            String nome = geraNomeCompleto();
            int nota = 10 + rand.nextInt(91);
            gravarArq.printf("%d;%s;%d%n",matricula, nome, nota);
            geraBalanceado(min,media-1,gravarArq);
            geraBalanceado(media+1,max,gravarArq);
        }
    }

    public void geraArquivo(int tam, TipoArquivo t){
        switch (t){
            case ORDENADO:
                geraArqOrdenado(tam);
                break;
            case BALANCEADO:
                geraArqBalanceado(tam);
                break;
        }
    }
}