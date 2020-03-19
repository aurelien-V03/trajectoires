/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objets;
import java.util.ArrayList;

/**
 *
 * @author valleta
 */
public class Environnement extends Objet  {
    
 private Objet obj;
public Environnement(double largeur, double hauteur, double profondeur)
{
    super(largeur, hauteur, profondeur, Type.Environnement);
}

@Override
public String toString() {
return "["+super.toString()+" :  " + getCID().toString() + ">" + getCSG().toString() + "]";
}

public void affiche()
{
    System.out.println(toString());
}
public  void init(ArrayList<Objet> objs){}
public  void action(ArrayList<Objet> objs){}
public  void termine(ArrayList<Objet> objs){}   
}
