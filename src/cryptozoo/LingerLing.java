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
public class LingerLing extends Animal {

    public LingerLing(String nam, String orig, int danger, int x, int y) {
        super(nam, orig, danger, x, y);

    }

    public void setFoodType(String food) {
    }

    public String getFoodType() {
        return "none";
    }

    public void setFoodAmt(int amt) {
    }

    public int getFoodAmt() {
        return 0;
    }

    public int foodPerWeek() {
        throw new UnsupportedOperationException("Not supported for this class");
    }
}
