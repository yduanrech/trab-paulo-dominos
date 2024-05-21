import game.Jogo;

public class Main {
    public static void main(String[] args) {
        // System.out.println("--------------- DOMINÓ ---------------");
        System.out.println();
        System.out.println("▀███▀▀▀██▄    ▄▄█▀▀██▄ ▀████▄     ▄███▀████▀███▄   ▀███▀ ▄▄█▀▀██▄ ");
        System.out.println(" ██    ▀██▄ ██▀    ▀██▄ ████    ████   ██   ███▄    █ ▄██▀    ▀██▄");
        System.out.println(" ██     ▀██ █▀      ▀██ █ ██   ▄█ ██   ██   █ ███   █ ██▀      ▀██");
        System.out.println(" ██      ██ █        ██ █  ██  █▀ ██   ██   █  ▀██▄ █ ██        ██");
        System.out.println(" ██     ▄██ █▄      ▄██ █  ██▄█▀  ██   ██   █   ▀██▄█ ██▄      ▄██");
        System.out.println(" ██    ▄██▀ ██▄    ▄██▀ █  ▀██▀   ██   ██   █     ███ ▀██▄    ▄██▀");
        System.out.println("▄████████▀    ▀▀████▀▀ ▄███▄ ▀▀  ▄████▄████▄███▄    ██   ▀▀████▀▀ ");

        Jogo jogo = new Jogo(); // Cria uma nova instância do Jogo
        jogo.iniciarPartida(); // Inicia a partida
    }
}
