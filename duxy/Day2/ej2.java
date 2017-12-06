import java.io.*;
class ej2 {
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
                    int divisor = Integer.parseInt(number);
                    for(String number_div : parts){
                        int dividendo = Integer.parseInt(number_div);
                        if ((divisor % dividendo == 0)&&(dividendo != divisor)){
                            System.out.println(divisor/dividendo);
                            suma = suma + divisor/dividendo;
                        }
                    }
                }
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