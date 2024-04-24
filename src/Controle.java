public class Controle {
    private Jogador jogadorAtual;
    private Jogador jogador1;
    private Jogador jogador2;
    private boolean partidaEmAndamento;

    public Controle(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = jogador1; // Por padrão, começamos com o jogador1
        this.partidaEmAndamento = true;
    }

    public void executarJogada(Tabuleiro tabuleiro) {
        jogadorAtual.jogar(tabuleiro);
        if (jogadorAtual.getPedras().isEmpty()) {
            System.out.println();
            System.out.println(jogadorAtual.getNome() + " ganhou o jogo!!!");
            setPartidaEmAndamento(false);
        } else {
            alternarJogadorDaVez();
        }
    }

    public void alternarJogadorDaVez() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    public boolean isPartidaEmAndamento() {
        return partidaEmAndamento;
    }

    public void setPartidaEmAndamento(boolean partidaEmAndamento) {
        this.partidaEmAndamento = partidaEmAndamento;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }
}
