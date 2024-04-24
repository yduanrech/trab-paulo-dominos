package game;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Pedra> pedrasTabuleiro = new ArrayList<>();
    private int ladoEsquerdoTabuleiro;
    private int ladoDireitoTabuleiro;

    public Tabuleiro() {
        //Inicializa sem pedras no tabuleiro
        ladoEsquerdoTabuleiro = -1;  
        ladoDireitoTabuleiro = -1;  
    }

    public boolean adicionarPedraEsquerda(Pedra pedra) {
        if (ladoEsquerdoTabuleiro == -1) {  //Se o tabuleiro está vazio
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        //Se a pedra não encaixar, tenta girar
        if (pedra.getNumDireito() != ladoEsquerdoTabuleiro && pedra.getNumEsquerdo() == ladoEsquerdoTabuleiro) {
            pedra.inverterLados();
        }
        //Verifica novamente se agora encaixa
        if (pedra.getNumDireito() == ladoEsquerdoTabuleiro) {
            pedrasTabuleiro.add(0, pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            return true;
        }
        return false;
    }

    //Mesma lógica para adicionar ao lado esquerdo, mas ao contrário
    public boolean adicionarPedraDireita(Pedra pedra) {
        if (ladoDireitoTabuleiro == -1) {  
            pedrasTabuleiro.add(pedra);
            ladoEsquerdoTabuleiro = pedra.getNumEsquerdo();
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }

        if (pedra.getNumEsquerdo() != ladoDireitoTabuleiro && pedra.getNumDireito() == ladoDireitoTabuleiro) {
            pedra.inverterLados();
        }

        if (pedra.getNumEsquerdo() == ladoDireitoTabuleiro) {
            pedrasTabuleiro.add(pedra);
            ladoDireitoTabuleiro = pedra.getNumDireito();
            return true;
        }
        return false;
    }

    public void printTabuleiro() {
        System.out.println();
        for (int i = 0; i <= pedrasTabuleiro.size() * 6; i++) {
             System.out.print("-");
        }
        System.out.println();
        System.out.println("Tabuleiro atual: ");
        for (Pedra pedra : pedrasTabuleiro) {
            System.out.print(pedra.getNome() + " ");
        }
        System.out.println();
        for (int i = 0; i <= pedrasTabuleiro.size() * 6; i++) {
            System.out.print("-");
       }
       System.out.println();
    }
}
