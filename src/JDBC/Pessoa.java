package JDBC;

public class Pessoa {

    private int codigo;
    private String nome;

    /*criação do método construtor*/
    public Pessoa (int codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
    }
    /* criação dos méodos gt e set*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
