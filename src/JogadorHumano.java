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
        System.out.println("Suas pedras:");
        for (int i = 0; i < pedras.size(); i++) {
            System.out.println((i + 1) + " - " + pedras.get(i).getNome());
        }
        System.out.println();
        System.out.println((pedras.size() + 1) + " - Comprar pedra");
        System.out.println((pedras.size() + 2) + " - Passar a vez");
        System.out.println((pedras.size() + 3) + " - Desistir");
        System.out.println();
        System.out.println("Escolha uma opção ou uma pedra: ");
        
        int opcao = scanner.nextInt();
        if (opcao == pedras.size() + 1) {
            if (!pedrasDisponiveisParaCompra.isEmpty()) {
                Pedra comprada = pedrasDisponiveisParaCompra.remove(0);
                pedras.add(comprada);
                System.out.println("Pedra comprada: " + comprada.getNome());
                // Tentativa de jogar a pedra imediatamente após comprar
                jogarPedra(comprada, tabuleiro);
            } else {
                System.out.println("Não há pedras disponíveis para comprar.");
            }
        } else if (opcao == pedras.size() + 2) {
            System.out.println("Passou a vez.");
        } else if (opcao == pedras.size() + 3) {
            System.out.println("\nJogo encerrado.");
            System.exit(0);
        } else if (opcao > 0 && opcao <= pedras.size()) {
            Pedra pedra = pedras.get(opcao - 1);
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
