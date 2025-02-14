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

        do {

            Pokemon pokemonLutar = escolherPokemon(primeiroEscolher);
            Pokemon pokemonLutar2 = escolherPokemon(segundoEscolher);

            while (pokemonLutar.getVida() > 0 && pokemonLutar2.getVida() > 0) {
                System.out.println("É o seu turno " + primeiroEscolher.getNome());

                executarTurno(pokemonLutar, pokemonLutar2);

            }
        } while (primeiroEscolher.getEquipa() != null && segundoEscolher.getEquipa() != null);

        if (primeiroEscolher.getEquipa() == null) {
            System.out.println("Parabéns " + primeiroEscolher.getNome() + " ganhou o combate");
        } else {
            System.out.println("Parabéns " + segundoEscolher.getNome() + " ganhou o combate");

        }

    }

    public void executarTurno(Pokemon pokemon1, Pokemon pokemon2) {
        int acao = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual é a sua ação? ");
        System.out.println("--> 1 - ATACAR <--");
    
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
                if (pokemon1.getTecnicas() == null) {
                    System.out.println("Erro: O Pokémon " + pokemon1.getNome() + " não tem técnicas atribuídas.");
                    return;
                }
    
                System.out.println("Escolha um ataque: ");
                for (int i = 0; i < pokemon1.getTecnicas().length; i++) {
                    if (pokemon1.getTecnicas()[i] != null) {
                        System.out.println((i + 1) + ". " + pokemon1.getTecnicas()[i].getNome());
                    } else {
                        System.out.println((i + 1) + ". [Vazio]");
                    }
                }
    
                int escolhaTecnica = scanner.nextInt();
                
                if (escolhaTecnica < 1 || escolhaTecnica > pokemon1.getTecnicas().length || pokemon1.getTecnicas()[escolhaTecnica - 1] == null) {
                    System.out.println("Erro: Escolha inválida.");
                    return;
                }
    
                Tecnicas tecnicaEscolhida = pokemon1.getTecnicas()[escolhaTecnica - 1];
    
                if (tecnicaEscolhida == null) {
                    System.out.println("Erro: Nenhuma técnica foi escolhida.");
                    return;
                }
    
                usarTecnica(tecnicaEscolhida, pokemon1, pokemon2);
                break;
    
            default:
                System.out.println("Escolher uma opção inválida!");
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
