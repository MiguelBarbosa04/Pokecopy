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

    }
}
