package game;

public class Pedra {
    private String nome;
    private int numEsquerdo;
    private int numDireito;
    private int pontos;

    public Pedra(int numEsquerdo, int numDireito) {
        this.numEsquerdo = numEsquerdo;
        this.numDireito = numDireito;
        this.pontos = numEsquerdo + numDireito;
        atualizarNome(); //Atualiza o nome inicial baseado nos lados fornecidos
    }

    public String getNome() {
        return nome;
    }

    public int getNumEsquerdo() {
        return numEsquerdo;
    }

    public int getNumDireito() {
        return numDireito;
    }

    public void inverterLados() {
        int numTemp = numEsquerdo;
        numEsquerdo = numDireito;
        numDireito = numTemp;
        atualizarNome(); //Atualiza o nome sempre que os lados são invertidos
    }

    private void atualizarNome() {
        this.nome = "[" + numEsquerdo + "|" + numDireito + "]";
    }

    public int getPontos() {
        return pontos;
    }

    
}
