import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Jogo {
    private List<Pedra> pedras = new ArrayList<>();
    private List<Pedra> pedrasDisponiveisParaCompra = new ArrayList<>();
    private Jogador jogadorHumano;
    private Jogador jogadorIA;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Controle controle;

    public Jogo() {
        jogadorHumano = new JogadorHumano("Jogador 1", pedrasDisponiveisParaCompra);
        jogadorIA = new JogadorIA(pedrasDisponiveisParaCompra);
        controle = new Controle(jogadorHumano, jogadorIA);
        inicializarPedras();
        distribuirPedras();
        controle.setPartidaEmAndamento(true);
    }

    private void inicializarPedras() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                pedras.add(new Pedra(i, j));
            }
        }
        Collections.shuffle(pedras);
    }

    public void distribuirPedras() {
        int numPedrasParaJogadores = 14;  // 7 pedras para cada jogador
        if (pedras.size() < numPedrasParaJogadores) {
            throw new IllegalStateException("Not enough pedras to distribute.");
        }

        for (int i = 0; i < numPedrasParaJogadores; i++) {
            if (i % 2 == 0) {
                jogadorHumano.receberPedra(pedras.remove(0));
            } else {
                jogadorIA.receberPedra(pedras.remove(0));
            }
        }
        pedrasDisponiveisParaCompra.addAll(pedras);
        pedras.clear();
    }

    public void iniciarPartida() {
        while (controle.isPartidaEmAndamento()) {
            System.out.println("\nVez do jogador: " + controle.getJogadorAtual().getNome());
            printPedrasJogador(controle.getJogadorAtual());
            controle.executarJogada(tabuleiro);
            tabuleiro.printTabuleiro();
        }
        System.out.println("Fim do jogo!");
    }

    private void printPedrasJogador(Jogador jogador) {
        System.out.println("Pedras de " + jogador.getNome() + ": ");
        for (Pedra pedra : jogador.getPedras()) {
            System.out.print(pedra.getNome() + " ");
        }
        System.out.println();
    }
}
