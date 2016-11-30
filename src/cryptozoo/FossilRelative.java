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
public class FossilRelative extends LingerLing{
    
    public FossilRelative(String nam, String orig, int danger, int x, int y) {
        super(nam, orig, danger, x, y);
    }
/***********************************************************************
* Method: foodPerWeek
* Description: returns food amount
* Parameters: N/A
* Pre-conditions: called to see how much food required in stats
* Post-conditions: returned 1
***********************************************************************/
    public int foodPerWeek() {
        return 1;
    }
    
}
