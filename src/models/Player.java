package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private static final int TAMANHO_EQUIPA = 6;
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

        boolean primeiro = true;
        for (Pokemon pokemon : equipa) {
            if (pokemon == null) {
                continue;
            }
            if (!primeiro) {
                sb.append(", ");
            }
            sb.append(pokemon.getNome());
            primeiro = false;
        }
        return sb.toString();
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
            for (int n = 0; n < pokemonsDisponiveis.size(); n++) {
                System.out.println((n + 1) + ". " + pokemonsDisponiveis.get(n).getNome());
            }
            System.out.println("-------------");

            System.out.print("Escolha o Pokémon " + (i + 1) + " (número ou nome): ");
            String entrada = scanner.nextLine().trim();

            Pokemon encontrado = procurarPokemon(pokemonsDisponiveis, entrada);

            if (encontrado == null) {
                System.out.println("Pokémon não encontrado. Tente novamente.");
            } else {
                pokemonsDisponiveis.remove(encontrado);
                equipa[i] = encontrado;
                System.out.println("Adicionou " + encontrado.getNome() + " à equipa.");
                i++;
            }
        }

        System.out.println(this);
    }

    // Procura por número (posição na lista mostrada) ou por nome.

    private Pokemon procurarPokemon(List<Pokemon> disponiveis, String entrada) {

        // Tenta como número
        try {
            int numero = Integer.parseInt(entrada);
            if (numero >= 1 && numero <= disponiveis.size()) {
                return disponiveis.get(numero - 1);
            }
            return null;
        } catch (NumberFormatException e) {
            // não é número, continua para o nome
        }

        // Ttenta como nome
        for (Pokemon pokemon : disponiveis) {
            if (pokemon.getNome().equalsIgnoreCase(entrada)) {
                return pokemon;
            }
        }
        return null;
    }
}
