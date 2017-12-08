import java.io.*;
class ej1 {
    public static void main(String[] args) {  
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("input.txt"));
            String line;  
            String all = "";
            String[] parts = null;
            int suma = 0;
            while ((line = br.readLine()) != null) {
                all = all + line;               
            } 
            parts = all.split("");
            for(int i = 0; i < parts.length - 1; i++){
                if (parts[i].equals(parts[i+1])){
                   suma = suma + Integer.parseInt(parts[i]); 
                }               
            }
            if(parts[0].equals(parts[parts.length - 1])){
                suma = suma + Integer.parseInt(parts[0]);
            }
            System.out.println("El resultado es: "+ suma);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}