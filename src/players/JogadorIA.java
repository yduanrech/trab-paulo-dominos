package players;
import java.util.ArrayList;
import java.util.List;

import game.Pedra;
import game.Tabuleiro;

public class JogadorIA implements Jogador {
    private String nome;
    private List<Pedra> pedras = new ArrayList<>();
    private List<Pedra> pedrasDisponiveisParaCompra; 

    public JogadorIA(List<Pedra> pedrasDisponiveisParaCompra) {
        this.nome = "Inteligência Artificial";
        this.pedrasDisponiveisParaCompra = pedrasDisponiveisParaCompra;
    }

    @Override
    public void jogar(Tabuleiro tabuleiro) {

        int ladoEsquerdoTabuleiro = tabuleiro.getLadoEsquerdoTabuleiro();
        int ladoDireitoTabuleiro = tabuleiro.getLadoDireitoTabuleiro();
        List<Pedra> pedrasDisponiveis = new ArrayList<>();

        for (Pedra pedra : pedras) {
            //Se o lado esquerdo do tabuleiro for igual ao número direito ou o número esquerdo da pedra salve a pedra
           if (ladoEsquerdoTabuleiro == pedra.getNumDireito() || ladoEsquerdoTabuleiro == pedra.getNumEsquerdo()) {
                //System.out.println("Peça disponível: " + pedra.getNome());
                pedrasDisponiveis.add(pedra);
           //Se o lado direito do tabuleiro for igual ao número direito ou o número esquerdo, salve a pedra     
           } else if (ladoDireitoTabuleiro == pedra.getNumDireito() || ladoDireitoTabuleiro == pedra.getNumEsquerdo()) {
                //System.out.println("Peça disponível: " + pedra.getNome());
                pedrasDisponiveis.add(pedra);
           }
        }

        if (pedrasDisponiveis.size() > 0){
            /*System.out.println("Pedras disponíveis: ");
            for (Pedra pedra : pedrasDisponiveis) {
                System.out.println(pedra.getNome());
            }*/

            int maiorPonto = -1;
            Pedra pedraMaior = null;
            for (Pedra pedra : pedrasDisponiveis) {
                if (pedra.getPontos() > maiorPonto) {
                    maiorPonto = pedra.getPontos();
                    pedraMaior = pedra;
                }
            }   

            //System.out.println("Pedra maior: " + pedraMaior.getNome());

            if (tabuleiro.adicionarPedraEsquerda(pedraMaior) || tabuleiro.adicionarPedraDireita(pedraMaior)) {
                System.out.println("IA jogou " + pedraMaior.getNome());
                pedras.remove(pedraMaior);
                return;
            } 
        } else {
            System.out.println("Sem pedras disponíveis");
        }
        
        /*for (Pedra pedra : pedras) {
            if (tabuleiro.adicionarPedraEsquerda(pedra) || tabuleiro.adicionarPedraDireita(pedra)) {
                System.out.println("IA jogou " + pedra.getNome());
                pedras.remove(pedra);
                return;
            }
        }*/

        //Se não houver jogada possível, compra uma pedra
        if (!pedrasDisponiveisParaCompra.isEmpty()) {
            Pedra comprada = pedrasDisponiveisParaCompra.remove(0);
            pedras.add(comprada);
            //System.out.println("IA comprou: " + comprada.getNome());
            System.out.println("IA comprou uma pedra!");
            if (!(tabuleiro.adicionarPedraEsquerda(comprada) || tabuleiro.adicionarPedraDireita(comprada))) {
                System.out.println("IA não conseguiu jogar a pedra comprada.");
            } else {
                System.out.println("IA jogou " + comprada.getNome());
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
