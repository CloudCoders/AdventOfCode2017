import java.io.*;
class ej2 {
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
            int desplazamiento = parts.length/2;
            for(int i = 0; i < parts.length; i++){
                int index = (((i + desplazamiento)% parts.length));
                if (parts[i].equals(parts[index])){
                   suma = suma + Integer.parseInt(parts[i]); 
                }               
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