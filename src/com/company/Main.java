package com.company;

//   Необходимо написать программу, которая будет выводить на экран текстовые данные из файла .txt,
//   а потом в этот же файл перезаписывать текстовые данные, введенные вручную.
//   Количество строк после перезаписи должно быть столько же, сколько и в изначальном варианте.

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //вывод из .txt
        try(FileReader txtRead = new FileReader("file.txt"))
        {
            int i;
            while((i=txtRead.read())!=-1){
                System.out.print((char)i);
            }
        }
        catch (IOException exc){
            System.out.println(exc.getMessage());
        }

        //подсчет строк в .txt
        File file = new File("file.txt");
        LineNumberReader lnr = new LineNumberReader(new FileReader(file));
        int linesCount = 0;
        while(null != lnr.readLine()) {
            linesCount++;
        }
        System.out.println(" ");
//        System.out.println(strLinesCount);

        //ввод в .txt
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try(FileWriter strWrite = new FileWriter("file.txt", false)) {
            for (int i = 0; i<linesCount; i++){
                str = reader.readLine();
                strWrite.write(str);
                strWrite.append('\n');
            }
        }
        catch(IOException exc){
            System.out.println(exc.getMessage());
        }
    }
}
