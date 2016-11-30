/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptozoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ShadowX
 */
public class CryptoZoo {
    /*Scanner and Random*/
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();

    /*Animals and map*/
    static char[][] map = new char[51][51];
    static int[][] animalLocs = new int[10][2];
    static ArrayList<Animal> animals = new ArrayList();
    public static ArrayList<Animal> names = new ArrayList();
    static int bombcounter = 1; //player bombs
    
    //Player object
    static Player player = new Player("Hero", 25, 25, 'U');

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Zoo menagerie = new Zoo();
        choose(menagerie);
    }

/***********************************************************************
* Method: choose
* Description: Asks user what they want to do
* Parameters: Zoo z, the zoo to interact with
* Pre-conditions: main method calls, and gives the generated 
*                menagerie to interact with
* Post-conditions: Calls explore or manage zoo
***********************************************************************/
    private static void choose(Zoo z){
        boolean play = true;
        intro();
        while (play) {
            System.out.println("Would you like to 1)catch animals, 2)view your zoo, or 3) quit?");
            int choice = scan.nextInt();
            if (choice == 1) { //Uer choice
                player.health = 100;
                bombcounter = 1;
                explore(); //Catching animals
                play = !(player.health == 0);
            } else if (choice == 2){
                try {
                    manageZoo(z); //managing zoo
                } catch (InterruptedException ex) {
                    Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                play = false;
            }
        }
    }
/***********************************************************************
* Method: explore
* Description: creates safari
* Parameters: N/A
* Pre-conditions: user chooses this action in choose method
* Post-conditions: safari until user quits
***********************************************************************/
    private static void explore() {
        boolean play = true;
            makeAnimals();
        while (play) {
            try {
                play = catchAnimals();
            } catch (InterruptedException ex) {
                Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void intro() {
        System.out.println("Welcome to Zoo Tycoon.");
        System.out.println("Here, you can capture animals and add them to your zoo.");
        System.out.println("You can also put animals on tour and remove them.");
        System.out.println("Have fun!");
    }
/***********************************************************************
* Method: makeAnimals
* Description: creates list of animals
* Parameters: N/A
* Pre-conditions: called to create list of animals
* Post-conditions: list created
***********************************************************************/
    private static void makeAnimals() {
        Mythical a = new Mythical("Unicorn", "Fairyland", 6, "Rainbows, Magic, Virgins", 5, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Mythical b = new Mythical("Dragon", "Dragon Tales", 10, "Baby Feet", 8, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Mythical c = new Mythical("Narwhal", "Deep Blue Sea", 8, "Otters", 5, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Mythical d = new Mythical("Centaur", "My Little Pony", 7, "Other Centaurs", 1, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Paranormal e = new Paranormal("Nocturne", "Dreamland", 100, rand.nextInt(49) +1, rand.nextInt(49) +1);
        Paranormal f = new Paranormal("Bloody Mary", "Mirrors", 20, rand.nextInt(49) +1, rand.nextInt(49) +1);
        LingerLing g = new LingerLing("Lings", "The Swarm", 8, rand.nextInt(49) +1, rand.nextInt(49) +1);
        LingerLing h = new LingerLing("BroodLord", "Deep Space", 50, rand.nextInt(49) +1, rand.nextInt(49) +1);
        FossilRelative i = new FossilRelative("Amotherbica", "Deep Space Planet", 4, rand.nextInt(49) +1, rand.nextInt(49) +1);
        FossilRelative j = new FossilRelative("Bromeriland", "Dead Planet", 7, rand.nextInt(49) +1, rand.nextInt(49) +1);
        
        animals.add(a);
        animals.add(b);
        animals.add(c);
        animals.add(d);
        animals.add(e);
        animals.add(f);
        animals.add(g);
        animals.add(h);
        animals.add(i);
        animals.add(j);
    }


    private static boolean catchAnimals() throws InterruptedException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == player.x && j == player.y) {
                    map[i][j] = player.symbol;
                } else {
                    map[i][j] = '.';
                }

                for (Animal e : animals) {
                    if (e.isMap) {
                        if (i == e.x && j == e.y) {
                            map[i][j] = 'A';
                        }
                    }
                }
                
                if (i == 0 || i == 50 || j == 0 || j == 50) {
                    map[i][j] = 'X';
                }
                
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("Exp: " + player.xp + "     Level: " + player.level);
        System.out.println("Score: " + player.score + "     Health: " + player.health);
        Thread.sleep(500);

        if (move()) {
            return false;
        }

        checkLevel();
        
        isDead(player.x, player.y);

        return !healthDead();
    }


    private static boolean move() {
        boolean a = movePlayer();

        for (Animal e : animals) {
            e.isMap = enemyAlive(e.x, e.y);
        }

        moveEnemy();
        
        return a;
    }

    private static boolean movePlayer() {
        System.out.println("");
        System.out.println("What direction would you like to move? (N/E/S/W/NE/SE/NW/SW)");
        System.out.println("Or use an ability? (B)to stun[r1] (C)to net[r2] (D)to megabomb[r1-3] (one use)");
        System.out.println("Or (Q) to quit.");
        System.out.println("r = range of attack");
        String input = scan.next().toUpperCase();
        if (input.contains("!")) {
            player.score += 5;
        }
        if (input.contains("B")) {
            for (Animal e : animals) {
                if (((e.x == player.x + 1) || (e.x == player.x - 1) || (e.x == player.x)) && ((e.y == player.y + 1) || (e.y == player.y - 1) || (e.y == player.y))) {
                    System.out.println("Congrats! You stunned an animal and caught it!");
                    System.out.println("(+ 50 xp, + 5 score)");
                    player.score += 5;
                    player.xp += 50;
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    e.isMap = false;
                    names.add(e);
                    
                    e.x = 0;
                    e.y = 0;
                    
                    System.out.println("");
                    System.out.println("The animal:");
                    System.out.println(e.toString());
                    System.out.println("Food Type: " + e.getFoodType());
                    System.out.println("Food Amount: " + e.getFoodAmt());
                    System.out.println("______________________________________");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else if (input.contains("C")) {
            for (Animal e : animals) {
                if (((e.x == player.x + 2) || (e.x == player.x - 2) || (e.x == player.x)) && ((e.y == player.y + 2) || (e.y == player.y - 2) || (e.y == player.y))) {
                    System.out.println("Congrats! You netted an animal and caught it!");
                    System.out.println("(+ 100 xp, + 10 score)");
                    player.score += 10;
                    player.xp += 100;
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    e.isMap = false;
                    names.add(e);
                    
                    e.x = 0;
                    e.y = 0;
                    
                    System.out.println("");
                    System.out.println("The animal:");
                    System.out.println(e.toString());
                    System.out.println("Food Type: " + e.getFoodType());
                    System.out.println("Food Amount: " + e.getFoodAmt());
                    System.out.println("______________________________________");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else if (input.contains("D")) {
            if (bombcounter > 0) {
                bombcounter -= 1;
                for (Animal e : animals) {
                    if (((e.x == player.x + 2) || (e.x == player.x - 2) || (e.x == player.x) || (e.x == player.x + 1) || (e.x == player.x - 1) || (e.x == player.x + 3) || (e.x == player.x - 3)) && ((e.y == player.y + 2) || (e.y == player.y - 2) || (e.y == player.y) || (e.y == player.y + 1) || (e.y == player.y - 1) || (e.y == player.y + 3) || (e.y == player.y - 3))) {
                        System.out.println("You blew up an animal! (Whyyyy would you do that?)");
                        System.out.println("(+ 50 score)");
                        player.score += 50;
                        
                        e.isMap = false;

                        e.x = 0;
                        e.y = 0;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                System.out.println("You already used your bomb!");
            }
        }
        if (input.contains("N")) {
            if (checkWalls(player.x - player.movementspeed, player.y)) {
                player.x -= player.movementspeed;
            }
        }
        if (input.contains("E")) {
            if (checkWalls(player.y + player.movementspeed, player.x)) {
                player.y += player.movementspeed;
            }
        }
        if (input.contains("S")) {
            if (checkWalls(player.x + player.movementspeed, player.y)) {
                player.x += player.movementspeed;
            }
        }
        if (input.contains("W")) {
            if (checkWalls(player.y - player.movementspeed, player.x)) {
                player.y -= player.movementspeed;
            }
        }
        if (input.contains("Q")) {
            System.out.println("");
            return true;
        }
        return false;
    }

    private static boolean checkWalls(int a, int b) {
        boolean valid = true;
        if (map[a][b] == 'X') {
            valid = false;
        }
        return valid;
    }


    private static void moveEnemy() {
            for (Animal e : animals) {
                if (e.isMap) {
                    int xmove = rand.nextInt(3) - 1;
                    int ymove = rand.nextInt(3) - 1;
                    if (checkWalls(e.x + xmove, e.y)) {
                            e.x = e.x + xmove;
                    }
                    
                    if (checkWalls(e.x, e.y + ymove)) {
                           e.y = e.y + ymove;
                    }
                    
                    if (((e.x == player.x + 1) || (e.x == player.x - 1)) && ((e.y == player.y + 1) || (e.y == player.y - 1))) {
                            System.out.println("An animal attacked you! -20 Health");
                            player.health -= 20;
                    }
                } else {
                    e.x = 0;
                    e.y = 0;
                }
            }
    }

    private static void isDead(int pX, int pY) {
            for (Animal e : animals) {
                if (e.x == pX && e.y == pY) {
                    System.out.println("You got mauled by an enemy! -100 Health!");
                    player.health = 0;
                }
            }
    }

    private static boolean enemyAlive(int eX, int eY) {
        return !(eX == 0 && eY == 0);
    }

    private static boolean healthDead() {
        if (player.health <= 0) {
            System.out.println(" __   __                                          _            __   _                _ _   _     _ \n"
                    + " \\ \\ / /__  _   _   _ __ __ _ _ __     ___  _   _| |_    ___  / _| | |__   ___  __ _| | |_| |__ | |\n"
                    + "  \\ V / _ \\| | | | | '__/ _` | '_ \\   / _ \\| | | | __|  / _ \\| |_  | '_ \\ / _ \\/ _` | | __| '_ \\| |\n"
                    + "   | | (_) | |_| | | | | (_| | | | | | (_) | |_| | |_  | (_) |  _| | | | |  __/ (_| | | |_| | | |_|\n"
                    + "   |_|\\___/ \\__,_| |_|  \\__,_|_| |_|  \\___/ \\__,_|\\__|  \\___/|_|   |_| |_|\\___|\\__,_|_|\\__|_| |_(_)\n"
                    + "                                                                                                   ");
            System.out.println("");
            System.out.println("   ______             _            __                           _     _              __  \n"
                    + "  / / ___|  ___  _ __| |_    ___  / _|   __ _   _ __  _ __ ___ | |__ | | ___ _ __ ___\\ \\ \n"
                    + " | |\\___ \\ / _ \\| '__| __|  / _ \\| |_   / _` | | '_ \\| '__/ _ \\| '_ \\| |/ _ \\ '_ ` _ \\| |\n"
                    + " | | ___) | (_) | |  | |_  | (_) |  _| | (_| | | |_) | | | (_) | |_) | |  __/ | | | | | |\n"
                    + " | ||____/ \\___/|_|   \\__|  \\___/|_|    \\__,_| | .__/|_|  \\___/|_.__/|_|\\___|_| |_| |_| |\n"
                    + "  \\_\\                                          |_|                                   /_/ ");
            return true;
        }
        return false;
    }
    
    private static void checkLevel() {
        if (player.xp >= 100 * player.level) {
            playerLevelUp();
        }
    }

    private static void playerLevelUp() {
        player.xp = 0;
        player.level += 1;
        System.out.println("You leveled up! You are now level " + player.level + ".");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CryptoZoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
    }
    
    private static void manageZoo(Zoo z) throws InterruptedException {
        System.out.println("Welcome to your zoo! Here are your animals.");
        System.out.println("____________________________________________");
        Thread.sleep(1000);
        z.showAll();
        boolean play = true;
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
        ArrayList<Animal> remove = new ArrayList();
        System.out.println("These are the animals you've captured!");
        int counter = 0;
        for (Animal a : names) {
            counter += 1;
            System.out.println("Would you like to add the " + a.name + " to your zoo? (Y/N)");
            String add = scan.nextLine();
            if (counter == 1) {
                add = scan.nextLine();
            }
            if (add.equalsIgnoreCase("Y")) {
                remove.add(a);
                z.zooList.add(a);
            }
        }
        names.removeAll(remove);
        /*
        Adding unique animals for default CryptoZoo
        */
//        System.out.println("What animal would you like to add?");
//        String animal = scan.nextLine();
//        animal = scan.nextLine();
//        System.out.println("What type is the animal?");
//        System.out.println("1) Mythical");
//        System.out.println("2) Paranormal");
//        System.out.println("3) LingerLing");
//        System.out.println("4) FossilRelative");
//        int type = scan.nextInt();
//
//        if (type > 4 || type < 1) {
//            System.out.println("Not a valid type.");
//        } else {
//            System.out.println("Where did the animal come from?");
//            String orig = scan.nextLine();
//            orig = scan.nextLine();
//            System.out.println("How dangerous is it?");
//            int dang = scan.nextInt();
//            if (type == 1) {
//                System.out.println("What does the animal eat?");
//                String foodTyp = scan.nextLine();
//                foodTyp = scan.nextLine();
//                System.out.println("How much food does it eat per day?");
//                int foodAmt = scan.nextInt();
//                Mythical addedMyth = new Mythical(animal, orig, dang, foodTyp, foodAmt, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
//                z.zooList.add(addedMyth);
//            } else if (type == 2) {
//                Paranormal addedPara = new Paranormal(animal, orig, dang, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
//                z.zooList.add(addedPara);
//            } else if (type == 3) {
//                LingerLing addedLing = new LingerLing(animal, orig, dang, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
//                z.zooList.add(addedLing);
//            } else if (type == 4) {
//                FossilRelative addedFoss = new FossilRelative(animal, orig, dang, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
//                z.zooList.add(addedFoss);
//            }
//        }

    }

    private static void removeAnimal(Zoo z) {
        if (z.zooList.size() == 0) {
            System.out.println("You don't have any animals!");
        } else {
            System.out.println("What animal would you like to remove?");
            boolean found = false;
            String animal = scan.nextLine();
            animal = scan.nextLine();
            ArrayList<Animal> remove = new ArrayList();
            for (Animal a : z.zooList) {
                if (a.name.equals(animal)) {
                    found = true;
                    remove.add(a);
                }
            }
            z.zooList.removeAll(remove);
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
