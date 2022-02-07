package inputOutputBytes;

import java.io.*;

// Faça um cópia do arquivo "recomendacoes-copy.txt"
public class ExemploIOBytes {
    public static void main(String[] args) throws IOException {
        copyFile();
    }

    public static void copyFile() throws IOException {
        File file = new File("C:\\Users\\Pichau\\Documents\\MeusProjetos\\input-output-arquivos\\recomendacoes-copy.txt");
        String nameFile = file.getName();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nameFile));

        String nameFileCopy = nameFile.substring(0, nameFile.indexOf(".")).concat("-copy2.txt");
        File fileCopy = new File(nameFileCopy);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nameFileCopy));
        int line = 0;
        while((line = bis.read()) != -1){
            bos.write((char)line);
            bos.flush();
        }

        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" - tamanho %d bytes copiado com sucesso!", nameFile, file.length());
    }
}
