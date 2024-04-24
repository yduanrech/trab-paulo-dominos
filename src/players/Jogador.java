package players;

import java.util.List;

import game.Pedra;
import game.Tabuleiro;

public interface Jogador {
    void jogar(Tabuleiro tabuleiro);
    void receberPedra(Pedra pedra);
    List<Pedra> getPedras();
    String getNome();
}
