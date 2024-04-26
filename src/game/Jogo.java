package game;

import java.util.Collections;
import java.util.List;

import players.Jogador;
import players.JogadorHumano;
import players.JogadorIA;

import java.util.ArrayList;

public class Jogo {
    private List<Pedra> pedras = new ArrayList<>();
    private List<Pedra> pedrasDisponiveisParaCompra = new ArrayList<>();
    private Jogador jogadorHumano;
    private Jogador jogadorIA;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Controle controle;

    public Jogo() {
        //Instância dos jogadores
        jogadorHumano = new JogadorHumano("Jogador", pedrasDisponiveisParaCompra);
        jogadorIA = new JogadorIA(pedrasDisponiveisParaCompra);
        controle = new Controle(jogadorHumano, jogadorIA);
        inicializarPedras();
        distribuirPedras();
        controle.setPartidaEmAndamento(true);
    }

    //Gera as peças para o jogo e embaralha a ordem delas depois
    private void inicializarPedras() {
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                pedras.add(new Pedra(i, j));
            }
        }
        Collections.shuffle(pedras);
    }

    public void distribuirPedras() {
        int numPedrasParaJogadores = 14; //7 pedras para cada jogador

        for (int i = 0; i < numPedrasParaJogadores; i++) {
            if (i % 2 == 0) {
                jogadorHumano.receberPedra(pedras.remove(0));
            } else {
                jogadorIA.receberPedra(pedras.remove(0));
            }
        }
        //As pedras que sobraram vão para a lista de pedras para compra
        pedrasDisponiveisParaCompra.addAll(pedras);
        pedras.clear();
    }

    public void iniciarPartida() {
        while (controle.isPartidaEmAndamento()) {
            System.out.println("\n ===== Vez do jogador: " + controle.getJogadorAtual().getNome() + " =====\n");
            //printPedrasJogador(controle.getJogadorAtual());
            //System.out.println();
            controle.executarJogada(tabuleiro);
            tabuleiro.printTabuleiro();
            //System.out.println("Lado esquerdo: " + tabuleiro.getLadoEsquerdoTabuleiro() + " | Lado direito: " + tabuleiro.getLadoDireitoTabuleiro());
        }
        System.out.println("\nFim do jogo!");
    }

    private void printPedrasJogador(Jogador jogador) {
        System.out.println("Pedras de " + jogador.getNome() + ": ");
        for (Pedra pedra : jogador.getPedras()) {
            System.out.print(pedra.getNome() + " ");
        }
        System.out.println();
    }
}
