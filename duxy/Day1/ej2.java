import java.io.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;
class ej2 {
    public static void main(String[] args) {  
        String line;  
        String all = "";
        String[] parts = null;
        int addition = 0;
        try {            
            Scanner input = new Scanner(System.in);
            File file = new File("input.txt");
            input = new Scanner(file);
            while (input.hasNextLine()) {
                 all = all + input.nextLine();
            }
            input.close();  
        } catch (IOException e) {
            e.printStackTrace();
        }
        parts = all.split("");
        int displa = parts.length/2;
        for(int i = 0; i < parts.length; i++){
            int index = (((i + displa)% parts.length));
            if (parts[i].equals(parts[index])){
               addition = addition + Integer.parseInt(parts[i]); 
            }               
        }            
       System.out.println(addition);
    }
}