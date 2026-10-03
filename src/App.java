import java.util.Scanner;
import PokemonPackage.PokemonDemo;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PokemonDemo pokemonDemo = new PokemonDemo();
        pokemonDemo.criarPokemons();

        System.out.println("JOGADOR 1 POR FAVOR INSIRA O SEU NICKNAME: ");
        String nomePlayer1 = scanner.nextLine();
        System.out.println("JOGADOR 2 POR FAVOR INSIRA O SEU NICKNAME: ");
        String nomePlayer2 = scanner.nextLine();

        Player player1 = new Player(nomePlayer1);
        Player player2 = new Player(nomePlayer2);

        player1.escolherEquipa(scanner);
        player2.escolherEquipa(scanner);

        JogoMoeda jogoMoeda = new JogoMoeda(scanner);
        Player vencedorMoeda = jogoMoeda.jogar(player1, player2);
        Player perdedorMoeda = (vencedorMoeda == player1) ? player2 : player1;

        boolean escolheOVencedor = perguntarSimNao(scanner, vencedorMoeda.getNome()
                + " ganhou o jogo da moeda, deseja escolher o primeiro pokemon a entrar em combate? "
                + "Por favor digite 'SIM' ou 'NAO'");

        Player primeiroEscolher = escolheOVencedor ? vencedorMoeda : perdedorMoeda;
        Player segundoEscolher = escolheOVencedor ? perdedorMoeda : vencedorMoeda;

        Combate combate = new Combate(scanner);
        combate.iniciarCombate(primeiroEscolher, segundoEscolher);

        scanner.close();
    }

    private static boolean perguntarSimNao(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("sim")) {
                return true;
            }
            if (resposta.equals("nao") || resposta.equals("não")) {
                return false;
            }
            System.out.println("Resposta inválida.");
        }
    }
}