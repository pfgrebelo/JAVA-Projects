import java.util.ArrayList;
import java.util.List;

// Uma conta corrente que possui um número, um saldo, um estado que
// informa se ela é normal ou especial, um limite e um conjunto de movimentações.
public class Conta {
    private int numero;
    private double saldo;
    private double limite;
    private String estado;
    private List<Movimento> listaMovimentos;

    public Conta() {
        numero = 0;
        saldo = 0;
        limite = 0;
        estado = "";
        listaMovimentos = new ArrayList<>();
    }

    public Conta(int numero, double limite, String estado) {
        this.numero = numero;
        saldo = 0;
        this.limite = limite;
        this.estado = estado;
        listaMovimentos = new ArrayList<>();
    }

    public Conta(int numero, double saldo, double limite, String estado, List<Movimento> listaMovimentos) {
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
        this.estado = estado;
        this.listaMovimentos = listaMovimentos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Movimento> getListaMovimentos() {
        return listaMovimentos;
    }

    public void setListaMovimentos(List<Movimento> listaMovimentos) {
        this.listaMovimentos = listaMovimentos;
    }

    @Override
    public String toString() {
        String texto = "Conta: " + numero + "\tSaldo: " + saldo + "\tEstado: " +
                estado + " (" + limite + ")";
        if (listaMovimentos.size() == 0) {
            texto += "\nConta sem movimentos\n";
        } else {
            texto += "\n---Lista de movimentos---\n";
            for (int i = 0; i < listaMovimentos.size(); i++) {
                texto += listaMovimentos.get(i) + "\n";
            }
            texto += "-------------------------\n";
        }
        return texto;
    }
}
