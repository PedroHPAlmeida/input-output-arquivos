package exercicios;

/*Crie um arquivo "roupas.bin" e armazene:
* 1. Nome do produto, tamanho, quantidade e preço.
* 2. Leia este arquivo e imprima no console.*/

import java.io.*;

public class Exercicio01 {
    public static void main(String[] args) throws IOException {
        System.out.println("----- Cadastro de produtos -----");

        File file = createFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String more;

        do {
            System.out.print("Nome produto: ");
            addProduct(bw, br);
            System.out.print("Tamanho (P/M/G/U): ");
            addProduct(bw, br);
            System.out.print("Quantidade: ");
            addProduct(bw, br);
            System.out.print("Preço: R$ ");
            addProduct(bw, br);

            System.out.print("Deseja adicionar mais produtos [S/N]: ");
            more = br.readLine().toUpperCase();
        } while (more.equals("S"));
        bw.close();

        // imprimindo os dados do arquivo no console
        br = new BufferedReader(new FileReader(file.getName()));
        System.out.println("---- Banco de dados ----");
        while(br.ready()){
            System.out.println("Produto: " + br.readLine());
            System.out.println("Tamanho: " + br.readLine());
            System.out.println("Quantidade: " + br.readLine());
            System.out.println("Preço: R$ " + br.readLine());
        }
    }

    public static File createFile(){
        return new File("C:\\Users\\Pichau\\Documents\\MeusProjetos\\input-output-arquivos\\src\\exercicios\\roupas.txt");
    }

    public static void addProduct(BufferedWriter bw, BufferedReader br) throws IOException {
        bw.write(br.readLine());
        bw.newLine();
    }
}
