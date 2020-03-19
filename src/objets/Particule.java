/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objets;
import Trajectoire.Coordonnee;
import Trajectoire.Trajectoire;
import simulation.Random;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author valleta
 */
public class Particule extends Objet {
    private Coordonnee vitesse;
    private Objet obj;

    public Particule(double taille)
    {
        super(taille,taille, taille, Type.Particule);
    }
    
// Verifie juste si il n'y a pas la coordonee c dans objliste
    public Boolean testePos(Coordonnee c, ArrayList<Objet> objList) {
    Boolean bonEmplacement = true;
    Iterator<Objet> iterator = objList.iterator();
    while (iterator.hasNext() && bonEmplacement) {
    Objet obj = iterator.next();
    if ((obj.isIn(c) && obj.getType() == Type.Particule) || (!obj.isIn(c) && obj.getType() == Type.Environnement)) {
    bonEmplacement = false;
    }
    }
    return bonEmplacement;
    }

public void init(ArrayList<Objet> objs)
{

}

public void action(ArrayList<Objet> objs)
{
    Coordonnee c = new Coordonnee(this.getPos().getX() + vitesse.getX() , this.getPos().getY() + vitesse.getY(), this.getPos().getZ() + vitesse.getZ());
    if(testePos(c, objs))
    {
       this.setPos(c);
    }
       Random r = new Random(0.0,0.01);
       this.vitesse.setX(this.vitesse.getX() + r.get());
        this.vitesse.setY(this.vitesse.getY() + r.get());
        this.vitesse.setZ(this.vitesse.getZ() + r.get());

}

public void  termine(ArrayList<Objet> objs)
{

}

public void affiche(){
    System.out.println(toString());
}

@Override
public String toString(){
return "["+super.toString()+":"+getPos().toString()+"]";
}   


    

}
