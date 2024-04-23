import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Pedra> pedrasTabuleiro = new ArrayList<>();
    private int ladoEsquerdoTabuleiro;
    private int ladoDireitoTabuleiro;

    public Tabuleiro() {
        ladoEsquerdoTabuleiro = -1;  // Quando o tabuleiro está vazio
        ladoDireitoTabuleiro = -1;  // Quando o tabuleiro está vazio
    }

    public boolean adicionarPedraEsquerda(Pedra pedra) {
        if (ladoEsquerdoTabuleiro == -1) {  // Se o tabuleiro está vazio
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        // Tenta encaixar sem girar
        if (pedra.getNumDireito() == ladoEsquerdoTabuleiro) {
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            return true;
        }
        // Tenta girar e encaixar
        else if (pedra.getNumEsquerdo() == ladoEsquerdoTabuleiro) {
            pedra.inverterLados();
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumDireito();
            return true;
        }
        return false;
    }

    public boolean adicionarPedraDireita(Pedra pedra) {
        if (ladoDireitoTabuleiro == -1) {  // Se o tabuleiro está vazio
            pedrasTabuleiro.add(pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        // Tenta encaixar sem girar
        if (pedra.getNumEsquerdo() == ladoDireitoTabuleiro) {
            pedrasTabuleiro.add(pedra);
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        // Tenta girar e encaixar
        else if (pedra.getNumDireito() == ladoDireitoTabuleiro) {
            pedra.inverterLados();
            pedrasTabuleiro.add(pedra);
            ladoDireitoTabuleiro = pedra.getNumEsquerdo();
            return true;
        }
        return false;
    }

    public void printTabuleiro() {
        System.out.print("Tabuleiro atual: ");
        for (Pedra pedra : pedrasTabuleiro) {
            System.out.print(pedra.getNome() + " ");
        }
        System.out.println();
    }
}
