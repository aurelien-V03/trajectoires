
package trajectoires;
import Trajectoire.Trajectoire;
import java.io.IOException;
import org.xml.sax.SAXException;
public class Trajectoires {
    public static void main(String[] args) {
        
    Trajectoire trajectoire = new Trajectoire();
        try {
            trajectoire.readDOM("src/xml/", "trajectoires.xml");
} catch (Exception e) {
    System.out.println("erreur " +e.getMessage());
}
 
System.out.println(trajectoire.toString());
System.out.println("\nDistance parcourue sur toute la trajectoire : " + trajectoire.distance());
        
        
    }
    
}
