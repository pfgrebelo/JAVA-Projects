// Uma movimentação que possui uma descrição, um valor, uma data e hora
// e uma informação se ela é uma movimentação de crédito ou débito.

public class Movimento {
    private String descricao, dataHora, tipo;
    private double valor;

    public Movimento() {
        descricao = "";
        dataHora = "";
        tipo = "";
        valor = 0;
    }

    public Movimento(String descricao, String dataHora, String tipo, double valor) {
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return dataHora + " - " + descricao + " - " + tipo + ": " + valor+"Eur";
    }
}
