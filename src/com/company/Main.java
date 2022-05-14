package com.company;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    
    // Джамал Исса Кого ИВБО-04-20

    public static String checkFile(){
        String code="";
        try(FileReader reader = new FileReader("C:\\Users\\acer\\IdeaProjects\\djamal\\Projet1\\src\\com\\company/Code.txt"))
        {
            int c;
            while((c=reader.read())!=-1){

                code=code.concat(String.valueOf((char)c));
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return code;
    }

    public static void main(String[] args) {
        String s=checkFile();
        System.out.println(s);
        Lexer lexer=new Lexer(s);
        Parser parser=new Parser(lexer.analyze());
        RootNode root=parser.parseTokens();
        Interpreter interpreter =new Interpreter();
        for(int i = 0; i<root.codeStr.size(); i++) {
            interpreter.run(root.codeStr.get(i));
        }
    }
}
