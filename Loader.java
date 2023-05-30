import java.util.Scanner;   
import java.net.*;  

public class Loader {
    
    /**
     * This method receives a URL, performs a connection and loads its content into a Scanner. Returns the content loaded.
     * @param URLInput string that contains a URL link to the HTML structure to be loaded.
     * @return the content loaded by connecting and scanning from URLInput.
     */
    public String getContent (String URLInput) {
        String content = null;
        URLConnection connection = null;

        try {      
            connection =  new URL(URLInput).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close(); 
        } catch ( Exception ex ) {
            return null;          
        }
        return content;
    }

}
