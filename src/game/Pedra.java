package game;

public class Pedra {
    private String nome;
    private int numEsquerdo;
    private int numDireito;

    public Pedra(int numEsquerdo, int numDireito) {
        this.numEsquerdo = numEsquerdo;
        this.numDireito = numDireito;
        updateName();  // Atualiza o nome inicial baseado nos lados fornecidos
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
        int temp = numEsquerdo;
        numEsquerdo = numDireito;
        numDireito = temp;
        updateName();  // Atualiza o nome sempre que os lados são invertidos
    }

    private void updateName() {
        this.nome = "[" + numEsquerdo + "|" + numDireito + "]";
    }
}
