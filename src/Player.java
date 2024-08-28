import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PokemonPackage.Pokemon;

public class Player {
    private String nome;
    private Pokemon[] equipa;

    public Player(String nome, String equipa[]) {
        this.nome = nome;
        this.equipa = new Pokemon[1];
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
        return sb.toString();
    }

    public void escolherEquipa() {
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemonsDisponiveis = new ArrayList<>();
        System.out.println("-------------");
        for (Pokemon pokemon : Pokemon.getTodosPokemons()) {
            pokemonsDisponiveis.add(pokemon);
            System.out.println(pokemon.getNome());
        }
        System.out.println("-------------");

        System.out.println("Escolha 6 Pokémons para a equipa de " + nome + ":");

        int i = 0;
        while (i < equipa.length) {
            System.out.print("Escolha o Pokémon " + (i + 1) + ": ");
            String pokemonEscolhido = scanner.nextLine();

            boolean pokemonEncontrado = false;

            for (Pokemon pokemon : pokemonsDisponiveis) {
                if (pokemon.getNome().equals(pokemonEscolhido)) {
                    equipa[i] = pokemon;
                    pokemonsDisponiveis.remove(pokemon);
                    i++;
                    System.out.println(pokemon.getNome());

                    pokemonEncontrado = true;
                    break;

                }

            }

            if (!pokemonEncontrado) {
                System.out.println("Pokémon não encontrado. Tente novamente.");
            }

        }

        equipa.toString();

    }
}
