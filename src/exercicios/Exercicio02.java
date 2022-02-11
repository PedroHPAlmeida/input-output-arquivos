package exercicios;

import java.io.*;

/*Crie a classe Gato com os atributos nome, idade, e cor:
* Instancie um objeto e serialize
* Desserialize este objeto e mostre no console*/

public class Exercicio02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Gato gato = new Gato("Gato 1", 5, "preto", true, false);

        serializacao(gato);

        Gato o1 = (Gato)desserializacao();

        System.out.println(gato);
    }

    public static void serializacao(Object o) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("gatos.txt")));
        oos.writeObject(o);
        oos.close();
    }

    public static Object desserializacao() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("gatos.txt")));
        return ois.readObject();
    }

}

class Gato implements Serializable{
    @Serial
    private static final long serialVersionUID = 2L;

    private String nome;
    private int idade;
    private String cor;
    private boolean castrado;
    private transient boolean ronrona;

    public Gato(String nome, int idade, String cor, boolean castrado, boolean ronrona) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.castrado = castrado;
        this.ronrona = ronrona;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public boolean isRonrona() {
        return ronrona;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Gato{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append(", cor='").append(cor).append('\'');
        sb.append(", castrado=").append(castrado);
        sb.append(", ronrona=").append(ronrona);
        sb.append('}');
        return sb.toString();
    }
}
