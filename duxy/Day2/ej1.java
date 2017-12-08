import java.io.*;
class ej1 {
    public static void main(String[] args) {  
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("input.txt"));
            String line;
            int suma = 0;
            while ((line = br.readLine()) != null) {                
                String[] parts = line.split("\t");
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(String number : parts){
                    int nu_in = Integer.parseInt(number);
                    if(nu_in > max){
                       max = nu_in;
                    }
                    if(nu_in < min){
                       min = nu_in;
                    }
                }                
                suma = suma + (max - min);
            }
            System.out.print("The result is: " + suma);
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