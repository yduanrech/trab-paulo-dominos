import java.util.ArrayList;
import java.util.List;

public class JogadorIA implements Jogador {
    private String nome;
    private List<Pedra> pedras = new ArrayList<>();

    public JogadorIA() {
        this.nome = "Computador";
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        // Simulação simples de uma jogada de IA
        for (Pedra pedra : pedras) {
            if (tabuleiro.adicionarPedraEsquerda(pedra) || tabuleiro.adicionarPedraDireita(pedra)) {
                System.out.println("IA jogou " + pedra.getNome());
                pedras.remove(pedra);
                break;
            }
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
