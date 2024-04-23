public class Pedra {
    private String nome;
    private int numEsquerdo;
    private int numDireito;

    public Pedra(String nome, int numEsquerdo, int numDireito) {
        this.nome = nome;
        this.numEsquerdo = numEsquerdo;
        this.numDireito = numDireito;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void inverterLados() {
        int temp = numEsquerdo;
        numEsquerdo = numDireito;
        numDireito = temp;
    }
}
