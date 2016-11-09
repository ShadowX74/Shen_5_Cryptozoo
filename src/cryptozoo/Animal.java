/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptozoo;

/**
 *
 * @author ShadowX
 */
public abstract class Animal implements ZooAnimal{
    String name, origin;
    int dangerRating;
    int x, y;
    
    public Animal(String nam, String orig, int danger, int x, int y) {
        this.name = nam;
        this.origin = orig;
        this.dangerRating = danger;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \nOrigin: %s \nDanger Rating: %d", this.name, this.origin, this.dangerRating);
    }

          

 
    public abstract int foodPerWeek();
}
