import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/*A “Anabela de Malhadas” queria acertar o valor do peso do saco, mas confundiu-se!
No "Jogo do Saco", programa da Rádio Brigantia, em Bragança, apresentado pelo locutor
Sidónio Costa, era, diariamente, pedido aos ouvintes que acertassem o peso de um saco
com alguma coisa dentro. Em cada programa era dada aos ouvintes uma margem de 150g
(ex.: entre 4,200kg e 4,350kg) para acertarem no peso do saco.
Vídeo: https://www.youtube.com/watch?v=hIrRNFa8OiA
Faça uma aplicação que permita aos ouvintes jogar no “Jogo do Saco”.
Implemente as seguintes opções:
1. Criar, editar e eliminar ouvintes.
2. Ver dados de um ouvinte.
3. Ver ranking de ouvintes (número de vezes que jogaram e número de vezes que acertaram).
4. Jogar.
Em cada jogo devem ser selecionados de forma aleatória quais os ouvintes*/

public class Main {

    static List<Ouvintes> listaOuvintes;
    static int idOuvinte = 6;
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        listaOuvintes = new ArrayList<>();

        IniciarOuvintes();

        int op = 1;
        while (op != 0) {
            System.out.println("1 - Ver todos ouvintes");
            System.out.println("2 - Ranking");
            System.out.println("3 - Adicionar ouvinte");
            System.out.println("4 - Editar ouvinte");
            System.out.println("5 - Eliminar ouvinte");
            System.out.println("6 - Ver dados de um ouvinte");
            System.out.println("7 - Jogar");
            System.out.println("0 - Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    VerOuvintes();
                    break;
                case 2:
                    Ranking();
                    break;
                case 3:
                    AddOuvinte();
                    break;
                case 4:
                    EditOuvinte();
                    break;
                case 5:
                    DeleteOuvinte();
                    break;
                case 6:
                    VerOuvinte();
                    break;
                case 7:
                    Jogo();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }

    private static void Jogo() {
        System.out.println("---JOGO---");
        System.out.println("Define o limite minimo");
        in = new Scanner(System.in);
        double limMin = in.nextDouble();                     //locutor define o limite minimo
        double limMax = limMin + 0.150;                     //limite maximo é definido com a soma de 0,150 para dar a margem de 150gramas
        limMax = Math.round(limMax * 1000) / 1000.00d;      //arredonda para 3 casas decimais
        double peso = (Math.random() * (limMax - limMin)) + limMin;     //aqui define o peso certo do saco
        peso = Math.round(peso * 1000) / 1000.00d;          //arredonda o peso do saco com 3 casas decimais

        System.out.println("Minimo: " + limMin);
        System.out.println("Maximo: " + limMax);

        System.out.println("-------------");
        System.out.println("Jogador 1");
        int id1 = rnd.nextInt(1, listaOuvintes.size() + 1);       //escolhe um jogador aleatorio

        double palpite1 = 0;
        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (id1 == listaOuvintes.get(i).getId()) {
                System.out.println(listaOuvintes.get(i));
                listaOuvintes.get(i).setJogadas(listaOuvintes.get(i).getJogadas() + 1);   //adiciona 1 jogada ao jogador escolhido
                System.out.println("Qual o seu palpite?");
                palpite1 = in.nextDouble();
                while (palpite1 < limMin || palpite1 > limMax) {        //verifica se utilizador está a dar um palpite entre o limite maximo e minimo
                    System.out.println("Valor errado. Tem de ser entre "+limMin+" e "+limMax+"! OH Anabela, voce mata-me!!! xD");
                    System.out.println("Qual o seu palpite?");
                    palpite1 = in.nextDouble();
                }
                continue;
            }
        }
        System.out.println("-------------");
        System.out.println("Jogador 2");
        int id2 = rnd.nextInt(1, listaOuvintes.size() + 1);       //escolhe o segundo jogador aleatorio
        while (id2 == id1) {                                 //se o segundo jogador for igual ao primeiro, o programa escolhe outro jogador
            id2 = rnd.nextInt(1, listaOuvintes.size() + 1);
            continue;
        }
        double palpite2 = 0;
        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (id2 == listaOuvintes.get(i).getId()) {
                System.out.println(listaOuvintes.get(i));
                listaOuvintes.get(i).setJogadas(listaOuvintes.get(i).getJogadas() + 1);
                System.out.println("Qual o seu palpite?");
                palpite2 = in.nextDouble();
                while (palpite2 == palpite1) {              //verifica se o jogador 2 está a dar um palpite igual ao jogador 1
                    System.out.println("O valor nao pode ser igual ao jogador 1. (" + palpite1 + ")");
                    System.out.println("Introduza um novo valor:");
                    palpite2 = in.nextDouble();
                    while (palpite2 < limMin || palpite2 > limMax) {            //verifica se utilizador está a dar um palpite entre o limite maximo e minimo
                        System.out.println("Valor errado. Tem de ser entre "+limMin+" e "+limMax+"! OH Anabela, voce mata-me!!! xD");
                        System.out.println("Qual o seu palpite?");
                        palpite2 = in.nextDouble();
                    }
                }
                continue;
            }
        }
        System.out.println("-----------");
        System.out.println("Peso certo: " + peso);
        double dif1 = Math.abs(peso - palpite1);        //verifica a diferença entre o palpite e o peso certo
        double dif2 = Math.abs(peso - palpite2);
        dif1 = Math.round(dif1 * 1000) / 1000.00d;
        dif2 = Math.round(dif2 * 1000) / 1000.00d;
        System.out.println("Diferencas---");
        System.out.println("Jogador 1: " + dif1);
        System.out.println("Jogador 2: " + dif2);
        if (dif1 < dif2) {                          //determina se a diferença do palpite do jogador 1 for inferior, dá a vitoria ao jogador 1
            System.out.println("Jogador 1 Ganhou!!!");
            for (int i = 0; i < listaOuvintes.size(); i++) {
                if (id1 == listaOuvintes.get(i).getId()) {
                    listaOuvintes.get(i).setVitorias(listaOuvintes.get(i).getVitorias() + 1);       //adiciona a vitoria ao jogador 1
                }
            }
        } else if (dif2 < dif1) {               //determina se a diferença do palpite do jogador 2 for inferior, dá a vitoria ao jogador 2
            System.out.println("Jogador 2 Ganhou!!!");
            for (int i = 0; i < listaOuvintes.size(); i++) {
                if (id2 == listaOuvintes.get(i).getId()) {
                    listaOuvintes.get(i).setVitorias(listaOuvintes.get(i).getVitorias() + 1);       //adiciona a vitoria ao jogador 2
                }
            }
        } else {      //caso haja empate, o jogo acaba sem vitorioso
            System.out.println("Houve um empate!!!");
        }
    }

    private static void VerOuvinte() {
        System.out.println("---VER OUVINTE---");
        System.out.println("Qual o ouvinte a ver?");
        in = new Scanner(System.in);
        int id = in.nextInt();

        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (id == listaOuvintes.get(i).getId()) {
                System.out.println(listaOuvintes.get(i));
                return;
            }
        }
        System.out.println("------------------------");
    }

    private static void DeleteOuvinte() {
        System.out.println("---ELIMINAR OUVINTE---");
        System.out.println("Qual o ouvinte a eliminar?");
        in = new Scanner(System.in);
        int id = in.nextInt();

        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (id == listaOuvintes.get(i).getId()) {
                listaOuvintes.remove(i);
                System.out.println("Ouvinte removido com sucesso");
                return;
            }
        }
        System.out.println("Ouvinte inexistente");
    }

    private static void EditOuvinte() {
        System.out.println("---EDITAR OUVINTE---");
        System.out.println("Qual o ouvinte a editar?");
        in = new Scanner(System.in);
        int id = in.nextInt();

        for (int i = 0; i < listaOuvintes.size(); i++) {
            if (id == listaOuvintes.get(i).getId()) {
                System.out.println("Qual o novo nome do ouvinte?");
                in = new Scanner(System.in);
                String nome = in.nextLine();
                listaOuvintes.get(i).setNome(nome);
                System.out.println("Quantas jogadas?");
                in = new Scanner(System.in);
                int jogadas = in.nextInt();
                listaOuvintes.get(i).setJogadas(jogadas);
                System.out.println("Quantas vitorias?");
                in = new Scanner(System.in);
                int vitorias = in.nextInt();
                listaOuvintes.get(i).setVitorias(vitorias);
                System.out.println("Ouvinte editado com sucesso");
                return;
            }
        }
        System.out.println("Ouvinte inexistente");
    }

    private static void AddOuvinte() {
        System.out.println("---ADICIONAR OUVINTE---");
        in = new Scanner(System.in);
        int id = idOuvinte;
        System.out.println("Qual o nome do ouvinte?");
        String nome = in.nextLine();

        listaOuvintes.add(new Ouvintes(id, nome));
        System.out.println("Ouvinte criado com sucesso");
        idOuvinte++;
    }

    private static void Ranking() {
        System.out.println("---RANKING---");
        for (int i = 0; i < listaOuvintes.size(); i++) {
            listaOuvintes.sort(Comparator.comparing(Ouvintes::getVitorias).reversed());
            System.out.println("Posicao: " + (i + 1) + "o " + listaOuvintes.get(i).toString2());
        }
        System.out.println("------------------------");
    }

    private static void VerOuvintes() {
        System.out.println("---LISTA DE OUVINTES---");

        for (int i = 0; i < listaOuvintes.size(); i++) {
            System.out.println(listaOuvintes.get(i).toString());
        }
        System.out.println("------------------------");
    }

    private static void IniciarOuvintes() {
        listaOuvintes.add(new Ouvintes(1, "Pedro", 5, 5));
        listaOuvintes.add(new Ouvintes(2, "Anabela", 10, 0));
        listaOuvintes.add(new Ouvintes(3, "Joana", 0, 0));
        listaOuvintes.add(new Ouvintes(4, "Daniel", 2, 1));
        listaOuvintes.add(new Ouvintes(5, "Diogo", 8, 4));
    }
}