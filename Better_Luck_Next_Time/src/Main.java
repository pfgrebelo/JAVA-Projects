import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static String nome;
    static Random rnd = new Random();
    static int saldo = 100;

    public static void main(String[] args) {
//FALTA LEVANTAMENTO E DEPOSITO

        System.out.println("Bem Vindo ao programa Better Luck Next Time");
        System.out.println("Introduza o seu nome");
        nome = in.nextLine();

        int op = 1;

        while (op != 0) {
            System.out.println("Ola " + nome + "\t Saldo: "+saldo);
            System.out.println("Escolha uma das seguintes opcoes:");
            System.out.println("1 - Lotaria");
            System.out.println("2 - Raspadinhas");
            System.out.println("3 - Levantamentos/Depositos");
            System.out.println("0 - Sair");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                Lotaria();
            } else if (op == 2) {
                Raspadinhas();
            } else if (op == 3) {
                Saldo();
            }else {
                System.out.println("Opcao invalida");
            }
        }
        System.out.println("Programa terminado.");
    }

    private static void Saldo() {
        System.out.println("Menu 3 - Levantamentos/Depositos");
        int op =0;

        while (op != 0) {
            System.out.println("Escolha uma das seguintes opcoes:");
            System.out.println("1 - Deposito");
            System.out.println("2 - Levantamento");
            System.out.println("0 - Voltar");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                Deposito();
            } else if (op == 2) {
                Levantamento();
            } else {
                System.out.println("Opcao invalida");
            }
        }
    }

    private static void Levantamento() {
        System.out.println("Escolheu Levantamento");
    }

    private static void Deposito() {
        System.out.println("Escolheu Deposito");
    }

    private static void Raspadinhas() {
        System.out.println(nome + ", escolheu Raspadinhas");

        int op = 1;

        while (op != 0) {
            System.out.println("Escolha uma das seguintes opcoes:" + "\t Saldo: "+saldo);
            System.out.println("1 - Raspadinhas A");
            System.out.println("2 - Raspadinhas B");
            System.out.println("0 - Voltar");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                RaspadinhasA();
            } else if (op == 2) {
                RaspadinhasB();
            } else {
                System.out.println("Opcao invalida");
            }
        }

    }

    private static void RaspadinhasB() {
        if (saldo - 2 < 0){
            System.out.println("Saldo Insuficiente");
            return;
        }

        saldo -=2;
        System.out.println("Raspadinhas B -------");
        int nrprincipal = rnd.nextInt(1, 10);
        int premio = rnd.nextInt(1,100);
        int nOcorrencia = 0;

        System.out.println("Numero principal: " + nrprincipal + " ("+premio+"eur)");
        for (int i = 0; i < 9; i++) {
            int num = rnd.nextInt(1,10);
            System.out.println(num+" ");
            if (num == nrprincipal)
                nOcorrencia++;
        }
        System.out.println();
        if (nOcorrencia >=3){
            System.out.println("Parabens! Ganhou " + premio + " Eur.");
            saldo += premio;
        } else {
            System.out.println("Infelizmente nao ganhou");
        }

    }

    private static void RaspadinhasA() {
        if (saldo - 2 < 0){
            System.out.println("Saldo Insuficiente");
            return;
        }

        saldo -=2;
        System.out.println("Raspadinhas A -------");
        int nrprincipal, n1, n2, n3, n4, n5, p1, p2, p3, p4, p5, premio = 0;
        nrprincipal = rnd.nextInt(1, 10);
        n1 = rnd.nextInt(1, 10);
        n2 = rnd.nextInt(1, 10);
        n3 = rnd.nextInt(1, 10);
        n4 = rnd.nextInt(1, 10);
        n5 = rnd.nextInt(1, 10);
        p1 = rnd.nextInt(1, 10);
        p2 = rnd.nextInt(1, 10);
        p3 = rnd.nextInt(1, 10);
        p4 = rnd.nextInt(1, 10);
        p5 = rnd.nextInt(1, 10);

        if (n1 == nrprincipal)
            premio += p1;
        if (n2 == nrprincipal)
            premio += p2;
        if (n3 == nrprincipal)
            premio += p3;
        if (n4 == nrprincipal)
            premio += p4;
        if (n5 == nrprincipal)
            premio += p5;

        System.out.println("Nr Principal: " + nrprincipal);
        System.out.println("-> " + n1 + " " + p1 + "Eur.");
        System.out.println("-> " + n2 + " " + p2 + "Eur.");
        System.out.println("-> " + n3 + " " + p3 + "Eur.");
        System.out.println("-> " + n4 + " " + p4 + "Eur.");
        System.out.println("-> " + n5 + " " + p5 + "Eur.");

        if (premio > 0) {
            System.out.println("Premio total: " + premio + " Eur.");
            saldo += premio;
        } else {
            System.out.println("Infelizmente nao ganhou, tente outra vez");
        }
    }

    private static void Lotaria() {
        if (saldo - 5 < 0){
            System.out.println("Saldo Insuficiente");
            return;
        }

        saldo -=5;
        System.out.println(nome + ", escolheu Lotaria");
        int nrapost, nrpremiado;
        System.out.println("Escolha um numero para apostar (entre 1000 e 9999)" + "\t Saldo: "+saldo);
        nrapost = in.nextInt();
        nrpremiado = rnd.nextInt(1000, 10000);

        System.out.println("Numero premiado: " + nrpremiado);

        if (nrapost < 1000 || nrapost > 9999) {
            System.out.println("Numero invalido, tem de escolher entre 1000 e 9999");

        } else if (nrapost == nrpremiado) {
            System.out.println("Parabens, " + nome + "! Ganhou o primeiro premio");
            saldo += 1000;
        } else if (nrapost % 1000 == nrpremiado % 1000) {
            System.out.println("Parabens, " + nome + "! Ganhou o segundo premio");
            saldo += 100;
        } else if (nrapost % 100 == nrpremiado % 100) {
            System.out.println("Parabens, " + nome + "! Ganhou o terceiro premio");
            saldo += 10;
        } else {
            System.out.println("Infelizmente nao foi desta, tenta outra vez");
        }
    }

}