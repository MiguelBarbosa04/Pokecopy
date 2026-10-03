import java.util.Scanner;

import PokemonPackage.Pokemon;
import PokemonPackage.Tecnicas;
import enums.TiposEnum;

public class Combate {

    private final Scanner scanner;
    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARELO = "\u001B[33m";
    private static final String VERMELHO = "\u001B[31m";

    private String barraVida(Pokemon p) {
        int tamanho = 20;
        int max = Math.max(1, p.getVidaMaxima());
        int vida = Math.max(0, p.getVida());
        double percentagem = (double) vida / max;

        // arredonda para cima, com 1 de vida ainda aparece 1 bloco
        int cheios = Math.min(tamanho, (int) Math.ceil(percentagem * tamanho));

        String cor = percentagem > 0.5 ? VERDE : percentagem > 0.2 ? AMARELO : VERMELHO;
        return cor + "█".repeat(cheios) + RESET + "░".repeat(tamanho - cheios);
    }

    private String linhaPokemon(Pokemon p) {
        return String.format(" %-12s [%s] %3d/%d",
                p.getNome(), barraVida(p), Math.max(0, p.getVida()), p.getVidaMaxima());
    }

    public void mostrarHPAdversarios(Pokemon a, Pokemon b) {
        String linha = "═".repeat(40);
        System.out.println(linha);
        System.out.println(linhaPokemon(a));
        System.out.println("\nVS\n");
        System.out.println(linhaPokemon(b));
        System.out.println(linha);
    }

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
        int ronda = 1;

        while (temPokemonVivo(p1) && temPokemonVivo(p2)) {

            System.out.println("\n──────── RONDA " + ronda++ + " ────────");
            mostrarHPAdversarios(lutador1, lutador2);

            // cada jogador escolhe o seu ataque
            System.out.println("\nÉ o turno de " + p1.getNome());
            Tecnicas t1 = escolherTecnica(lutador1);

            System.out.println("\nÉ o turno de " + p2.getNome());
            Tecnicas t2 = escolherTecnica(lutador2);

            System.out.println();
            executarRonda(lutador1, t1, lutador2, t2);

            // só troca quem perdeu o Pokémon
            if (!estaVivo(lutador1)) {
                System.out.println("\n" + lutador1.getNome() + " desmaiou!");
                if (temPokemonVivo(p1)) {
                    lutador1 = escolherPokemon(p1);
                }
            }

            if (!estaVivo(lutador2)) {
                System.out.println("\n" + lutador2.getNome() + " desmaiou!");
                if (temPokemonVivo(p2)) {
                    lutador2 = escolherPokemon(p2);
                }
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

    // Devolve true se o tipo da técnica estiver na lista (fraquezas,resistências ou
    // imunidades).
    private boolean tecnicaCorrespondeA(TiposEnum[] lista, Tecnicas tecnica) {
        if (lista == null) {
            return false;
        }
        for (TiposEnum tipoLista : lista) {
            for (TiposEnum tipoTecnica : tecnica.getTipo()) {
                if (tipoLista == tipoTecnica) {
                    return true;
                }
            }
        }
        return false;
    }

    private double calcularDanoBase(Pokemon atacante, Tecnicas tecnica, Pokemon defensor) {
        return (double) atacante.getAtaque() * tecnica.getDano() / Math.max(1, defensor.getDefesa());
    }

    private void atacar(Pokemon atacante, Tecnicas tecnica, Pokemon defensor) {

        if (tecnica == null) {
            System.out.println(atacante.getNome() + " não pôde atacar.");
            return;
        }

        boolean imune = tecnicaCorrespondeA(defensor.getImunidade(), tecnica);
        boolean superEficaz = tecnicaCorrespondeA(defensor.getFraqueza(), tecnica);
        boolean resistido = tecnicaCorrespondeA(defensor.getResistencia(), tecnica);

        double dano = calcularDanoBase(atacante, tecnica, defensor);
        if (superEficaz)
            dano *= 1.5;
        if (resistido)
            dano *= 0.5;

        int danoFinal = imune ? 0 : Math.max(1, (int) dano);
        defensor.receberDano(danoFinal);

        System.out.println(atacante.getNome() + " usou " + tecnica.getNome()
                + " e causou " + danoFinal + " de dano a " + defensor.getNome() + "!");
        mostrarEfetividade(imune, superEficaz, resistido);
        System.out.println(defensor.getNome() + " agora tem " + defensor.getVida() + " de vida.");

    }

    private void mostrarEfetividade(boolean imune, boolean superEficaz, boolean resistido) {
        if (imune) {
            System.out.println("Não teve efeito...");
            return; // imune então ignora o resto
        }
        if (superEficaz)
            System.out.println("É super eficaz!");
        if (resistido)
            System.out.println("Não é muito eficaz...");
    }
}