import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogadorHumano implements Jogador {
    private String nome;
    private List<Pedra> pedras = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private List<Pedra> pedrasDisponiveisParaCompra; // Referência às pedras disponíveis para compra.

    public JogadorHumano(String nome, List<Pedra> pedrasDisponiveisParaCompra) {
        this.nome = nome;
        this.pedrasDisponiveisParaCompra = pedrasDisponiveisParaCompra;
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        System.out.println("\nEscolha uma peça para jogar ou uma ação:");
        for (int i = 0; i < pedras.size(); i++) {
            System.out.println((i + 1) + " - " + pedras.get(i).getNome());
        }
        System.out.println((pedras.size() + 1) + " - Comprar pedra");
        System.out.println((pedras.size() + 2) + " - Passar a vez");

        int choice = scanner.nextInt();
        if (choice == pedras.size() + 1) {
            if (!pedrasDisponiveisParaCompra.isEmpty()) {
                Pedra comprada = pedrasDisponiveisParaCompra.remove(0);
                pedras.add(comprada);
                System.out.println("Pedra comprada: " + comprada.getNome());
                // Tentativa de jogar a pedra imediatamente após comprar
                jogarPedra(comprada, tabuleiro);
            } else {
                System.out.println("Não há pedras disponíveis para comprar.");
            }
        } else if (choice == pedras.size() + 2) {
            System.out.println("Passou a vez.");
        } else if (choice > 0 && choice <= pedras.size()) {
            Pedra pedra = pedras.get(choice - 1);
            jogarPedra(pedra, tabuleiro);
        }
    }

    private void jogarPedra(Pedra pedra, Tabuleiro tabuleiro) {
        System.out.println("Escolha um lado (1 - Esquerdo, 2 - Direito):");
        int lado = scanner.nextInt();
        boolean result = (lado == 1) ? tabuleiro.adicionarPedraEsquerda(pedra) : tabuleiro.adicionarPedraDireita(pedra);
        if (result) {
            pedras.remove(pedra);
            System.out.println("Pedra jogada: " + pedra.getNome());
        } else {
            System.out.println("Não foi possível jogar a pedra.");
        }
    }

    @Override
    public void receberPedra(Pedra pedra) {
        pedras.add(pedra);
    }

    @Override
    public List<Pedra> getPedras() {
        return pedras;
    }

    @Override
    public String getNome() {
        return nome;
    }
}
