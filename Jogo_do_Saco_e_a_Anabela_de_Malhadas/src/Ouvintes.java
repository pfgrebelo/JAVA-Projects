public class Ouvintes {
    private int id;
    private String nome;
    private int jogadas;
    private int vitorias;

    public Ouvintes() {
        id = 0;
        nome = "";
        jogadas = 0;
        vitorias = 0;
    }

    public Ouvintes(int id, String nome, int jogadas, int vitorias) {
        this.id = id;
        this.nome = nome;
        this.jogadas = jogadas;
        this.vitorias = vitorias;
    }

    public Ouvintes(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Ouvintes(String nome, int jogadas, int vitorias) {
        this.nome = nome;
        this.jogadas = jogadas;
        this.vitorias = vitorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getJogadas() {
        return jogadas;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\t Nome: " + nome + "\t\tJogadas: " + jogadas + "\t\tVitorias: " + vitorias;
    }

    public String toString2() {
        return "Nome: " + nome + " com " + vitorias + " vitorias em " + jogadas + " jogadas.";
    }
}
