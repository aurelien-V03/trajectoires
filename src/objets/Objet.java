package objets;

import Trajectoire.Coordonnee;
import java.util.ArrayList;

public abstract class Objet extends Boite {

    private Objet obj;
    // nombre d'instances
    private static int nbreinstances = 0;
    // numero unique d'instance
    private int numeroInstance;
    // coordonnee courante
    private Coordonnee pos; 
    private Type type;

    public Objet(double largeur, double hauteur, double profondeur, Type type) {
        super(largeur, hauteur, profondeur);
        this.type = type;
        nbreinstances++;
        this.numeroInstance = numeroInstance;
    }

    public Type getType() {
        return this.type;
    }

    public Coordonnee getPos() {
        return this.pos;
    }
    
    public void setPos(Coordonnee c)
    {
        this.pos = c;
    }

    public int getNumInstance() {
        return this.numeroInstance;
    }

    public static int getNbrInstance() {
        return nbreinstances;
    }

    public double getLargeur() {
        return super.getLargeur();
    }

    public double getProfondeur() {
        return super.getProfondeur();
    }

    public double getHauteur() {
        return super.getHauteur();
    }

    public String typeToString() {
        switch (type) {
            case Particule:
                return "Particule";
            case ParticuleMarquée:
                return "Particule marquée";
            case Environnement:
                return "Environnement";
        }
        return null;
    }

    @Override
    public String toString() {
        return "Objet_" + getNumeroInstance() + "(" + typeToString() + ")";
    }

    // objs = tous les objets de la simulation (environnement + particules)
    public abstract void init(ArrayList<Objet> objs);

    public abstract void action(ArrayList<Objet> objs);

    public abstract void termine(ArrayList<Objet> objs);

    public void affiche() {

    }

    public static int getNombreInstance() {
        return nbreinstances;
    }

    public int getNumeroInstance() {
        return numeroInstance;
    }

    // renvoie la limite inferieur selon l'axe x de la boite
    public double getMinX() {
        return (pos.getX() - (0.5 * getLargeur()));
    }

    // renvoie la limite superieur selon l'axe x de la boite
    public double getMaxX() {
        return pos.getX() + 0.5 * getLargeur();
    }

    public double getMinY() {
        return pos.getY() - 0.5 * getLargeur();
    }

    public double getMaxY() {
        return pos.getY() + 0.5 * getLargeur();

    }

    public double getMinZ() {
        return pos.getZ() + 0.5 * getLargeur();

    }

    public double getMaxZ() {
        return pos.getZ() - 0.5 * getLargeur();

    }

    // retourne coin inferieru droit
    public Coordonnee getCID() {
        return new Coordonnee(this.getMinX(), this.getMinY(), this.getMinZ());
    }

    // renvoie coin superieur gauche
    public Coordonnee getCSG() {
        return new Coordonnee(this.getMaxX(), this.getMaxY(), this.getMaxZ());
    }

    public boolean isIn(Coordonnee c) {
        boolean isin = false;
        Coordonnee coordMin = this.getCID();
        Coordonnee coordMax = this.getCSG();
        if (c.getX() >= coordMin.getX() && c.getX() <= coordMax.getX()) {
            if (c.getY() >= coordMin.getY() && c.getY() <= coordMax.getY()) {
                if (c.getZ() >= coordMin.getZ() && c.getZ() <= coordMax.getZ()) {
                    isin = true;
                }
            }
        }
        return isin;
    }

}
