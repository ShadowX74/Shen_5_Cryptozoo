/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptozoo;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author ShadowX
 */
public class Zoo {
    ArrayList<Animal> zooList = new ArrayList(); //Zoo
    
    static Random rand = new Random();
/***********************************************************************
* Method: list
* Description: creates zoo
* Parameters: N/A
* Pre-conditions: called to create zoo of animals
* Post-conditions: zoo created
***********************************************************************/
    public void list() {
        Mythical a = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 5, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Mythical b = new Mythical("Dragon", "Dragon Tales", 10, "Baby Feet", 8, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Mythical c = new Mythical("Narwhal", "Deep Blue Sea", 8, "Otters", 5, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Mythical d = new Mythical("Centaur", "My Little Pony", 7, "Other Centaurs", 1, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Paranormal e = new Paranormal("Nocturne", "Dreamland", 100, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Paranormal f = new Paranormal("Bloody Mary", "Mirrors", 20, rand.nextInt(49) +1, rand.nextInt(49) +1);
        LingerLing g = new LingerLing("Lings", "The Swarm", 8, rand.nextInt(49) +1, rand.nextInt(49) +1);
        LingerLing h = new LingerLing("BroodLord", "Deep Space", 50, rand.nextInt(49) +1, rand.nextInt(49) +1);
        FossilRelative i = new FossilRelative("Amotherbica", "Deep Space Planet", 4, rand.nextInt(49) +1, rand.nextInt(49) +1);
        FossilRelative j = new FossilRelative("Bromeriland", "Dead Planet", 7, rand.nextInt(49) +1, rand.nextInt(49) +1);
        
        zooList.add(a);
        zooList.add(b);
        zooList.add(c);
        zooList.add(d);
        zooList.add(e);
        zooList.add(f);
        zooList.add(g);
        zooList.add(h);
        zooList.add(i);
        zooList.add(j);
    }
    
/***********************************************************************
* Method: showAll
* Description: lists all animals
* Parameters: N/A
* Pre-conditions: called to see user's animals
* Post-conditions: all animals listed
***********************************************************************/
    public void showAll() {
        for (Animal i : zooList) {
            if (i.onTour == true) {
                System.out.println("Out On Tour");
                System.out.println("");
            }
            System.out.println(i.toString());
            System.out.println("Food Type: " + i.getFoodType());
            System.out.println("Food Amount: " + i.getFoodAmt());
            System.out.println("______________________________________");
        }
    }
/***********************************************************************
* Method: showTour
* Description: lists all animals on tour
* Parameters: N/A
* Pre-conditions: called to see user's animals on tour
* Post-conditions: all animals on tour listed
***********************************************************************/
    public void showTour() {
        for (Animal i : zooList) {
            if (i.onTour == true) {
                System.out.println("Out On Tour");
                System.out.println(i.toString());
                System.out.println("Food Type: " + i.getFoodType());
                System.out.println("Food Amount: " + i.getFoodAmt());
                System.out.println("______________________________________");
            }
        }
    }
/***********************************************************************
* Method: showNotTour
* Description: lists all animals not on tour
* Parameters: N/A
* Pre-conditions: called to see user's animals not on tour
* Post-conditions: all animals not on tour listed
***********************************************************************/
    public void showNotTour() {
        for (Animal i : zooList) {
            if (i.onTour == false) {
                System.out.println(i.toString());
                System.out.println("Food Type: " + i.getFoodType());
                System.out.println("Food Amount: " + i.getFoodAmt());
                System.out.println("______________________________________");
            }
        }
    }
}
