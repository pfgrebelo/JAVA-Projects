import java.util.Random;
import java.util.Scanner;

/*O jogo dos 21 fósforos coloca dois oponentes a retirar fósforos, à vez, até sobrar o último.
Quem ficar com o último fósforo perde. Em cada jogada é possível retirar 1, 2, 3 ou 4 fósforos.
Implemente uma aplicação que permita jogar:
1. Dois jogadores humanos;
2. Humano contra computador (sem inteligência);
3. Humano contra computador (com inteligência);*/

public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    static int fosforos = 21; //variavel que define o monte de fosforos
    static int jogada = 0;  //variavel que define quantos fosforos o jogador retira do monte
    static int jogadaIA = 0;

    public static void main(String[] args) {
        int op = 1;
        while (op != 0) {       //menu para escolher 1 dos 3 metodos
            System.out.println("-----JOGO DOS 21 FOSFOROS-----");
            System.out.println("1-Jogador vs Jogador");
            System.out.println("2-Jogador vs Computador (facil)");
            System.out.println("3-Jogador vs Computador (dificil)");
            System.out.println("0-Sair");
            op = in.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    jogadorVSjogador();
                    break;
                case 2:
                    jogadorVScomputador();
                    break;
                case 3:
                    jogadorVScomputadorIA();
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
        }
    }

    private static void jogadorVScomputadorIA() {
        fosforos = 21;                              //faz reset ao monte de fosforos caso já tenham jogado outro jogo
        System.out.println("-----JOGADOR VS COMPUTADOR(dificil)-----");
        System.out.println("Queres jogar primeiro? (S/N)");
        in = new Scanner(System.in);
        String jogarPrimeiro = in.nextLine();            //variavel para condição de jogar em primeiro lugar ou não
        while (fosforos > 0) {                          //o jogo decorre enquanto há fosforos no monte
            if (jogarPrimeiro.equals("s") || jogarPrimeiro.equals("S")) {   //aqui verifica se utilizador escolheu jogar 1º
                System.out.println("Sobram " + fosforos + " fosforos.");
                System.out.println("Quantos fosforos queres tirar? (1 a 4)");
                jogada = in.nextInt();
                if (jogada <= 0 || jogada > 4) {        //verifica se a jogada é valida, entre 1 a 4
                    System.out.println("Jogada invalida, tenta outra vez");
                } else {
                    fosforos = fosforos - jogada;           //verificando-se correta, aqui completa a jogada
                    System.out.println("Sobram " + fosforos + " fosforos.");
                }
                if (fosforos <= 0) {                //aqui verifica se retirou o ultimo dos fosforos
                    System.out.println("Perdeste o jogo!");
                } else {                        //caso tenha sobrado fosforos, dá a vez ao computador
                    if (jogada == 1) {          //verifica a jogada do jogador e joga o numero que faça a soma de 5 entre os 2, em vez de jogar aleatorio
                        jogada = 4;
                    } else if (jogada == 2) {
                        jogada = 3;
                    } else if (jogada == 3) {
                        jogada = 2;
                    } else if (jogada == 4) {
                        jogada = 1;
                    }
                    System.out.println("O computador retirou " + jogada + " fosforo(s).");
                    fosforos = fosforos - jogada;
                    if (fosforos <= 0) {
                        System.out.println("PARABENS!!! Ganhaste o jogo!");
                    }
                }
            } else if (jogarPrimeiro.equals("n") || jogarPrimeiro.equals("N")) {    //verifica se jogador escolheu jogar em 2º
                int temp = jogadaIA + jogada;       //variavel para determinar se o jogador está a ganhar, enquanto a soma for 5, jogador ganha sempre
                if (fosforos == 21 || temp == 5) {       //aqui o computador joga aleatorio na primeira jogada e enquanto o jogador está na frente
                    jogadaIA = rnd.nextInt(1, 5);
                } else {
                    jogadaIA = 10 - temp;           //caso o temp fique diferente de 5, significa que o jogador se enganou, e dá a volta jogando a diferença de 10 e as 2 jogadas anteriores
                    if (jogadaIA > 4) {
                        jogadaIA = 5 - jogada;      //caso ainda tenham vários fosforos e essa diferença for maior que 4, ele joga a diferença de 5 e a jogada do utilizador
                    }
                    if (fosforos == 2) {            //se o engano do jogador deixar apenas 2, obriga computador a jogar 1
                        jogadaIA = 1;
                    }
                    if (fosforos == 3) {
                        jogadaIA = 2;
                    }
                    if (fosforos == 4) {
                        jogadaIA = 3;
                    }
                    if (fosforos == 5) {            //se o engano do jogador deixar apenas 5, obriga computador a jogar 4
                        jogadaIA = 4;
                    }
                }
                System.out.println("O computador retirou " + jogadaIA + " fosforo(s).");
                fosforos = fosforos - jogadaIA;
                if (fosforos <= 0) {
                    System.out.println("PARABENS!!! Ganhaste o jogo!");
                } else {
                    System.out.println("Sobram " + fosforos + " fosforos.");
                    System.out.println("Quantos fosforos queres tirar? (1 a 4)");
                    jogada = in.nextInt();
                    if (jogada <= 0 || jogada > 4) {
                        System.out.println("Jogada invalida, tenta outra vez");
                    } else {
                        fosforos = fosforos - jogada;
                        System.out.println("Sobram " + fosforos + " fosforos.");
                    }
                    if (fosforos <= 0) {
                        System.out.println("Perdeste o jogo!");
                    }
                }
            } else {                    //feedback caso jogador não escolha corretamente se quer jogar 1º ou 2º
                System.out.println("Opcao Invalida. Tente outra vez.");
                return;
            }
        }
    }

    private static void jogadorVScomputador() {
        fosforos = 21;      //faz reset ao monte de fosforos caso já tenham jogado outro jogo
        System.out.println("-----JOGADOR VS COMPUTADOR-----");
        System.out.println("Queres jogar primeiro? (S/N)");
        in = new Scanner(System.in);
        String jogarPrimeiro = in.nextLine();               //variavel para condição de jogar em primeiro lugar ou não
        while (fosforos > 0) {                            //o jogo decorre enquanto há fosforos no monte
            if (jogarPrimeiro.equals("s") || jogarPrimeiro.equals("S")) {   //aqui verifica se utilizador escolheu jogar 1º
                System.out.println("Sobram " + fosforos + " fosforos.");
                System.out.println("Quantos fosforos queres tirar? (1 a 4)");
                jogada = in.nextInt();
                if (jogada <= 0 || jogada > 4) {        //verifica se a jogada é valida, entre 1 a 4
                    System.out.println("Jogada invalida, tenta outra vez");
                } else {
                    fosforos = fosforos - jogada;       //verificando-se correta, aqui completa a jogada
                    System.out.println("Sobram " + fosforos + " fosforos.");
                }
                if (fosforos <= 0) {                    //aqui verifica se retirou o ultimo dos fosforos
                    System.out.println("Perdeste o jogo!");
                } else {                                //caso tenha sobrado fosforos, dá a vez ao computador
                    jogada = rnd.nextInt(1, 5);  //é gerado um numero aleatorio para fazer a jogada do computador
                    System.out.println("O computador retirou " + jogada + " fosforo(s).");
                    fosforos = fosforos - jogada;
                    if (fosforos <= 0) {
                        System.out.println("PARABENS!!! Ganhaste o jogo!");
                    }
                }
            } else if (jogarPrimeiro.equals("n") || jogarPrimeiro.equals("N")) {    //verifica se jogador escolheu jogar em 2º
                jogada = rnd.nextInt(1, 5);
                System.out.println("O computador retirou " + jogada + " fosforo(s).");
                fosforos = fosforos - jogada;
                if (fosforos <= 0) {
                    System.out.println("PARABENS!!! Ganhaste o jogo!");
                } else {
                    System.out.println("Sobram " + fosforos + " fosforos.");
                    System.out.println("Quantos fosforos queres tirar? (1 a 4)");
                    jogada = in.nextInt();
                    if (jogada <= 0 || jogada > 4) {
                        System.out.println("Jogada invalida, tenta outra vez");
                    } else {
                        fosforos = fosforos - jogada;
                        System.out.println("Sobram " + fosforos + " fosforos.");
                    }
                    if (fosforos <= 0) {
                        System.out.println("Perdeste o jogo!");
                    }
                }
            } else {                //feedback caso jogador não escolha corretamente se quer jogar 1º ou 2º
                System.out.println("Opcao Invalida. Tente outra vez.");
                return;
            }
        }
    }

    private static void jogadorVSjogador() {
        fosforos = 21;               //faz reset ao monte de fosforos caso já tenham jogado outro jogo
        System.out.println("-----JOGADOR VS JOGADOR-----");
        while (fosforos > 0) {          //o jogo decorre enquanto há fosforos no monte
            System.out.println("JOGADOR 1");
            System.out.println("Sobram " + fosforos + " fosforos.");
            System.out.println("Quantos fosforos queres tirar? (1 a 4)");
            jogada = in.nextInt();
            if (jogada <= 0 || jogada > 4) {        //verifica se a jogada é valida, entre 1 a 4
                System.out.println("Jogada invalida, tenta outra vez");
            } else {
                fosforos = fosforos - jogada;       //verificando-se correta, aqui completa a jogada
            }
            if (fosforos <= 0) {            //aqui verifica se retirou o ultimo dos fosforos
                System.out.println("Jogador 2 ganhou o jogo!");
            } else {                //caso tenha sobrado fosforos, dá a vez ao jogador 2
                System.out.println("JOGADOR 2");
                System.out.println("Sobram " + fosforos + " fosforos.");
                System.out.println("Quantos fosforos queres tirar? (1 a 4)");
                jogada = in.nextInt();
                if (jogada <= 0 || jogada > 4) {
                    System.out.println("Jogada invalida, tenta outra vez");
                } else {
                    fosforos = fosforos - jogada;
                }
                if (fosforos <= 0) {
                    System.out.println("Jogador 1 ganhou o jogo!");
                }
            }
        }
    }
}