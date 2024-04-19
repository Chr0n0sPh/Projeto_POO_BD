package Models;

public class OrdensDeServico_Equipamentos {
    private int numOS;
    private String numDeSerie;

    public OrdensDeServico_Equipamentos(int numOS, String numDeSerie) {
        this.numOS = numOS;
        this.numDeSerie = numDeSerie;
    }

    public int getNumOS() {
        return numOS;
    }

    public String getNumDeSerie() {
        return numDeSerie;
    }
}
