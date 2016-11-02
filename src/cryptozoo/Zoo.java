/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptozoo;

import java.util.ArrayList;

/**
 *
 * @author ShadowX
 */
public class Zoo {
    ArrayList<Animal> zooList = new ArrayList();
    
    public void list() {
        Mythical a = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 5);
        Mythical b = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical c = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical d = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical e = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical f = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical g = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical h = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical i = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        Mythical j = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 4);
        
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
    
    public void showAll() {
        for (Animal i : zooList) {
            System.out.println(i.toString());
            System.out.println("Food Type: " + i.getFoodType());
            System.out.println("Food Amount: " + i.getFoodAmt());
            System.out.println("______________________________________");
        }
    }
}
