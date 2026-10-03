package PokemonPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enums.TiposEnum;

public class Pokemon {
    private String nome;
    private TiposEnum[] tipo;
    private TiposEnum[] fraqueza;
    private TiposEnum[] resistencia;
    private TiposEnum[] imunidade;
    private int ataque;
    private int defesa;
    private int vida;
    private int velocidade;
    private Tecnicas[] tecnicas;

    private int vidaMaxima;

    private static List<Pokemon> todosPokemons = new ArrayList<>();

    public Pokemon(String nome, TiposEnum[] tipo, TiposEnum[] fraqueza, TiposEnum[] resistencia, TiposEnum[] imunidade,
            int ataque, int defesa, int vida, int velocidade, Tecnicas[] tecnicas) {

        this.nome = nome;
        this.tipo = tipo;
        this.fraqueza = fraqueza;
        this.resistencia = resistencia;
        this.imunidade = imunidade;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.vidaMaxima = vida;

        if (tecnicas.length != 2) {
            throw new IllegalArgumentException("Um Pokémon deve ter exatamente 2 técnicas!");
        }
        this.tecnicas = Arrays.copyOf(tecnicas, 2);

        todosPokemons.add(this);
    }

    public static List<Pokemon> getTodosPokemons() {
        return todosPokemons;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(TiposEnum[] tipo) {
        this.tipo = tipo;
    }

    public void setFraqueza(TiposEnum[] fraqueza) {
        this.fraqueza = fraqueza;
    }

    public void setResistencia(TiposEnum[] resistencia) {
        this.resistencia = resistencia;
    }

    public void setImunidade(TiposEnum[] imunidade) {
        this.imunidade = imunidade;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setTecnicas(Tecnicas[] tecnicas) {
        this.tecnicas = tecnicas;
    }

    public String getNome() {
        return nome;
    }

    public TiposEnum[] getTipo() {
        return tipo;
    }

    public TiposEnum[] getFraqueza() {
        return fraqueza;
    }

    public TiposEnum[] getResistencia() {
        return resistencia;
    }

    public TiposEnum[] getImunidade() {
        return imunidade;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVida() {
        return vida;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public Tecnicas[] getTecnicas() {
        return Arrays.copyOf(tecnicas, 2);
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    @Override
    public String toString() {
        return "Pokemon {nome = '" + nome + "', tipo = " + Arrays.toString(tipo) + "', fraqueza = "
                + Arrays.toString(fraqueza) + "', resistencia = " + Arrays.toString(resistencia) + "', imunidade = "
                + Arrays.toString(imunidade) + "', ataque = " + ataque + "', defesa = " + defesa + "', vida= " + vida
                + "}";
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }

    }

}
