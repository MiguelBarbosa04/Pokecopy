import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class JogoMoeda {

    private int result;

    public int jogarJogoMoeda(Player player1, Player player2) {

        Random randomLado = new Random();
        result = randomLado.nextInt(2);
        Scanner scanner = new Scanner(System.in);
        String resposta;
        String resposta2;

        do {
            System.out.println("Jogador 1 escolha um lado da moeda, CARA ou COROA");
            resposta = scanner.nextLine().toLowerCase();
            System.out.println("--------------" + resposta + "-------------");
        } while (!resposta.equals("cara") && !resposta.equals("coroa"));

        if (resposta.equals("cara")) {
            resposta2 = "coroa";
        } else {
            resposta2 = "cara";
        }

        String resultadoMoeda;
        if (result == 0) {
            resultadoMoeda = "cara";
        } else {
            resultadoMoeda = "coroa";
        }

        System.out.println("O resultado do lançamento da moeda é: " + resultadoMoeda);

        if (resultadoMoeda.equals(resposta)) {
            System.out.println(
                    "Parabéns jogador 1, ganhou e pode decidir quem escolhe primeiro o pokemon a entrar no combate!");

            return 0;
        } else {
            System.out.println(
                    "Parabéns jogador 2, ganhou e pode decidir quem escolhe primeiro o pokemon a entrar no combate!");

            return 1;
        }

    }

}
