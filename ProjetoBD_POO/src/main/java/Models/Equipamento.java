package Models;

public class Equipamento {
    private String numDeSerie;
    private String tipoDeEquipamento;
    private String fabricante;
    private String estado;
    private int setor_idSetor;

    public Equipamento(String numDeSerie, String tipoDeEquipamento, String fabricante, String estado, int setor_idSetor) {
        this.numDeSerie = numDeSerie;
        this.tipoDeEquipamento = tipoDeEquipamento;
        this.fabricante = fabricante;
        this.estado = estado;
        this.setor_idSetor = setor_idSetor;
    }

    public String getNumDeSerie() {
        return numDeSerie;
    }

    public String getTipoDeEquipamento() {
        return tipoDeEquipamento;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getEstado() {
        return estado;
    }

    public int getSetor_idSetor() {
        return setor_idSetor;
    }
}
