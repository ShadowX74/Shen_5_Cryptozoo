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
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Zoo menagerie = new Zoo();
        menagerie.list();
        choose(menagerie);
    }
    
    private static void choose(Zoo z) throws InterruptedException {
        System.out.println("Welcome to your zoo! Here are your animals.");
        System.out.println("____________________________________________");
        Thread.sleep(1000);
        z.showAll();
        while (play) {
            Thread.sleep(1000);
            System.out.println("");
            System.out.println("What would like to do?");
            System.out.println("1) List all animals");
            System.out.println("2) List all animals on site");
            System.out.println("3) List all animals on tour");
            System.out.println("4) Put animal on tour");
            System.out.println("5) Remove animal from touring");
            System.out.println("6) Add animal to menagerie");
            System.out.println("7) Remove animal from menagerie");
            System.out.println("8) Quit");
            int choice = scan.nextInt();
            System.out.println("");
            if (choice == 1) {
                z.showAll();
            } else if (choice == 2) {
                z.showNotTour();
            } else if (choice == 3) {
                z.showTour();
            } else if (choice == 4) {
                addTour(z);
            } else if (choice == 5) {
                removeTour(z);
            } else if (choice == 6) {
                addAnimal(z);
            } else if (choice == 7) {
                removeAnimal(z);
            } else if (choice == 8) {
                play = false;
            } else {
                System.out.println("Not a valid choice, please try again.");
            }
        }
    }
    
    private static void addAnimal(Zoo z) {
        System.out.println("What animal would you like to add?");
                String animal = scan.nextLine();
                animal = scan.nextLine();
                System.out.println("What type is the animal?");
                System.out.println("1) Mythical");
                System.out.println("2) Paranormal");
                System.out.println("3) LingerLing");
                System.out.println("4) FossilRelative");
                int type = scan.nextInt();
                
                System.out.println("Where did the animal come from?");
                String orig = scan.nextLine();
                System.out.println("How dangerous is it?");
                int dang = scan.nextInt();
                if (type == 1) {
                    System.out.println("Where does the animal eat?");
                    String foodTyp = scan.nextLine();
                    System.out.println("How much food does it eat per day?");
                    int foodAmt = scan.nextInt();
                    Mythical added = ();
                    z.zooList.add(added);
                }
                
                
    }
    
    private static void removeAnimal(Zoo z) {
        if (z.zooList.size() <= 10) {
                    System.out.println("You can't go below 10 animals!");
                } else {
                    System.out.println("What animal would you like to remove?");
                    boolean found = false;
                    String animal = scan.nextLine();
                    animal = scan.nextLine();
                    for (Animal a : z.zooList) {
                        if (a.name.equals(animal)) {
                            found = true;
                            z.zooList.remove(a);
                        }
                    }
                    if (!found) {
                        System.out.println("Animal not found.");
                    }
                }
    }
    
    private static void addTour(Zoo z) {
        System.out.println("What animal would you like to be put on tour?");
                boolean found = false;
                String animal = scan.nextLine();
                animal = scan.nextLine();
                for (Animal a : z.zooList) {
                    if (a.name.equals(animal)) {
                        found = true;
                        if (a.onTour) {
                            System.out.println("Already on tour.");
                        }
                        a.onTour = true;
                    }
                }
                if (!found) {
                    System.out.println("Animal not found.");
                }
    }
    
    private static void removeTour(Zoo z) {
        System.out.println("What animal would you like to take off tour?");
                boolean found = false;
                String animal = scan.nextLine();
                animal = scan.nextLine();
                for (Animal a : z.zooList) {
                    if (a.name.equals(animal)) {
                        found = true;
                        if (!a.onTour) {
                            System.out.println("Already not on tour.");
                        }
                        a.onTour = false;
                    }
                }
                if (!found) {
                    System.out.println("Animal not found.");
                }
    }
}
