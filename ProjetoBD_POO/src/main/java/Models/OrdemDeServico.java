package Models;

public class OrdemDeServico {
    private int numOS;
    private String dataAbertura;
    private String dataFechamento;
    private String descricaoOS;
    private String setorDeOrigem;
    private String nomeDoTecnico;

    public OrdemDeServico(int numOS, String dataAbertura, String dataFechamento, String descricaoOS, String setorDeOrigem, String nomeDoTecnico) {
        this.numOS = numOS;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.descricaoOS = descricaoOS;
        this.setorDeOrigem = setorDeOrigem;
        this.nomeDoTecnico = nomeDoTecnico;
    }

    public int getNumOS() {
        return numOS;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public String getDescricaoOS() {
        return descricaoOS;
    }

    public String getSetorDeOrigem() {
        return setorDeOrigem;
    }

    public String getNomeDoTecnico() {
        return nomeDoTecnico;
    }
}
