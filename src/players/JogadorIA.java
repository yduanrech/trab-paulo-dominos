package players;
import java.util.ArrayList;
import java.util.List;

import game.Pedra;
import game.Tabuleiro;

public class JogadorIA implements Jogador {
    private String nome;
    private List<Pedra> pedras = new ArrayList<>();
    private List<Pedra> pedrasDisponiveisParaCompra; // Referência às pedras disponíveis para compra.

    public JogadorIA(List<Pedra> pedrasDisponiveisParaCompra) {
        this.nome = "Inteligência Artificial";
        this.pedrasDisponiveisParaCompra = pedrasDisponiveisParaCompra;
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        for (Pedra pedra : pedras) {
            if (tabuleiro.adicionarPedraEsquerda(pedra) || tabuleiro.adicionarPedraDireita(pedra)) {
                System.out.println("IA jogou " + pedra.getNome());
                pedras.remove(pedra);
                return;
            }
        }
        // Se não houver jogada possível, compra uma pedra
        if (!pedrasDisponiveisParaCompra.isEmpty()) {
            Pedra comprada = pedrasDisponiveisParaCompra.remove(0);
            pedras.add(comprada);
            //System.out.println("IA comprou: " + comprada.getNome());
            System.out.println("IA comprou uma pedra!");
            System.out.println("IA jogou " + comprada.getNome());
            // Tenta jogar a pedra comprada imediatamente
            if (!(tabuleiro.adicionarPedraEsquerda(comprada) || tabuleiro.adicionarPedraDireita(comprada))) {
                System.out.println("IA não conseguiu jogar a pedra comprada.");
            }
        } else {
            System.out.println("IA passou a vez.");
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
