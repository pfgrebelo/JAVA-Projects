import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
O Euromilhões é um jogo de sorte ou azar no qual o jogador deve preencher uma chave composta
por 5 números de 1 a 50 e 2 estrelas (números) de 1 a 11. Crie uma aplicação que permita ao utilizador:
1. Simular um sorteio (sortear uma chave vencedora que deve ser apresentada ao utilizador de forma ordenada).
2. Criar um boletim com 1 a 5 chaves (inseridas pelo utilizador) e comparar com a chave vencedora desse sorteio.
3. Criar um boletim com 1 a 5 chaves (criadas aleatoriamente) e comparar com a chave vencedora desse sorteio.
4. Simular quantas vezes seria necessário jogar (sempre com a mesma chave) de forma a conseguir
ganhar o 1º prémio (5 números e 2 estrelas).
Informação extra: https://www.jogossantacasa.pt/web/SCCartazResult/
*/

public class Main {
    static Chave c = new Chave();
    static Boletim b = new Boletim();
    static Scanner in = new Scanner(System.in);
    static int tamBol = 0;  //variavel que verifica o tamanho do boletim registado
    static int numsCertos = 0, starsCertas = 0, numsCertos2 = 0, starsCertas2 = 0, numsCertos3 = 0, starsCertas3 = 0, numsCertos4 = 0, starsCertas4 = 0, numsCertos5 = 0, starsCertas5 = 0;
    static double premio1 = 87000000;
    static double premio2 = 95084.08;
    static double premio3 = 16161.97;
    static double premio4 = 954.73;
    static double premio5 = 93.41;
    static double premio6 = 37.01;
    static double premio7 = 36.01;
    static double premio8 = 9.83;
    static double premio9 = 8.64;
    static double premio10 = 8.06;
    static double premio11 = 5.40;
    static double premio12 = 4.69;
    static double premio13 = 3.63;
    static double ganhoTotal = 0;

    public static void main(String[] args) {
        c.geraNumeros(); //mal o programa é iniciado, gera uma chave vencedora
        c.geraEstrelas();
        int op = 1;
        while (op != 0) {
            System.out.println("------EUROMILHOES------");
            System.out.println("1-Mostra chave vencedora");
            System.out.println("2-Sortear nova chave vencedora");
            System.out.println("3-Registar boletim (c/escolha)");
            System.out.println("4-Registar boletim (aleatorio)");
            System.out.println("5-Mostra boletim");
            System.out.println("6-Verificar premio");
            System.out.println("7-Quantas vezes preciso jogar para ganhar?");
            System.out.println("0-Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    c.mostraChave();
                    break;
                case 2:
                    c.geraNumeros();
                    c.geraEstrelas();
                    c.mostraChave();
                    break;
                case 3:
                    registarAposta();
                    break;
                case 4:
                    registarApostaRnd();
                    break;
                case 5:
                    System.out.println("---BOLETIM---");
                    if (tamBol == 0) {             //verifica o tamanho do boletim para mostrar o tamanho correto
                        System.out.println("Ainda nao tem boletins registados. Faca a sua aposta!");
                    } else if (tamBol == 1) {
                        b.mostraBoletim();
                    } else if (tamBol == 2) {
                        b.mostraBoletim2Chaves();
                    } else if (tamBol == 3) {
                        b.mostraBoletim3Chaves();
                    } else if (tamBol == 4) {
                        b.mostraBoletim4Chaves();
                    } else if (tamBol == 5) {
                        b.mostraBoletim5Chaves();
                    } else {
                        System.out.println("Boletim com tamanho invalido.");
                    }
                    break;
                case 6:
                    verificarPremio();
                    break;
                case 7:
                    contadorApostas();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    private static void contadorApostas() {
        int acum = 1;
        System.out.println("------CONTADOR DE APOSTAS------");
        b.escolheNumerosBoletim();
        tamBol=1;
        verificarPremio();
        while (numsCertos!=5 || starsCertas!=2){
            c.geraNumeros();
            c.geraEstrelas();
            verificarPremio();
            acum = acum + 1;
            System.out.println(acum);
        }
        System.out.println("Foram precisas " + acum + " apostas.");
    }       //PEDE AO UTILIZADOR UMA CHAVE, E CONTA QUANTAS APOSTAS PRECISA ATÉ GANHAR

    private static void registarAposta() {
        int op = 1;
        while (op != 0) {
            System.out.println("------REGISTO DE APOSTA------");
            System.out.println("Quantas chaves quer apostar? (1 a 5)");
            System.out.println("(0 para voltar)");
            op = in.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    b.escolheNumerosBoletim();
                    b.mostraBoletim();
                    tamBol = 1;         //regista quantas chaves apostou no boletim
                    return;
                case 2:
                    b.escolheNumerosBoletim2Chaves();
                    b.mostraBoletim2Chaves();
                    tamBol = 2;
                    return;
                case 3:
                    b.escolheNumerosBoletim3Chaves();
                    b.mostraBoletim3Chaves();
                    tamBol = 3;
                    return;
                case 4:
                    b.escolheNumerosBoletim4Chaves();
                    b.mostraBoletim4Chaves();
                    tamBol = 4;
                    return;
                case 5:
                    b.escolheNumerosBoletim5Chaves();
                    b.mostraBoletim5Chaves();
                    tamBol = 5;
                    return;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }       //REGISTA APOSTA COM NUMEROS ESCOLHIDOS PELO UTILIZADOR

    private static void verificarPremio() {
        numsCertos = 0; starsCertas = 0; numsCertos2 = 0; starsCertas2 = 0; numsCertos3 = 0; starsCertas3 = 0; numsCertos4 = 0; starsCertas4 = 0; numsCertos5 = 0; starsCertas5 = 0;
        if (tamBol == 0) {              //VERIFICA SE EXISTE BOLETIM REGISTADO
            System.out.println("Tem de fazer a aposta primeiro");
        } else if (tamBol == 1) {                               //VERIFICA PREMIO NUM BOLETIM COM 1 CHAVE
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 1
                for (int j = 0; j < b.getNums1().length; j++) {
                    if (c.getNums()[i] == b.getNums1()[j]) {
                        numsCertos++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 1
                for (int j = 0; j < b.getStars1().length; j++) {
                    if (c.getStars()[i] == b.getStars1()[j]) {
                        starsCertas++;
                    }
                }
            }
            System.out.println("Acertou em " + numsCertos + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas + " estrelas.");
            atribuirPremio();
        } else if (tamBol == 2) {                               //VERIFICA PREMIO NUM BOLETIM COM 2 CHAVES
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 1
                for (int j = 0; j < b.getNums1().length; j++) {
                    if (c.getNums()[i] == b.getNums1()[j]) {
                        numsCertos++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 1
                for (int j = 0; j < b.getStars1().length; j++) {
                    if (c.getStars()[i] == b.getStars1()[j]) {
                        starsCertas++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 2
                for (int j = 0; j < b.getNums2().length; j++) {
                    if (c.getNums()[i] == b.getNums2()[j]) {
                        numsCertos2++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 2
                for (int j = 0; j < b.getStars2().length; j++) {
                    if (c.getStars()[i] == b.getStars2()[j]) {
                        starsCertas2++;
                    }
                }
            }
            System.out.println("Chave 1:");
            System.out.println("Acertou em " + numsCertos + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas + " estrelas.");
            atribuirPremio();
            System.out.println("Chave 2:");
            System.out.println("Acertou em " + numsCertos2 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas2 + " estrelas.");
            atribuirPremio2();
            if (ganhoTotal != 0) {
                System.out.println("Ganhos totais:");
                System.out.printf("Ganhou um total de " + "%.2f\n", ganhoTotal);
            }
        } else if (tamBol == 3) {                               //VERIFICA PREMIO NUM BOLETIM COM 3 CHAVES
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 1
                for (int j = 0; j < b.getNums1().length; j++) {
                    if (c.getNums()[i] == b.getNums1()[j]) {
                        numsCertos++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 1
                for (int j = 0; j < b.getStars1().length; j++) {
                    if (c.getStars()[i] == b.getStars1()[j]) {
                        starsCertas++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 2
                for (int j = 0; j < b.getNums2().length; j++) {
                    if (c.getNums()[i] == b.getNums2()[j]) {
                        numsCertos2++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 2
                for (int j = 0; j < b.getStars2().length; j++) {
                    if (c.getStars()[i] == b.getStars2()[j]) {
                        starsCertas2++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 3
                for (int j = 0; j < b.getNums3().length; j++) {
                    if (c.getNums()[i] == b.getNums3()[j]) {
                        numsCertos3++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 3
                for (int j = 0; j < b.getStars3().length; j++) {
                    if (c.getStars()[i] == b.getStars3()[j]) {
                        starsCertas3++;
                    }
                }
            }
            System.out.println("Chave 1:");         //ATRIBUIÇÃO DE PREMIOS EM VARIAS CHAVES NAO COMPLETA
            System.out.println("Acertou em " + numsCertos + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas + " estrelas.");
            atribuirPremio();
            System.out.println("Chave 2:");
            System.out.println("Acertou em " + numsCertos2 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas2 + " estrelas.");
            atribuirPremio2();
            System.out.println("Chave 3:");
            System.out.println("Acertou em " + numsCertos3 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas3 + " estrelas.");
            atribuirPremio3();
            if (ganhoTotal != 0) {
                System.out.println("Ganhos totais:");
                System.out.printf("Ganhou um total de " + "%.2f\n", ganhoTotal);
            }
        } else if (tamBol == 4) {                               //VERIFICA PREMIO NUM BOLETIM COM 4 CHAVES
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 1
                for (int j = 0; j < b.getNums1().length; j++) {
                    if (c.getNums()[i] == b.getNums1()[j]) {
                        numsCertos++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 1
                for (int j = 0; j < b.getStars1().length; j++) {
                    if (c.getStars()[i] == b.getStars1()[j]) {
                        starsCertas++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 2
                for (int j = 0; j < b.getNums2().length; j++) {
                    if (c.getNums()[i] == b.getNums2()[j]) {
                        numsCertos2++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 2
                for (int j = 0; j < b.getStars2().length; j++) {
                    if (c.getStars()[i] == b.getStars2()[j]) {
                        starsCertas2++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 3
                for (int j = 0; j < b.getNums3().length; j++) {
                    if (c.getNums()[i] == b.getNums3()[j]) {
                        numsCertos3++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 3
                for (int j = 0; j < b.getStars3().length; j++) {
                    if (c.getStars()[i] == b.getStars3()[j]) {
                        starsCertas3++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 4
                for (int j = 0; j < b.getNums4().length; j++) {
                    if (c.getNums()[i] == b.getNums4()[j]) {
                        numsCertos4++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 4
                for (int j = 0; j < b.getStars4().length; j++) {
                    if (c.getStars()[i] == b.getStars4()[j]) {
                        starsCertas4++;
                    }
                }
            }
            System.out.println("Chave 1:");         //ATRIBUIÇÃO DE PREMIOS EM VARIAS CHAVES NAO COMPLETA
            System.out.println("Acertou em " + numsCertos + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas + " estrelas.");
            atribuirPremio();
            System.out.println("Chave 2:");
            System.out.println("Acertou em " + numsCertos2 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas2 + " estrelas.");
            atribuirPremio2();
            System.out.println("Chave 3:");
            System.out.println("Acertou em " + numsCertos3 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas3 + " estrelas.");
            atribuirPremio3();
            System.out.println("Chave 4:");
            System.out.println("Acertou em " + numsCertos4 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas4 + " estrelas.");
            atribuirPremio4();
            if (ganhoTotal != 0) {
                System.out.println("Ganhos totais:");
                System.out.printf("Ganhou um total de " + "%.2f\n", ganhoTotal);
            }
        } else if (tamBol == 5) {                               //VERIFICA PREMIO NUM BOLETIM COM 5 CHAVES
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 1
                for (int j = 0; j < b.getNums1().length; j++) {
                    if (c.getNums()[i] == b.getNums1()[j]) {
                        numsCertos++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 1
                for (int j = 0; j < b.getStars1().length; j++) {
                    if (c.getStars()[i] == b.getStars1()[j]) {
                        starsCertas++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 2
                for (int j = 0; j < b.getNums2().length; j++) {
                    if (c.getNums()[i] == b.getNums2()[j]) {
                        numsCertos2++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 2
                for (int j = 0; j < b.getStars2().length; j++) {
                    if (c.getStars()[i] == b.getStars2()[j]) {
                        starsCertas2++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 3
                for (int j = 0; j < b.getNums3().length; j++) {
                    if (c.getNums()[i] == b.getNums3()[j]) {
                        numsCertos3++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 3
                for (int j = 0; j < b.getStars3().length; j++) {
                    if (c.getStars()[i] == b.getStars3()[j]) {
                        starsCertas3++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 4
                for (int j = 0; j < b.getNums4().length; j++) {
                    if (c.getNums()[i] == b.getNums4()[j]) {
                        numsCertos4++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 4
                for (int j = 0; j < b.getStars4().length; j++) {
                    if (c.getStars()[i] == b.getStars4()[j]) {
                        starsCertas4++;
                    }
                }
            }
            for (int i = 0; i < c.getNums().length; i++) {          //NUMEROS DA CHAVE 5
                for (int j = 0; j < b.getNums5().length; j++) {
                    if (c.getNums()[i] == b.getNums5()[j]) {
                        numsCertos5++;
                    }
                }
            }
            for (int i = 0; i < c.getStars().length; i++) {          //ESTRELAS DA CHAVE 5
                for (int j = 0; j < b.getStars5().length; j++) {
                    if (c.getStars()[i] == b.getStars5()[j]) {
                        starsCertas5++;
                    }
                }
            }
            System.out.println("Chave 1:");         //ATRIBUIÇÃO DE PREMIOS EM VARIAS CHAVES NAO COMPLETA
            System.out.println("Acertou em " + numsCertos + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas + " estrelas.");
            atribuirPremio();
            System.out.println("Chave 2:");
            System.out.println("Acertou em " + numsCertos2 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas2 + " estrelas.");
            atribuirPremio2();
            System.out.println("Chave 3:");
            System.out.println("Acertou em " + numsCertos3 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas3 + " estrelas.");
            atribuirPremio3();
            System.out.println("Chave 4:");
            System.out.println("Acertou em " + numsCertos4 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas4 + " estrelas.");
            atribuirPremio4();
            System.out.println("Chave 5:");
            System.out.println("Acertou em " + numsCertos5 + " numeros.");       //CONTA QUANTOS NRS E ESTRELAS ACERTOU
            System.out.println("Acertou em " + starsCertas5 + " estrelas.");
            atribuirPremio5();
            if (ganhoTotal != 0) {
                System.out.println("Ganhos totais:");
                System.out.printf("Ganhou um total de " + "%.2f\n", ganhoTotal);
            }
        }
    }       //VERIFICA SE BOLETIM REGISTADO TEM PREMIO

    private static void atribuirPremio() {
        if (numsCertos == 5 && starsCertas == 2) {                      //ATRIBUI OS PREMIOS DEPENDENDO DE QUANTOS ACERTOU
            System.out.println("PARABENS! GANHOU O 1o PREMIO!");
            System.out.printf("Ganhou " + "%.0f\n", premio1);
            System.out.println("A criar excentricos todas as semanas!");
            ganhoTotal = ganhoTotal + premio1;
        } else if (numsCertos == 5 && starsCertas == 1) {
            System.out.println("PARABENS! GANHOU O 2o PREMIO!");
            System.out.println("Ganhou " + premio2 + " euros!");
            ganhoTotal = ganhoTotal + premio2;
        } else if (numsCertos == 5 && starsCertas == 0) {
            System.out.println("PARABENS! GANHOU O 3o PREMIO!");
            System.out.println("Ganhou " + premio3 + " euros!");
            ganhoTotal = ganhoTotal + premio3;
        } else if (numsCertos == 4 && starsCertas == 2) {
            System.out.println("PARABENS! Ganhou o 4o premio!");
            System.out.println("Ganhou " + premio4 + " euros!");
            ganhoTotal = ganhoTotal + premio4;
        } else if (numsCertos == 4 && starsCertas == 1) {
            System.out.println("PARABENS! Ganhou o 5o premio!");
            System.out.println("Ganhou " + premio5 + " euros!");
            ganhoTotal = ganhoTotal + premio5;
        } else if (numsCertos == 3 && starsCertas == 2) {
            System.out.println("PARABENS! Ganhou o 6o premio!");
            System.out.println("Ganhou " + premio6 + " euros!");
            ganhoTotal = ganhoTotal + premio6;
        } else if (numsCertos == 4 && starsCertas == 0) {
            System.out.println("PARABENS! Ganhou o 7o premio!");
            System.out.println("Ganhou " + premio7 + " euros!");
            ganhoTotal = ganhoTotal + premio7;
        } else if (numsCertos == 2 && starsCertas == 2) {
            System.out.println("PARABENS! Ganhou o 8o premio.");
            System.out.println("Ganhou " + premio8 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos == 3 && starsCertas == 1) {
            System.out.println("PARABENS! Ganhou o 9o premio.");
            System.out.println("Ganhou " + premio9 + " euros.");
            ganhoTotal = ganhoTotal + premio9;
        } else if (numsCertos == 3 && starsCertas == 0) {
            System.out.println("PARABENS! Ganhou o 10o premio.");
            System.out.println("Ganhou " + premio10 + " euros.");
            ganhoTotal = ganhoTotal + premio10;
        } else if (numsCertos == 1 && starsCertas == 2) {
            System.out.println("PARABENS! Ganhou o 11o premio.");
            System.out.println("Ganhou " + premio11 + " euros.");
            ganhoTotal = ganhoTotal + premio11;
        } else if (numsCertos == 2 && starsCertas == 1) {
            System.out.println("PARABENS! Ganhou o 12o premio.");
            System.out.println("Ganhou " + premio12 + " euros.");
            ganhoTotal = ganhoTotal + premio12;
        } else if (numsCertos == 2 && starsCertas == 0) {
            System.out.println("PARABENS! Ganhou o 13o premio.");
            System.out.println("Ganhou " + premio13 + " euros.");
            ganhoTotal = ganhoTotal + premio13;
        } else {
            System.out.println("Infelizmente nao ganhou premio");
        }
    }       //ATRIBUI PREMIO A CHAVE 1

    private static void atribuirPremio2() {
        if (numsCertos2 == 5 && starsCertas2 == 2) {                      //ATRIBUI OS PREMIOS DEPENDENDO DE QUANTOS ACERTOU
            System.out.println("PARABENS! GANHOU O 1o PREMIO!");
            System.out.printf("Ganhou " + "%.0f\n", premio1);
            System.out.println("A criar excentricos todas as semanas!");
            ganhoTotal = ganhoTotal + premio1;
        } else if (numsCertos2 == 5 && starsCertas2 == 1) {
            System.out.println("PARABENS! GANHOU O 2o PREMIO!");
            System.out.println("Ganhou " + premio2 + " euros!");
            ganhoTotal = ganhoTotal + premio2;
        } else if (numsCertos2 == 5 && starsCertas2 == 0) {
            System.out.println("PARABENS! GANHOU O 3o PREMIO!");
            System.out.println("Ganhou " + premio3 + " euros!");
            ganhoTotal = ganhoTotal + premio3;
        } else if (numsCertos2 == 4 && starsCertas2 == 2) {
            System.out.println("PARABENS! Ganhou o 4o premio!");
            System.out.println("Ganhou " + premio4 + " euros!");
            ganhoTotal = ganhoTotal + premio4;
        } else if (numsCertos2 == 4 && starsCertas2 == 1) {
            System.out.println("PARABENS! Ganhou o 5o premio!");
            System.out.println("Ganhou " + premio5 + " euros!");
            ganhoTotal = ganhoTotal + premio5;
        } else if (numsCertos2 == 3 && starsCertas2 == 2) {
            System.out.println("PARABENS! Ganhou o 6o premio!");
            System.out.println("Ganhou " + premio6 + " euros!");
            ganhoTotal = ganhoTotal + premio6;
        } else if (numsCertos2 == 4 && starsCertas2 == 0) {
            System.out.println("PARABENS! Ganhou o 7o premio!");
            System.out.println("Ganhou " + premio7 + " euros!");
            ganhoTotal = ganhoTotal + premio7;
        } else if (numsCertos2 == 2 && starsCertas2 == 2) {
            System.out.println("PARABENS! Ganhou o 8o premio.");
            System.out.println("Ganhou " + premio8 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos2 == 3 && starsCertas2 == 1) {
            System.out.println("PARABENS! Ganhou o 9o premio.");
            System.out.println("Ganhou " + premio9 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos2 == 3 && starsCertas2 == 0) {
            System.out.println("PARABENS! Ganhou o 10o premio.");
            System.out.println("Ganhou " + premio10 + " euros.");
            ganhoTotal = ganhoTotal + premio10;
        } else if (numsCertos2 == 1 && starsCertas2 == 2) {
            System.out.println("PARABENS! Ganhou o 11o premio.");
            System.out.println("Ganhou " + premio11 + " euros.");
            ganhoTotal = ganhoTotal + premio11;
        } else if (numsCertos2 == 2 && starsCertas2 == 1) {
            System.out.println("PARABENS! Ganhou o 12o premio.");
            System.out.println("Ganhou " + premio12 + " euros.");
            ganhoTotal = ganhoTotal + premio12;
        } else if (numsCertos2 == 2 && starsCertas2 == 0) {
            System.out.println("PARABENS! Ganhou o 13o premio.");
            System.out.println("Ganhou " + premio13 + " euros.");
            ganhoTotal = ganhoTotal + premio13;
        } else {
            System.out.println("Infelizmente nao ganhou premio");
        }
    }       //ATRIBUI PREMIO A CHAVE 2

    private static void atribuirPremio3() {
        if (numsCertos3 == 5 && starsCertas3 == 2) {                      //ATRIBUI OS PREMIOS DEPENDENDO DE QUANTOS ACERTOU
            System.out.println("PARABENS! GANHOU O 1o PREMIO!");
            System.out.printf("Ganhou " + "%.0f\n", premio1);
            System.out.println("A criar excentricos todas as semanas!");
            ganhoTotal = ganhoTotal + premio1;
        } else if (numsCertos3 == 5 && starsCertas3 == 1) {
            System.out.println("PARABENS! GANHOU O 2o PREMIO!");
            System.out.println("Ganhou " + premio2 + " euros!");
            ganhoTotal = ganhoTotal + premio2;
        } else if (numsCertos3 == 5 && starsCertas3 == 0) {
            System.out.println("PARABENS! GANHOU O 3o PREMIO!");
            System.out.println("Ganhou " + premio3 + " euros!");
            ganhoTotal = ganhoTotal + premio3;
        } else if (numsCertos3 == 4 && starsCertas3 == 2) {
            System.out.println("PARABENS! Ganhou o 4o premio!");
            System.out.println("Ganhou " + premio4 + " euros!");
            ganhoTotal = ganhoTotal + premio4;
        } else if (numsCertos3 == 4 && starsCertas3 == 1) {
            System.out.println("PARABENS! Ganhou o 5o premio!");
            System.out.println("Ganhou " + premio5 + " euros!");
            ganhoTotal = ganhoTotal + premio5;
        } else if (numsCertos3 == 3 && starsCertas3 == 2) {
            System.out.println("PARABENS! Ganhou o 6o premio!");
            System.out.println("Ganhou " + premio6 + " euros!");
            ganhoTotal = ganhoTotal + premio6;
        } else if (numsCertos3 == 4 && starsCertas3 == 0) {
            System.out.println("PARABENS! Ganhou o 7o premio!");
            System.out.println("Ganhou " + premio7 + " euros!");
            ganhoTotal = ganhoTotal + premio7;
        } else if (numsCertos3 == 2 && starsCertas3 == 2) {
            System.out.println("PARABENS! Ganhou o 8o premio.");
            System.out.println("Ganhou " + premio8 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos3 == 3 && starsCertas3 == 1) {
            System.out.println("PARABENS! Ganhou o 9o premio.");
            System.out.println("Ganhou " + premio9 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos3 == 3 && starsCertas3 == 0) {
            System.out.println("PARABENS! Ganhou o 10o premio.");
            System.out.println("Ganhou " + premio10 + " euros.");
            ganhoTotal = ganhoTotal + premio10;
        } else if (numsCertos3 == 1 && starsCertas3 == 2) {
            System.out.println("PARABENS! Ganhou o 11o premio.");
            System.out.println("Ganhou " + premio11 + " euros.");
            ganhoTotal = ganhoTotal + premio11;
        } else if (numsCertos3 == 2 && starsCertas3 == 1) {
            System.out.println("PARABENS! Ganhou o 12o premio.");
            System.out.println("Ganhou " + premio12 + " euros.");
            ganhoTotal = ganhoTotal + premio12;
        } else if (numsCertos3 == 2 && starsCertas3 == 0) {
            System.out.println("PARABENS! Ganhou o 13o premio.");
            System.out.println("Ganhou " + premio13 + " euros.");
            ganhoTotal = ganhoTotal + premio13;
        } else {
            System.out.println("Infelizmente nao ganhou premio");
        }
    }       //ATRIBUI PREMIO A CHAVE 3

    private static void atribuirPremio4() {
        if (numsCertos4 == 5 && starsCertas4 == 2) {                      //ATRIBUI OS PREMIOS DEPENDENDO DE QUANTOS ACERTOU
            System.out.println("PARABENS! GANHOU O 1o PREMIO!");
            System.out.printf("Ganhou " + "%.0f\n", premio1);
            System.out.println("A criar excentricos todas as semanas!");
            ganhoTotal = ganhoTotal + premio1;
        } else if (numsCertos4 == 5 && starsCertas4 == 1) {
            System.out.println("PARABENS! GANHOU O 2o PREMIO!");
            System.out.println("Ganhou " + premio2 + " euros!");
            ganhoTotal = ganhoTotal + premio2;
        } else if (numsCertos4 == 5 && starsCertas4 == 0) {
            System.out.println("PARABENS! GANHOU O 3o PREMIO!");
            System.out.println("Ganhou " + premio3 + " euros!");
            ganhoTotal = ganhoTotal + premio3;
        } else if (numsCertos4 == 4 && starsCertas4 == 2) {
            System.out.println("PARABENS! Ganhou o 4o premio!");
            System.out.println("Ganhou " + premio4 + " euros!");
            ganhoTotal = ganhoTotal + premio4;
        } else if (numsCertos4 == 4 && starsCertas4 == 1) {
            System.out.println("PARABENS! Ganhou o 5o premio!");
            System.out.println("Ganhou " + premio5 + " euros!");
            ganhoTotal = ganhoTotal + premio5;
        } else if (numsCertos4 == 3 && starsCertas4 == 2) {
            System.out.println("PARABENS! Ganhou o 6o premio!");
            System.out.println("Ganhou " + premio6 + " euros!");
            ganhoTotal = ganhoTotal + premio6;
        } else if (numsCertos4 == 4 && starsCertas4 == 0) {
            System.out.println("PARABENS! Ganhou o 7o premio!");
            System.out.println("Ganhou " + premio7 + " euros!");
            ganhoTotal = ganhoTotal + premio7;
        } else if (numsCertos4 == 2 && starsCertas4 == 2) {
            System.out.println("PARABENS! Ganhou o 8o premio.");
            System.out.println("Ganhou " + premio8 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos4 == 3 && starsCertas4 == 1) {
            System.out.println("PARABENS! Ganhou o 9o premio.");
            System.out.println("Ganhou " + premio9 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos4 == 3 && starsCertas4 == 0) {
            System.out.println("PARABENS! Ganhou o 10o premio.");
            System.out.println("Ganhou " + premio10 + " euros.");
            ganhoTotal = ganhoTotal + premio10;
        } else if (numsCertos4 == 1 && starsCertas4 == 2) {
            System.out.println("PARABENS! Ganhou o 11o premio.");
            System.out.println("Ganhou " + premio11 + " euros.");
            ganhoTotal = ganhoTotal + premio11;
        } else if (numsCertos4 == 2 && starsCertas4 == 1) {
            System.out.println("PARABENS! Ganhou o 12o premio.");
            System.out.println("Ganhou " + premio12 + " euros.");
            ganhoTotal = ganhoTotal + premio12;
        } else if (numsCertos4 == 2 && starsCertas4 == 0) {
            System.out.println("PARABENS! Ganhou o 13o premio.");
            System.out.println("Ganhou " + premio13 + " euros.");
            ganhoTotal = ganhoTotal + premio13;
        } else {
            System.out.println("Infelizmente nao ganhou premio");
        }
    }       //ATRIBUI PREMIO A CHAVE 4

    private static void atribuirPremio5() {
        if (numsCertos5 == 5 && starsCertas5 == 2) {                      //ATRIBUI OS PREMIOS DEPENDENDO DE QUANTOS ACERTOU
            System.out.println("PARABENS! GANHOU O 1o PREMIO!");
            System.out.printf("Ganhou " + "%.0f\n", premio1);
            System.out.println("A criar excentricos todas as semanas!");
            ganhoTotal = ganhoTotal + premio1;
        } else if (numsCertos5 == 5 && starsCertas5 == 1) {
            System.out.println("PARABENS! GANHOU O 2o PREMIO!");
            System.out.println("Ganhou " + premio2 + " euros!");
            ganhoTotal = ganhoTotal + premio2;
        } else if (numsCertos5 == 5 && starsCertas5 == 0) {
            System.out.println("PARABENS! GANHOU O 3o PREMIO!");
            System.out.println("Ganhou " + premio3 + " euros!");
            ganhoTotal = ganhoTotal + premio3;
        } else if (numsCertos5 == 4 && starsCertas5 == 2) {
            System.out.println("PARABENS! Ganhou o 4o premio!");
            System.out.println("Ganhou " + premio4 + " euros!");
            ganhoTotal = ganhoTotal + premio4;
        } else if (numsCertos5 == 4 && starsCertas5 == 1) {
            System.out.println("PARABENS! Ganhou o 5o premio!");
            System.out.println("Ganhou " + premio5 + " euros!");
            ganhoTotal = ganhoTotal + premio5;
        } else if (numsCertos5 == 3 && starsCertas5 == 2) {
            System.out.println("PARABENS! Ganhou o 6o premio!");
            System.out.println("Ganhou " + premio6 + " euros!");
            ganhoTotal = ganhoTotal + premio6;
        } else if (numsCertos5 == 4 && starsCertas5 == 0) {
            System.out.println("PARABENS! Ganhou o 7o premio!");
            System.out.println("Ganhou " + premio7 + " euros!");
            ganhoTotal = ganhoTotal + premio7;
        } else if (numsCertos5 == 2 && starsCertas5 == 2) {
            System.out.println("PARABENS! Ganhou o 8o premio.");
            System.out.println("Ganhou " + premio8 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos5 == 3 && starsCertas5 == 1) {
            System.out.println("PARABENS! Ganhou o 9o premio.");
            System.out.println("Ganhou " + premio9 + " euros.");
            ganhoTotal = ganhoTotal + premio8;
        } else if (numsCertos5 == 3 && starsCertas5 == 0) {
            System.out.println("PARABENS! Ganhou o 10o premio.");
            System.out.println("Ganhou " + premio10 + " euros.");
            ganhoTotal = ganhoTotal + premio10;
        } else if (numsCertos5 == 1 && starsCertas5 == 2) {
            System.out.println("PARABENS! Ganhou o 11o premio.");
            System.out.println("Ganhou " + premio11 + " euros.");
            ganhoTotal = ganhoTotal + premio11;
        } else if (numsCertos5 == 2 && starsCertas5 == 1) {
            System.out.println("PARABENS! Ganhou o 12o premio.");
            System.out.println("Ganhou " + premio12 + " euros.");
            ganhoTotal = ganhoTotal + premio12;
        } else if (numsCertos5 == 2 && starsCertas5 == 0) {
            System.out.println("PARABENS! Ganhou o 13o premio.");
            System.out.println("Ganhou " + premio13 + " euros.");
            ganhoTotal = ganhoTotal + premio13;
        } else {
            System.out.println("Infelizmente nao ganhou premio");
        }
    }       //ATRIBUI PREMIO A CHAVE 5

    private static void registarApostaRnd() {
        int op = 1;
        while (op != 0) {
            System.out.println("------APOSTA ALEATORIA------");
            System.out.println("Quantas chaves quer apostar? (1 a 5)");
            System.out.println("(0 para voltar)");
            op = in.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    b.geraNumerosBoletim();
                    b.mostraBoletim();
                    tamBol = 1;         //regista quantas chaves apostou no boletim
                    return;
                case 2:
                    b.geraNumerosBoletim2Chaves();
                    b.mostraBoletim2Chaves();
                    tamBol = 2;
                    return;
                case 3:
                    b.geraNumerosBoletim3Chaves();
                    b.mostraBoletim3Chaves();
                    tamBol = 3;
                    return;
                case 4:
                    b.geraNumerosBoletim4Chaves();
                    b.mostraBoletim4Chaves();
                    tamBol = 4;
                    return;
                case 5:
                    b.geraNumerosBoletim5Chaves();
                    b.mostraBoletim5Chaves();
                    tamBol = 5;
                    return;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }   //REGISTA APOSTA ALEATORIA
}

