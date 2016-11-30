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

/***********************************************************************
* Method: setFoodType
* Description: nothing
* Parameters: N/A
* Pre-conditions: not used for this class
* Post-conditions: nothing
***********************************************************************/
    public void setFoodType(String food) {
    }

/***********************************************************************
* Method: getFoodType
* Description: returns food type
* Parameters: N/A
* Pre-conditions: called to see food typerequired in stats
* Post-conditions: returned food type "none"
***********************************************************************/
    public String getFoodType() {
        return "none";
    }

/***********************************************************************
* Method: setFoodAmt
* Description: nothing
* Parameters: N/A
* Pre-conditions: not used for this class
* Post-conditions: nothing
***********************************************************************/
    public void setFoodAmt(int amt) {
    }

/***********************************************************************
* Method: getFoodAmount
* Description: returns food amount
* Parameters: N/A
* Pre-conditions: called to see how much food required in stats
* Post-conditions: returned amount 0
***********************************************************************/
    public int getFoodAmt() {
        return 0;
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
