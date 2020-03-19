/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trajectoire;

/**
 *
 * @author Aurel
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Trajectoire.Coordonnee;
import java.math.*;

/**
 *
 * @author valleta
 */
public class Etape {

    private Coordonnee depart;
    private Coordonnee arrivee;

    public Etape(Coordonnee depart, Coordonnee arrivee) {
        this.depart = depart;
        this.arrivee = arrivee;

    }
    public void set(Coordonnee e1, Coordonnee e2)
    {
        depart = e1;
        arrivee = e2;
    }
    public Coordonnee getDepart(){
        return this.depart;
    }
    
    public Coordonnee getArrive(){
        return this.arrivee;
    }

    public double distance() {
        double xe = depart.getX();
        double ye = depart.getY();
        double ze = depart.getZ();

        double xe1 = arrivee.getX();
        double ye1 = arrivee.getY();
        double ze1 = arrivee.getZ();

        return Math.sqrt( Math.pow((xe - xe1),2) + Math.pow((ye - ye1),2) + Math.pow((ze - ze1),2));

    }

    @Override
    public String toString() {
        return this.depart.toString() + "->" + this.arrivee.toString();
    }

}
