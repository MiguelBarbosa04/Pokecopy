import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

import PokemonPackage.Pokemon;

public class Player {
    private static final int TAMANHO_EQUIPA = 1;
    private String nome;
    private Pokemon[] equipa;

    public Player(String nome) {
        this.nome = nome;
        this.equipa = new Pokemon[TAMANHO_EQUIPA];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEquipa(Pokemon equipa, int index) {
        this.equipa[index] = equipa;
    }

    public Pokemon[] getEquipa() {
        return equipa;
    }

    public Pokemon getPokemon(int index) {
        return equipa[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player: ").append(nome).append("\nEquipa: ");
        for (Pokemon pokemon : equipa) {
            if (pokemon != null) {
                sb.append(pokemon.getNome()).append(" ");
            }
        }
        return sb.toString() + "\n";
    }

    public void escolherEquipa(Scanner scanner) {
 
        List<Pokemon> pokemonsDisponiveis = new ArrayList<>();
        for (Pokemon pokemon : Pokemon.getTodosPokemons()) {
            pokemonsDisponiveis.add(pokemon);
        }
 
        System.out.println("Escolha " + TAMANHO_EQUIPA + " Pokémon(s) para a equipa de " + nome + ":");
 
        int i = 0;
        while (i < TAMANHO_EQUIPA) {
 
            // mostra apenas os que ainda estão disponíveis
            System.out.println("-------------");
            for (Pokemon pokemon : pokemonsDisponiveis) {
                System.out.println(pokemon.getNome());
            }
            System.out.println("-------------");
 
            System.out.print("Escolha o Pokémon " + (i + 1) + ": ");
            String pokemonEscolhido = scanner.nextLine().trim();
 
            Pokemon encontrado = null;
            Iterator<Pokemon> it = pokemonsDisponiveis.iterator();
            while (it.hasNext()) {
                Pokemon pokemon = it.next();
                if (pokemon.getNome().equalsIgnoreCase(pokemonEscolhido)) {
                    encontrado = pokemon;
                    it.remove();
                    break;
                }
            }
 
            if (encontrado == null) {
                System.out.println("Pokémon não encontrado. Tente novamente.");
            } else {
                equipa[i] = encontrado;
                System.out.println("Adicionou " + encontrado.getNome() + " à equipa.");
                i++;
            }
        }
 
        System.out.println(this);
    }
}
