package Models;

public class Tecnico {
    private int idTecnico;
    private String nome;
    private String cargo;
    private String telefone;
    private int setorIdSetor;

    public Tecnico(int idTecnico, String nome, String cargo, String telefone, int setorIdSetor) {
        this.idTecnico = idTecnico;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.setorIdSetor = setorIdSetor;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getSetorIdSetor() {
        return setorIdSetor;
    }
}
