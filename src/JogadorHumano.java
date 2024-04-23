import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogadorHumano implements Jogador {
    private String nome;
    private List<Pedra> pedras = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public JogadorHumano(String nome) {
        this.nome = nome;
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        System.out.println("\nEscolha uma peça para jogar ou uma ação:");
        for (int i = 0; i < pedras.size(); i++) {
            System.out.println((i + 1) + " - " + pedras.get(i).getNome());
        }
        System.out.println((pedras.size() + 1) + " - Passar a vez");
        int choice = scanner.nextInt();
        if (choice <= pedras.size()) {
            Pedra p = pedras.get(choice - 1);
            System.out.println("Escolha um lado (1 - Esquerdo, 2 - Direito):");
            int lado = scanner.nextInt();
            boolean result = (lado == 1) ? tabuleiro.adicionarPedraEsquerda(p) : tabuleiro.adicionarPedraDireita(p);
            if (result) {
                pedras.remove(p);
                System.out.println("Pedra jogada: " + p.getNome());
            } else {
                System.out.println("Não foi possível jogar a pedra.");
            }
        } else {
            System.out.println("Passou a vez.");
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
