import java.util.Scanner;

import PokemonPackage.Pokemon;
import PokemonPackage.Tecnicas;
import enums.TiposEnum;

public class Combate {

    private final Scanner scanner;

    // Para usar o mesmo Scanner do main
    public Combate(Scanner scanner) {
        this.scanner = scanner;
    }

    private int lerOpcao(int min, int max) {
        while (true) {
            String linha = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(linha);
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
            }
            System.out.println("Tem de escolher um número entre " + min + " e " + max + ".");
        }
    }

    private boolean estaVivo(Pokemon p) {
        return p != null && p.getVida() > 0;
    }

    private boolean temPokemonVivo(Player p) {
        for (Pokemon pk : p.getEquipa()) {
            if (estaVivo(pk)) {
                return true;
            }
        }
        return false;
    }

    public Pokemon escolherPokemon(Player player) {

        System.out.println(player.getNome() + ", escolha o seu pokemon! ");

        for (int i = 0; i < player.getEquipa().length; i++) {
            Pokemon pk = player.getPokemon(i);
            String estado = estaVivo(pk) ? "" : "  [DESMAIADO]";
            System.out.println((i + 1) + "." + pk + estado);
        }

        Pokemon pokemonEscolhido;
        do {
            int escolha = lerOpcao(1, player.getEquipa().length);
            pokemonEscolhido = player.getPokemon(escolha - 1);

            if (!estaVivo(pokemonEscolhido)) {
                System.out.println("Esse Pokémon não pode lutar. Escolha outro.");
                pokemonEscolhido = null;
            }
        } while (pokemonEscolhido == null);

        System.out.println("Escolheu " + pokemonEscolhido.getNome());
        return pokemonEscolhido;
    }

    public void iniciarCombate(Player p1, Player p2) {

        Pokemon lutador1 = escolherPokemon(p1);
        Pokemon lutador2 = escolherPokemon(p2);

        while (temPokemonVivo(p1) && temPokemonVivo(p2)) {

            // cada jogador escolhe o seu ataque
            System.out.println("\nÉ o turno de " + p1.getNome());
            Tecnicas t1 = escolherTecnica(lutador1);

            System.out.println("\nÉ o turno de " + p2.getNome());
            Tecnicas t2 = escolherTecnica(lutador2);

            System.out.println();
            executarRonda(lutador1, t1, lutador2, t2);

            // só troca quem perdeu o Pokémon
            if (!estaVivo(lutador1) && temPokemonVivo(p1)) {
                System.out.println("\n" + lutador1.getNome() + " desmaiou!");
                lutador1 = escolherPokemon(p1);
            }
            if (!estaVivo(lutador2) && temPokemonVivo(p2)) {
                System.out.println("\n" + lutador2.getNome() + " desmaiou!");
                lutador2 = escolherPokemon(p2);
            }
        }

        Player vencedor = temPokemonVivo(p1) ? p1 : p2;
        System.out.println("\nParabéns " + vencedor.getNome() + " ganhou o combate!");
    }

    // Mostra as técnicas do Pokémon e devolve a escolhida
    private Tecnicas escolherTecnica(Pokemon pokemon) {

        Tecnicas[] tecnicas = pokemon.getTecnicas();

        boolean temTecnica = false;
        if (tecnicas != null) {
            for (Tecnicas t : tecnicas) {
                if (t != null) {
                    temTecnica = true;
                    break;
                }
            }
        }

        if (!temTecnica) {
            System.out.println("O Pokémon " + pokemon.getNome() + " não tem técnicas atribuídas.");
            return null;
        }

        System.out.println(pokemon.getNome() + " - escolha um ataque: ");
        for (int i = 0; i < tecnicas.length; i++) {
            if (tecnicas[i] != null) {
                System.out.println((i + 1) + ". " + tecnicas[i].getNome());
            } else {
                System.out.println((i + 1) + ". [Vazio]");
            }
        }

        Tecnicas escolhida = null;
        do {
            int escolha = lerOpcao(1, tecnicas.length);
            escolhida = tecnicas[escolha - 1];

            if (escolhida == null) {
                System.out.println("Esse espaço está vazio. Escolha outro ataque.");
            }
        } while (escolhida == null);

        return escolhida;
    }

    // A velocidade decide quem ataca primeiro
    private void executarRonda(Pokemon a, Tecnicas ta, Pokemon b, Tecnicas tb) {
        if (a.getVelocidade() >= b.getVelocidade()) {
            atacar(a, ta, b);
            if (estaVivo(b)) {
                atacar(b, tb, a);
            }
        } else {
            atacar(b, tb, a);
            if (estaVivo(a)) {
                atacar(a, ta, b);
            }
        }
    }

    private void atacar(Pokemon atacante, Tecnicas tecnica, Pokemon defensor) {

        if (tecnica == null) {
            System.out.println(atacante.getNome() + " não pôde atacar.");
            return;
        }

        int dano = Math.max(1, atacante.getAtaque() * tecnica.getDano() / Math.max(1, defensor.getDefesa()));

        boolean vantagemTecnica = false;

        for (int i = 0; i < defensor.getFraqueza().length; i++) {
            for (int j = 0; j < tecnica.getTipo().length; j++) {
                if (defensor.getFraqueza()[i] == tecnica.getTipo()[j]) {
                    dano *= 1.5;
                    vantagemTecnica = true;
                }
            }
        }

        defensor.receberDano(dano);

        System.out.println(atacante.getNome() + " usou " + tecnica.getNome()
                + " e causou " + dano + " de dano a " + defensor.getNome() + "!");

        if (vantagemTecnica) {
            System.out.println("É super eficaz!");
        }

        System.out.println(defensor.getNome() + " agora tem " + defensor.getVida());

    }

}