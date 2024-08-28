package PokemonPackage;

import enums.TiposEnum;

public class Tecnicas {

    private int dano;
    private int probabilidadeAcerto;
    private TiposEnum[] tipo;

    public Tecnicas(int dano, int probabilidadeAcerto, TiposEnum[] tipo) {

        this.dano = dano;
        this.probabilidadeAcerto = probabilidadeAcerto;
        this.tipo = tipo;

    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public void setProbabilidadeAcerto(int probabilidadeAcerto) {
        this.probabilidadeAcerto = probabilidadeAcerto;

    }

    
    public void setTipo(TiposEnum[] tipo) {
        this.tipo = tipo;
    }

    public int getDano() {
        return dano;
    }

    public int getProbabilidadeAcerto() {
        return probabilidadeAcerto;
    }

    public TiposEnum[] getTipo() {
        return tipo;
    }

}
