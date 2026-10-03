package coinGame;
import java.util.Random;
import java.util.Scanner;

import models.Player;

public class JogoMoeda {

    private final Scanner scanner;
    private final Random random = new Random();

    public JogoMoeda(Scanner scanner) {
        this.scanner = scanner;
    }

    public Player jogar(Player player1, Player player2) {

        String escolha;
        do {
            System.out.println(player1.getNome() + ", escolha um lado da moeda: CARA ou COROA");
            escolha = scanner.nextLine().trim().toLowerCase();
        } while (!escolha.equals("cara") && !escolha.equals("coroa"));

        String resultado = random.nextBoolean() ? "cara" : "coroa";
        System.out.println("O resultado do lançamento da moeda é: " + resultado);

        Player vencedor = resultado.equals(escolha) ? player1 : player2;
        System.out.println("Parabéns " + vencedor.getNome()
                + ", ganhou e pode decidir quem escolhe primeiro o pokemon a entrar no combate!");

        return vencedor;
    }
}