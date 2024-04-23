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
        // Se o tabuleiro estiver vazio, adiciona a pedra diretamente
        if (ladoEsquerdoTabuleiro == -1) {
            pedrasTabuleiro.add(0, pedra); // Adiciona no começo da lista
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        } else {
            // Tentar encaixar sem girar
            if (pedra.getNumDireito() == ladoEsquerdoTabuleiro) {
                pedrasTabuleiro.add(0, pedra);
                ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
                return true;
            }
            // Tentar girar a pedra para encaixar
            else if (pedra.getNumEsquerdo() == ladoEsquerdoTabuleiro) {
                pedra.inverterLados();
                pedrasTabuleiro.add(0, pedra);
                ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
                return true;
            }
        }
        return false;
    }

    public boolean adicionarPedraDireita(Pedra pedra) {
        // Se o tabuleiro estiver vazio, adiciona a pedra diretamente
        if (ladoDireitoTabuleiro == -1) {
            pedrasTabuleiro.add(pedra); // Adiciona no final da lista
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        } else {
            // Tentar encaixar sem girar
            if (pedra.getNumEsquerdo() == ladoDireitoTabuleiro) {
                pedrasTabuleiro.add(pedra);
                ladoDireitoTabuleiro = pedra.getNumDireito();
                return true;
            }
            // Tentar girar a pedra para encaixar
            else if (pedra.getNumDireito() == ladoDireitoTabuleiro) {
                pedra.inverterLados();
                pedrasTabuleiro.add(pedra);
                ladoDireitoTabuleiro = pedra.getNumDireito();
                return true;
            }
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
