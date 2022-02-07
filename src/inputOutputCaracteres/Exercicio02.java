package inputOutputCaracteres;

import java.io.*;

public class Exercicio02 {
    public static void main(String[] args) throws IOException {
        String nameFile = copiarArquivo();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Adicione 3 recomendações de Livros:");
        atualizarArquivo(nameFile);
    }

    public static String copiarArquivo() throws IOException {
        File file = new File("C:/Users/Pichau/Documents/MeusProjetos/input-output-arquivos/recomendacoes.txt");
        String nomeArquivo = file.getName();

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("-copy.txt");

        File fileCopy = new File(nomeArquivoCopy);

        BufferedWriter bw = new BufferedWriter(new FileWriter(fileCopy.getName()));

        BufferedReader bf = new BufferedReader(new FileReader(nomeArquivo));
        String line = bf.readLine();

        do {
            bw.write(line);
            bw.newLine();
            line = bf.readLine();
        } while(line != null);
        bw.flush();
        bw.close();
        bf.close();

        System.out.printf("Arquivo \"%s\" - tamanho %d bytes copiado com sucesso!\n", nomeArquivo, file.length());
        return fileCopy.getName();
    }

    public static void atualizarArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do{
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while(!line.equalsIgnoreCase("fim"));
        bw.flush();

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        pw.printf("Arquivo \"%s\" atualizado com sucesso!", arquivo);
        pw.flush();

        br.close();
        bw.close();
        pw.close();
    }
}
