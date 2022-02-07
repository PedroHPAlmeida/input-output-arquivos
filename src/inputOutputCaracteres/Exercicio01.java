package inputOutputCaracteres;// Abrir o teclado para ler 3 filmes que você recomendaria e armazen-os em "recomendações.txt"

import java.io.*;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

    public static void lerTecladoEscreverDocumento() throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 recomendações de filmes: ");
        pw.flush();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        File file = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName()));

        do {
            bw.write(line);
            bw.newLine();
            line = sc.nextLine();
        } while(!line.equalsIgnoreCase("fim"));
        bw.flush();

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", file.getName());

        pw.close();
        sc.close();
        bw.close();
    };
}
