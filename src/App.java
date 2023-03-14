import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> votes = new HashMap<>();

        String path = "C:\\Users\\premi\\OneDrive\\Documentos\\votes.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null) {
                String[] dades = line.split(",");

                if(votes.get(dades[0]) == null) {
                    Integer value = Integer.parseInt(dades[1]);
                    votes.put(dades[0], value);
                } else {
                    Integer value = Integer.parseInt(dades[1]);
                    votes.put(dades[0], votes.get(dades[0]) + value);
                }
                line = br.readLine();   
                if(line.equals(null) || line.equals("")){ 
                    break;
                }             
            }

            for (String key: votes.keySet()) {
                System.out.println(key + "," + votes.get(key));
            } 


        } catch( IOException e) {
           System.out.println("Erro writing file: " + e.getMessage()); 
        }
    }
}
