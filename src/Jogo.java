import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Jogo {
    private List<Pedra> pedras = new ArrayList<>();
    private Jogador jogadorHumano;
    private Jogador jogadorIA;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Controle controle;

    public Jogo() {
        jogadorHumano = new JogadorHumano("Jogador 1");
        jogadorIA = new JogadorIA();
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
        for (int i = 0; i < 7; i++) {
            jogadorHumano.receberPedra(pedras.remove(0));
            jogadorIA.receberPedra(pedras.remove(0));
        }
    }

    public void iniciarPartida() {
        while (controle.isPartidaEmAndamento()) {
            System.out.println("\nVez do jogador: " + controle.getJogadorAtual().getNome());
            controle.getJogadorAtual().jogar(tabuleiro);
            tabuleiro.printTabuleiro();
            if (!controle.isPartidaEmAndamento()) {
                break;
            }
            controle.alternarJogadorDaVez();
        }
        System.out.println("Fim do jogo!");
    }
}
