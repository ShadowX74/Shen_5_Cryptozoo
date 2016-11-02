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
    
    public FossilRelative(String nam, String orig, int danger) {
        super(nam, orig, danger);
    }
    
    public int foodPerWeek() {
        return 1;
    }
    
}
