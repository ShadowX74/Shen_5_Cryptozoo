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
    
    private void list() {
        zooList.add(e);
    }
    
    private void showAll() {
        for (Animal i : zooList) {
            System.out.println(zooList[i].toString());
            System.out.println(zooList[i].getFoodType());
            System.out.println(zooList[i].getFoodAmt());
            System.out.println("______________________________________");
        }
    }
}
