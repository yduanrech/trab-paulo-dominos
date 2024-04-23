import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Pedra> pedrasTabuleiro = new ArrayList<>();
    private int ladoEsquerdoTabuleiro;
    private int ladoDireitoTabuleiro;

    public Tabuleiro() {
        ladoEsquerdoTabuleiro = -1; // Inicialmente não há pedras no tabuleiro
        ladoDireitoTabuleiro = -1;
    }

    public boolean adicionarPedraEsquerda(Pedra pedra) {
        if (ladoEsquerdoTabuleiro == -1) {
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        if (pedra.getNumDireito() == ladoEsquerdoTabuleiro) {
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            return true;
        } else if (pedra.getNumEsquerdo() == ladoEsquerdoTabuleiro) {
            pedra.inverterLados();
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumDireito();
            return true;
        }
        return false;
    }

    public boolean adicionarPedraDireita(Pedra pedra) {
        if (ladoDireitoTabuleiro == -1) {
            pedrasTabuleiro.add(pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        if (pedra.getNumEsquerdo() == ladoDireitoTabuleiro) {
            pedrasTabuleiro.add(pedra);
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        } else if (pedra.getNumDireito() == ladoDireitoTabuleiro) {
            pedra.inverterLados();
            pedrasTabuleiro.add(pedra);
            ladoDireitoTabuleiro = pedra.getNumEsquerdo();
            return true;
        }
        return false;
    }

    public void printTabuleiro() {
        System.out.println("Tabuleiro atual:");
        for (Pedra pedra : pedrasTabuleiro) {
            System.out.print(pedra.getNome() + " ");
        }
        System.out.println();
    }
}
