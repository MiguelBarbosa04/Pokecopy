import java.util.Scanner;

import PokemonPackage.Pokemon;

public class Combate {

    public void escolherPokemon(Player player) {

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

        Pokemon primeiroPokemon = player.getPokemon(escolha - 1);
        System.out.println("Escolheu " + primeiroPokemon.getNome() + " para começar!");

    }

    public void lutar() {

    }

}
