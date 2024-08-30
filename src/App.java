import java.util.Scanner;
import PokemonPackage.PokemonDemo;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        PokemonDemo pokemonDemo = new PokemonDemo();
        pokemonDemo.criarPokemons();

        System.out.println("JOGADOR 1 POR FAVOR INSIRA O SEU NICKNAME: ");
        String nomePlayer1 = scanner.nextLine();
        System.out.println("JOGADOR 2 POR FAVOR INSIRA O SEU NICKNAME: ");
        String nomePlayer2 = scanner.nextLine();

        Player player1 = new Player(nomePlayer1, args);
        Player player2 = new Player(nomePlayer2, args);

        player1.escolherEquipa();
        player2.escolherEquipa();

        JogoMoeda jogar = new JogoMoeda();

        int vencedor = jogar.jogarJogoMoeda(player1, player2);

        Player primeiroEscolher;
        Player segundoEscolher;

        if (vencedor == 0) {

            System.out.println(player1.getNome()
                    + " ganhou o jogo da moeda, deseja escolher o primeiro pokemon a entrar em combate? Por favor digite 'SIM' ou 'NAO");
            String escolha = scanner.nextLine().trim().toLowerCase();

            if (escolha.equals("sim")) {
                primeiroEscolher = player1;
                segundoEscolher = player2;
            } else {
                primeiroEscolher = player2;
                segundoEscolher = player1;
            }

        } else {
            System.out.println(player2.getNome()
                    + " ganhou o jogo da moeda, deseja escolher o primeiro pokemon a entrar em combate? Por favor digite 'SIM' ou 'NAO");
            String escolha = scanner.nextLine().trim().toLowerCase();

            if (escolha.equals("sim")) {
                primeiroEscolher = player2;
                segundoEscolher = player1;
            } else {
                primeiroEscolher = player1;
                segundoEscolher = player2;
            }
        }

        Combate combate = new Combate();
/* 
        System.out.println(primeiroEscolher.getNome() + " escolherá o primeiro Pokémon a entrar em combate.");
        combate.escolherPokemon(primeiroEscolher);

        System.out.println(segundoEscolher.getNome() + " escolherá o segundo Pokémon a entrar em combate.");
        combate.escolherPokemon(segundoEscolher);
*/
        combate.iniciarCombate(primeiroEscolher, segundoEscolher);

        scanner.close();
    }
}
