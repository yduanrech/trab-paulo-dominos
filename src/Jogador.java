import java.util.List;

public interface Jogador {
    void jogar(Tabuleiro tabuleiro);
    void receberPedra(Pedra pedra);
    List<Pedra> getPedras();
    String getNome();
}
