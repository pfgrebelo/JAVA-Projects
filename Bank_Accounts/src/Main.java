
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


// Um banco (classe principal) que armazene um conjunto de contas e
// forneça métodos que permitam que sejam feitas criações de conta,
// exclusão de contas, levantamentos (uma conta corrente só pode fazer
// levantamentos desde que o valor não exceda o limite de saldo),
// depósitos, emissão de saldo e extrato e transferência entre contas.
public class Main {

    static List<Conta> listaContas;

    static Scanner in = new Scanner(System.in);
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {

        //Vai buscar data/hora local
       /* SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));*/

        listaContas = new ArrayList<>();

        InicializarContas();

        int op = 1;
        while (op != 0) {
            System.out.println("1-Criar conta");
            System.out.println("2-Eliminar conta");
            System.out.println("3-Levantamento");
            System.out.println("4-Deposito");
            System.out.println("5-Ver Saldo");
            System.out.println("6-Ver Extrato");
            System.out.println("7-Transferencia");
            System.out.println("8-Ver Contas");
            System.out.println("9-Ver Conta");
            System.out.println("0-Sair");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    CriarConta();
                    break;
                case 2:
                    EliminarConta();
                    break;
                case 3:
                    Levantamento();
                    break;
                case 4:
                    Deposito();
                    break;
                case 5:
                    VerSaldo();
                    break;
                case 6:
                    VerExtrato();
                    break;
                case 7:
                    Transferencia();
                    break;
                case 8:
                    VerContas();
                    break;
                case 9:
                    VerConta();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void VerConta() {
        System.out.println("------------------------------------");
        System.out.println("Qual o numero da conta que quer ver?");
        in = new Scanner(System.in);
        int numero = in.nextInt();

        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                System.out.println(listaContas.get(i));
                return;
            }
        }
        System.out.println("Conta inexistente");

        System.out.println("------------------------------------");
    }

    private static void VerContas() {
        System.out.println("------------------------------------");
        for (int i = 0; i < listaContas.size(); i++) {
            System.out.println(listaContas.get(i));
        }
        System.out.println("------------------------------------");
    }

    private static void InicializarContas() {
        listaContas.add(new Conta(1, 100, "Especial"));
        listaContas.add(new Conta(2, 0, "Normal"));
        listaContas.add(new Conta(3, 50, 50, "Especial", new ArrayList<>()));
        listaContas.add(new Conta(4, 0, "Especial"));

        listaContas.get(0).getListaMovimentos().add(new Movimento("Pagamento", "18/07 10:00", "Debito", 50));
        listaContas.get(0).getListaMovimentos().add(new Movimento("Salario", "19/07 12:00", "Credito", 150));
        listaContas.get(1).getListaMovimentos().add(new Movimento("Pagamento", "18/07 10:00", "Debito", 50));
        listaContas.get(2).getListaMovimentos().add(new Movimento("Pagamento", "18/07 10:00", "Debito", 60));
        listaContas.get(2).getListaMovimentos().add(new Movimento("Pagamento", "18/07 11:00", "Debito", 50));
    }

    private static void EliminarConta() {
        System.out.println("Qual o numero da conta a eliminar?");
        in = new Scanner(System.in);
        int numero = in.nextInt();

        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                listaContas.remove(i);
                System.out.println("Conta removida com sucesso");
                return;
            }
        }
        System.out.println("Conta inexistente");
    }

    private static void Levantamento() {
        System.out.println("Qual a conta onde deseja fazer o levantamento?");
        in = new Scanner(System.in);
        int numero = in.nextInt();
        Date date = new Date();
        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                System.out.println("Qual o valor a levantar?");
                in = new Scanner(System.in);
                double valor = in.nextDouble();
                double saldo = listaContas.get(i).getSaldo();
                if (valor > saldo) {
                    System.out.println("Nao tem saldo suficiente");
                } else {
                    listaContas.get(i).getListaMovimentos().add(new Movimento("Levantamento", (formatter.format(date)), "Debito", valor));
                    listaContas.get(i).setSaldo(saldo - valor);
                    System.out.println("Valor levantado com sucesso");
                }
                return;
            }
        }
        System.out.println("Conta inexistente");
    }

    private static void Deposito() {
        System.out.println("Qual a conta onde deseja fazer o deposito?");
        in = new Scanner(System.in);
        int numero = in.nextInt();
        Date date = new Date();

        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                System.out.println("Qual o valor a depositar?");
                in = new Scanner(System.in);
                double valor = in.nextDouble();

                if (valor > 0) {
                    listaContas.get(i).getListaMovimentos().add(new Movimento("Deposito", (formatter.format(date)), "Credito", valor));
                    double saldo = listaContas.get(i).getSaldo();
                    listaContas.get(i).setSaldo(saldo + valor);
                    System.out.println("Deposito realizado com sucesso. Novo saldo: " + listaContas.get(i).getSaldo() + "Eur");
                } else {
                    System.out.println("Valor Invalido");
                }
                return;
            }
        }
        System.out.println("Conta inexistente");
    }

    private static void VerSaldo() {
        System.out.println("Qual a conta que deseja ver o saldo?");
        in = new Scanner(System.in);
        int numero = in.nextInt();

        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                System.out.println("O saldo da conta " + (i + 1) + " e " + listaContas.get(i).getSaldo() + "Eur");
                System.out.println("------------------------------");
                return;
            }
        }
        System.out.println("Conta inexistente");
    }

    private static void VerExtrato() {
        System.out.println("Qual a conta que deseja ver o extrato?");
        in = new Scanner(System.in);
        int numero = in.nextInt();

        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                System.out.println("O seu extrato e:");
                for (int j = 0; j < listaContas.get(i).getListaMovimentos().size(); j++) {

                    System.out.println(listaContas.get(i).getListaMovimentos().get(j));

                }
                System.out.println("------------------");
                return;
            }
        }
        System.out.println("Conta inexistente");
    }

    private static void Transferencia() {

        System.out.println("De que conta vai fazer a transferencia?");
        in = new Scanner(System.in);
        int numero = in.nextInt();
        Date date = new Date();
        double valor;
        for (int i = 0; i < listaContas.size(); i++) {
            if (numero == listaContas.get(i).getNumero()) {
                System.out.println("Qual o valor a transferir?");
                in = new Scanner(System.in);
                valor = in.nextDouble();
                double saldo = listaContas.get(i).getSaldo();
                if (valor > saldo) {
                    System.out.println("Nao tem saldo suficiente");
                    return;
                } else {
                    System.out.println("Conta de destino:");
                    in = new Scanner(System.in);
                    int numeroD = in.nextInt();
                    for (int j = 0; j < listaContas.size(); j++) {
                        if (numeroD == listaContas.get(j).getNumero()) {
                            listaContas.get(i).getListaMovimentos().add(new Movimento("Transferencia", (formatter.format(date)), "Debito", valor));
                            listaContas.get(i).setSaldo(saldo - valor);
                            listaContas.get(j).getListaMovimentos().add(new Movimento("Transferencia", (formatter.format(date)), "Credito", valor));
                            saldo = listaContas.get(j).getSaldo();
                            listaContas.get(j).setSaldo(saldo + valor);
                            System.out.println("Transferencia efetuada com sucesso");
                            return;
                        }
                    }
                    System.out.println("Conta destino inexistente");
                    return;
                }
            }
        }
        System.out.println("Conta origem inexistente");
    }

    private static void CriarConta() {
        in = new Scanner(System.in);

        System.out.println("Qual o numero da conta?");
        int numero = in.nextInt();

        System.out.println("Qual o limite da conta");
        double limite = in.nextDouble();

        in = new Scanner(System.in);

        System.out.println("Qual o tipo de conta?");
        String tipo = in.nextLine();

        listaContas.add(new Conta(numero, limite, tipo));
        System.out.println("Conta criada com sucesso");
    }
}