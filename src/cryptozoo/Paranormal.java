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
public class Paranormal extends Animal {
    String foodType;
    int foodAmt;
    
    public Paranormal(String nam, String orig, int danger, int x, int y) {
        super(nam, orig, danger, x, y);
        this.foodType = "meat";
        this.foodAmt = 5;
    }

    public void setFoodType(String food) {
       this.foodType = food;
    }

    public String getFoodType() {
        return this.foodType;
    }

    public void setFoodAmt(int amt) {
        this.foodAmt = amt;
    }

    public int getFoodAmt() {
        return this.foodAmt;
    }

   
    public int foodPerWeek() {
        throw new UnsupportedOperationException("Not supported for this class");
    }

}
    