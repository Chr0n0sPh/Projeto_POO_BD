package Models;

public class Setor {
    private int idSetor;
    private String nomeSetor;
    private String criticidade;

    public Setor(int idSetor, String nomeSetor, String criticidade) {
        this.idSetor = idSetor;
        this.nomeSetor = nomeSetor;
        this.criticidade = criticidade;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public String getCriticidade() {
        return criticidade;
    }

}
