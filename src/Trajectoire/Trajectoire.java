/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trajectoire;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Aurel
 */
public class Trajectoire {

    private List<Coordonnee> pos;

    public Trajectoire() {
        this.pos = new ArrayList<Coordonnee>();
    }

    public void vide() {
        pos.clear();
    }

    public void readDOM(String path, String filename) throws SAXException, IOException {

        String ns = "http://www.univ-grenoble-alpes.fr/trajectoires";
        DOMParser parser = new DOMParser();
        parser.parse(path + "" + filename);
        Document racine = parser.getDocument();

        // récupère la liste des éléments nommés tr:pos
        NodeList posList = racine.getElementsByTagNameNS(ns, "tr:pos");

        for (int i = 0; i < posList.getLength(); i++) {
            Element pos = (Element) posList.item(i);
            
            Element x = (Element) pos.getElementsByTagNameNS(ns, "tr:x").item(0);
            Element y = (Element) pos.getElementsByTagNameNS(ns, "tr:x").item(0);
            Element z = (Element) pos.getElementsByTagNameNS(ns, "tr:x").item(0);
            
            System.out.println("x = " + x.getNodeValue());
            System.out.println("y = " + y.getNodeValue());
            System.out.println("z = " + z.getNodeValue());

        }

        this.vide();

        Coordonnee c;
        // parcoure la liste posList

        // récupère les valeurs x, y, z EN UTILISANT "getChildNodes()" et "item(...)"
        // attention, il faut convertir les String en entiers (int)
        // instancie une coordonnée avec les valeurs x, y, z
        // ajoute cette coordonnée à la liste de coordonnées
    }

    public boolean ajoute(Coordonnee c) {
        this.pos.add(c);
        return true;
    }

    public boolean ajoute(Etape e) {
        boolean ajoute = false;
        if (pos.size() >= 1) {
            if (this.pos.get(pos.size() - 1).isEqual(e.getDepart())) {
                pos.add(e.getArrive());
                ajoute = true;
            }
        } else {
            pos.add(e.getDepart());
            pos.add(e.getArrive());
            ajoute = true;
        }
        return ajoute;
    }

    public double distance() {
        double distance = 0.0d;
        System.out.println("taille du tableau : " + pos.size());
        if (pos.size() >= 2) {
            System.out.println("+ de 2 coordonne ");
            for (int i = 0; i < pos.size() - 1; i++) {
                Etape e = new Etape(pos.get(i), pos.get(i + 1));
                distance += e.distance();
            }
        } else {
            System.out.println("- de 2 coordonne ");

        }
        return distance;
    }

    @Override
    public String toString() {
        String s = "";
        if (pos.size() == 0) {
            s += "Aucun point enregistre";
        } else if (pos.size() == 1) {
            s += "Il n'y a qu'un point enregistre : " + pos.get(0).toString();
        } else {
            Etape etape = new Etape(pos.get(0), pos.get(1));
            s += " [etape " + 1 + "] " + etape.toString();
            for (int i = 1; i < pos.size() - 1; i++) {
                s += " [etape " + (i + 1) + "] ";
                etape.set(pos.get(i), pos.get(i + 1));
                s += etape.toString();
            }
        }
        return s;
    }
}
