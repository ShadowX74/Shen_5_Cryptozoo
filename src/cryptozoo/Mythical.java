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
public class Mythical extends Animal {
    String foodType;
    int foodAmt;

    public Mythical(String nam, String orig, int danger, String food, int amt) {
        super(nam, orig, danger);
        this.foodType = food;
        this.foodAmt = amt;

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
