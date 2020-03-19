/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package objets;

/**
 *
 * @author valleta
 */
public class Boite {
    private double largeur;
    private double profondeur;
    private double hauteur;

public Boite(double largeur, double profondeur, double hauteur)
{   
    this.largeur = largeur;
    this.profondeur = profondeur;
    this.hauteur = hauteur;
}

public double getLargeur()
{
return this.largeur;
}
public double getProfondeur()
{

    return this.profondeur;
}

public double getHauteur(){
return this.hauteur;
}




}
