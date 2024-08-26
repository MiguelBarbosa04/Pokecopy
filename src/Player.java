import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import PokemonPackage.Pokemon;

public class Player {
    private String nome;
    private String[] equipa;

    public Player(String nome, String equipa[]) {
        this.nome = nome;
        this.equipa = new String[6];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player: ").append(nome).append("\nEquipa: ");
        for (String pokemon : equipa) {
            if (pokemon != null) {
                sb.append(pokemon).append(" ");
            }
        }
        return sb.toString();
    }

    public void escolherEquipa() {
        Scanner scanner = new Scanner(System.in);
        List<String> pokemonsDisponiveis = new ArrayList<>();
        System.out.println("-------------");
        for (Pokemon pokemon : Pokemon.getTodosPokemons()) {
            pokemonsDisponiveis.add(pokemon.getNome());
            System.out.println(pokemon.getNome());
        }
        System.out.println("-------------");

        System.out.println("Escolha 6 Pokémon para a equipa de " + nome + ":");

        int i = 0;
        while (i < 6) {
            System.out.print("Escolha o Pokémon " + (i + 1) + ": ");
            String pokemonEscolhido = scanner.nextLine();

            if (pokemonsDisponiveis.contains(pokemonEscolhido)) {
                equipa[i] = pokemonEscolhido;
                pokemonsDisponiveis.remove(pokemonEscolhido);
                i++;
            } else {
                System.out.println("Pokémon não encontrado. Tente novamente.");
            }
        }

        equipa.toString();

    }
}
