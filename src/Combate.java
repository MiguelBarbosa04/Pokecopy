import java.util.Scanner;

import PokemonPackage.Pokemon;
import PokemonPackage.Tecnicas;

public class Combate {

    public Pokemon escolherPokemon(Player player) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o seu pokemon! ");

        for (int i = 0; i < player.getEquipa().length; i++) {

            System.out.println((i + 1) + "." + player.getPokemon(i));
        }

        int escolha = -1;
        do {

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Tem de escolher um número");
            }
        } while (escolha > player.getEquipa().length || escolha <= 0);

        Pokemon pokemonEscolhido = player.getPokemon(escolha - 1);
        System.out.println("Escolheu " + pokemonEscolhido.getNome());

        return pokemonEscolhido;
    }

    public void iniciarCombate(Player primeiroEscolher, Player segundoEscolher) {

        Pokemon pokemonLutar = escolherPokemon(primeiroEscolher);
        Pokemon pokemonLutar2 = escolherPokemon(segundoEscolher);

        while (pokemonLutar.getVida() > 0 && pokemonLutar2.getVida() > 0) {
            System.out.println("É o seu turno " + primeiroEscolher.getNome());
            
            executarTurno(pokemonLutar, pokemonLutar2);

        }
    }

    public void executarTurno(Pokemon pokemon1, Pokemon pokemon2) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual é a sua ação? ");
        System.out.println("--> ATACAR <--");

        int acao = -1;

        do {
            if (scanner.hasNextInt()) {
                acao = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Tem de escolher um número");
            }
        } while (acao > 2 || acao <= 0);

        switch (acao) {
            case 1:
                System.out.println("Escolha uma ataque: ");
                for (int i = 0; i < pokemon1.getTecnicas().length; i++) {
                    System.out.println((i + 1) + ". " + pokemon1.getTecnicas()[i].getNome());
                }
                int escolhaTecnica = scanner.nextInt();
                Tecnicas tecnicaEscolhida = pokemon1.getTecnicas()[escolhaTecnica - 1];
                usarTecnica(tecnicaEscolhida, pokemon1, pokemon2);

                break;

            default:
                System.out.println("Escolher uma opcao invalida!");
                break;
        }

    }

    public void usarTecnica(Tecnicas tecnicaEscolhida, Pokemon pokemon1, Pokemon pokemon2) {

        System.out.println(pokemon1.getNome() + " usou " + tecnicaEscolhida.getNome() + "!!!");

        if (pokemon1.getVelocidade() > pokemon2.getVelocidade()) {
            calcularDano(tecnicaEscolhida, pokemon1, pokemon2);

            if (pokemon2.getVida() > 0) {
                calcularDano(tecnicaEscolhida, pokemon2, pokemon1);
            }

        } else {
            calcularDano(tecnicaEscolhida, pokemon2, pokemon1);

            if (pokemon2.getVida() > 0) {
                calcularDano(tecnicaEscolhida, pokemon1, pokemon2);
            }

        }

    }

    public void calcularDano(Tecnicas tecnicaEscolhida, Pokemon atacante1, Pokemon atacante2) {

        int dano = atacante1.getAtaque() * tecnicaEscolhida.getDano() / atacante2.getDefesa();
        atacante2.receberDano(dano);

    }

}
