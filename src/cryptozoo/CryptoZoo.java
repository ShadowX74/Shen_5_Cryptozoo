/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptozoo;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author ShadowX
 */
public class CryptoZoo {

    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static boolean play = true;
    static int counter;
    static int goal;
    
    static char[][] map = new char[51][51];
    static int[][] animals = new int[10][2];
    
    static Player player = new Player("Hero", 25, 25, 'U');
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Zoo menagerie = new Zoo();
        menagerie.list();
        menagerie.showAll();
        
    }
    
}
