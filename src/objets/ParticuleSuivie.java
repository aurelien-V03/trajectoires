/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objets;
import Trajectoire.Trajectoire;
import java.util.ArrayList;

/**
 *
 * @author valleta
 */
public class ParticuleSuivie extends Particule{

private Trajectoire trajectoire;
public ParticuleSuivie(double taille)
{
    super(taille);
}

public void init(ArrayList<Objet> objs)
{
this.trajectoire = new Trajectoire();
this.trajectoire.ajoute(this.getPos());
}

public void action(ArrayList<Objet> objs)
{
   super.action(objs);
this.trajectoire.ajoute(this.getPos());

}

public void  termine(ArrayList<Objet> objs)
{

}
@Override
public String toString() {
return super.toString() + " - Trajectoire : " +trajectoire.toString();
}

}
