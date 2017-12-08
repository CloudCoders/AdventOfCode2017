import java.io.*;
import java.io.File;
import java.util.Scanner;
class ej1 {
    public static void main(String[] args) {  
        String line;  
        String all = "";
        String[] parts; 
        int addition = 0; 
        try {  
            Scanner input = new Scanner(System.in);
            File file = new File("input.txt");
            input = new Scanner(file);
            while (input.hasNextLine()) {
                all = all + input.nextLine();
            }
            input.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        parts = all.split("");
        for(int i = 0; i < parts.length - 1; i++){
            if (parts[i].equals(parts[i+1])){
               addition = addition + Integer.parseInt(parts[i]); 
            }               
        }
        if(parts[0].equals(parts[parts.length - 1])){
            addition = addition + Integer.parseInt(parts[0]);
        }
        System.out.println(addition);
    }
}