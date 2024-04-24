import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Pedra> pedrasTabuleiro = new ArrayList<>();
    private int ladoEsquerdoTabuleiro;
    private int ladoDireitoTabuleiro;

    public Tabuleiro() {
        ladoEsquerdoTabuleiro = -1;  // Inicializa sem pedras no tabuleiro
        ladoDireitoTabuleiro = -1;  // Inicializa sem pedras no tabuleiro
    }

    public boolean adicionarPedraEsquerda(Pedra pedra) {
        if (ladoEsquerdoTabuleiro == -1) {  // Se o tabuleiro está vazio
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        // Se a pedra não encaixar diretamente, tenta girar
        if (pedra.getNumDireito() != ladoEsquerdoTabuleiro && pedra.getNumEsquerdo() == ladoEsquerdoTabuleiro) {
            pedra.inverterLados();
        }
        // Verifica novamente se agora encaixa
        if (pedra.getNumDireito() == ladoEsquerdoTabuleiro) {
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
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
        // Se a pedra não encaixar diretamente, tenta girar
        if (pedra.getNumEsquerdo() != ladoDireitoTabuleiro && pedra.getNumDireito() == ladoDireitoTabuleiro) {
            pedra.inverterLados();
        }
        // Verifica novamente se agora encaixa
        if (pedra.getNumEsquerdo() == ladoDireitoTabuleiro) {
            pedrasTabuleiro.add(pedra);
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        return false;
    }

    public void printTabuleiro() {
        System.out.println("\n--------------------");
        System.out.println("Tabuleiro atual: ");
        for (Pedra pedra : pedrasTabuleiro) {
            System.out.print(pedra.getNome() + " ");
        }
        System.out.println();
        System.out.println("--------------------");
    }
}
