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

    public Mythical(String nam, String orig, int danger, String food, int amt, int x, int y) {
        super(nam, orig, danger, x, y);
        this.foodType = food;
        this.foodAmt = amt;

    }

/***********************************************************************
* Method: setFoodType
* Description: sets food type
* Parameters: N/A
* Pre-conditions: called to set food type
* Post-conditions: type set
***********************************************************************/
    public void setFoodType(String food) {
       this.foodType = food;
    }
/***********************************************************************
* Method: getFoodType
* Description: returns food type
* Parameters: N/A
* Pre-conditions: called to see food type required in stats
* Post-conditions: returned food type
***********************************************************************/
    public String getFoodType() {
        return this.foodType;
    }
/***********************************************************************
* Method: setFoodAmount
* Description: sets food amount
* Parameters: N/A
* Pre-conditions: sets food amount
* Post-conditions: amount set
***********************************************************************/
    public void setFoodAmt(int amt) {
        this.foodAmt = amt;
    }
    
/***********************************************************************
* Method: getFoodAmount
* Description: returns food amount
* Parameters: N/A
* Pre-conditions: called to see how much food required in stats
* Post-conditions: returned amount
***********************************************************************/
    public int getFoodAmt() {
        return this.foodAmt;
    }

/***********************************************************************
* Method: foodPerWeek
* Description: returns food amount per week
* Parameters: N/A
* Pre-conditions: called to see how much food required in stats
* Post-conditions: not supported
***********************************************************************/
    public int foodPerWeek() {
        throw new UnsupportedOperationException("Not supported for this class");
    }
}
