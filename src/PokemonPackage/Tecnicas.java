package PokemonPackage;

import enums.TiposEnum;

public class Tecnicas {

    private String nome;
    private int dano;
    private int probabilidadeAcerto;
    private TiposEnum[] tipo;

    public Tecnicas(String nome, int dano, int probabilidadeAcerto, TiposEnum[] tipo) {

        this.nome = nome;
        this.dano = dano;
        this.probabilidadeAcerto = probabilidadeAcerto;
        this.tipo = tipo;

    }

    public void setnome(String nome) {
        this.nome = nome;
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

    public String getNome(){
        return nome;
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
