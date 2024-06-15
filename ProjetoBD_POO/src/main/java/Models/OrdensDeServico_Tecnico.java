package Models;

public class OrdensDeServico_Tecnico {
    private int numOS;
    private int idTecnico;
    private  int idSetor;

    public OrdensDeServico_Tecnico(int numOS, int idTecnico, int idSetor) {
        this.numOS = numOS;
        this.idTecnico = idTecnico;
        this.idSetor = idSetor;
    }

    public int getNumOS() {
        return numOS;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public int getIdSetor() {
        return idSetor;
    }
}
