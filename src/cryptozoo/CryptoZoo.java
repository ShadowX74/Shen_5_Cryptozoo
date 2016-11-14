/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptozoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ShadowX
 */
public class CryptoZoo {

    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
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
        boolean play = true;
        while (play) {
            System.out.println("Would you like to 1)catch animals or 2)view your zoo?");
            int choice = scan.nextInt();
            if (choice == 1) {
                safari();
            } else {
                manageZoo(z);
            }
        }
    }
    
    private static ArrayList<String> safari() {
        ArrayList<String> caught = new ArrayList();
        explore(caught);
        return caught;
    }
    
    private static void explore(ArrayList<String> names) {
        boolean play = true;
    }
        
//    static BasicEnemy[] basicEnemies = new BasicEnemy[3]; //Array for tracking enemies 5 pts
//
//    static Player player = new Player("Hero", 25, 25, 'U');
//
//    public static void game() {
//        intro();
//        while (play) {
//            setup();
//            while (play) {
//                while (gameLevel == 1) {
//                    try {
//                        levelOne();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(ArrayInput.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                while (gameLevel == 2) {
//                    try {
//                        levelTwo();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(ArrayInput.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//            playAgain();
//        }
//    }
//
//    private static void setup() {
//        makeEnemies();
//        counter = 0;
//        goal = rand.nextInt(6) + 10;
//    }
//
//
//    private static void makeEnemies() {
//        for (int i = 0; i < basicEnemies.length; i++) {
//            basicEnemies[i] = new BasicEnemy(rand.nextInt(49) + 1, rand.nextInt(49) + 1, 'E');
//            basicEnemies[i].isAlive = true;
//        }
//    }
//
//
//    //Multiple levels 10 pts
//    private static void levelOne() throws InterruptedException {
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                if (i == player.x && j == player.y) {
//                    map[i][j] = player.symbol;
//                } else if (i == 0 || i == 50 || j == 0 || j == 50) {
//                    map[i][j] = 'X';
//                } else {
//                    map[i][j] = '.';
//                }
//
//                for (TreasureChests e : treasures) {
//                    if (i == e.x && j == e.y) {
//                        if (e.x == 0 && e.y == 0) {
//                            map[i][j] = 'X';
//                        } else {
//                            map[i][j] = 'T';
//                        }
//                    }
//                }
//
//                for (BasicEnemy e : basicEnemies) {
//                    if (e.isAlive) {
//                        if (i == e.x && j == e.y) {
//                            map[i][j] = e.symbol;
//                        }
//                    }
//                }
//
//                for (int[] array : traps) {
//                    if (i == array[0] && j == array[1]) {
//                        map[i][j] = '*';
//                    }
//                }
//
//                //defined level maps 5 pts
//                if ((i % 10 == 0 && j < 12) || (i % 10 == 0 && j > 38)) {
//                    map[i][j] = 'X';
//                }
//
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println("");
//        }
//
//        System.out.println("Exp: " + player.xp + "     Level: " + player.level);
//        System.out.println("Score: " + player.score + "     Health: " + player.health);
//        Thread.sleep(500);
//
//        move();
//
//        isDead(player.x, player.y);
//
//        isTrapped(player.x, player.y);
//
//        if (healthDead()) {
//            play = false;
//            gameLevel = 0;
//        }
//
//        checkLevel();
//
//        if (isLevelWon(15)) {
//            player.score = 0;
//            Thread.sleep(2000);
//        }
//    }
//
//
//    private static void move() {
//        movePlayer();
//
//        for (BasicEnemy e : basicEnemies) {
//            e.isAlive = enemyAlive(e.x, e.y);
//        }
//
//        moveEnemy();
//    }
//
//    private static void movePlayer() {
//        counter += 1;
//        System.out.println("What direction would you like to move? (N/E/S/W/NE/SE/NW/SW) (B) to stun or (Q) to quit.");
//        String input = scan.next().toUpperCase();
//        if (input.contains("!")) {
//            player.score += 5;
//        }
//        if (input.contains("B")) { // Ability player can use 5 pts
//            if (gameLevel == 1) {
//                for (BasicEnemy e : basicEnemies) {
//                    if (((e.x == player.x + 1) || (e.x == player.x - 1) || (e.x == player.x)) && ((e.y == player.y + 1) || (e.y == player.y - 1) || (e.y == player.y))) {
//                        e.stun = true;
//                        e.stuncounter = 3;
//                    }
//                }
//            } else if (gameLevel == 2) {
//                for (AdvancedEnemy e : advancedEnemies) {
//                    if (((e.x == player.x + 1) || (e.x == player.x - 1) || (e.x == player.x)) && ((e.y == player.y + 1) || (e.y == player.y - 1) || (e.y == player.y))) {
//                        e.stun = true;
//                        e.stuncounter = 2;
//                    }
//                }
//            }
//        }
//        if (input.contains("N")) {
//            if (checkWalls(player.x - player.movementspeed, player.y)) {
//                player.x -= player.movementspeed;
//            }
//        }
//        if (input.contains("E")) {
//            if (checkWalls(player.y + player.movementspeed, player.x)) {
//                player.y += player.movementspeed;
//            }
//        }
//        if (input.contains("S")) {
//            if (checkWalls(player.x + player.movementspeed, player.y)) {
//                player.x += player.movementspeed;
//            }
//        }
//        if (input.contains("W")) {
//            if (checkWalls(player.y - player.movementspeed, player.x)) {
//                player.y -= player.movementspeed;
//            }
//        }
//        if (input.contains("Q")) {
//            System.out.println("Ok, bye!");
//            play = false;
//            gameLevel = 0;
//        }
//    }
//
//    private static boolean checkWalls(int a, int b) {
//        boolean valid = true;
//        if (map[a][b] == 'X') {
//            valid = false;
//        }
//        return valid;
//    }
//
//
//    private static void moveEnemy() {
//        if (gameLevel == 1) {
//            for (BasicEnemy e : basicEnemies) {
//                if (e.stun) {
//                    e.stuncounter -= 1;
//                    if (e.stuncounter == 0) {
//                        e.stun = false;
//                    }
//                } else if (e.isAlive) {
//                    //walls block enemy movement 5 pts
//                    if (e.movedirection(player.x, e.x)) {
//                        if (checkWalls(e.x + e.movelength, e.y)) {
//                            e.x = e.move(player.x, e.x);
//                        }
//                    } else if (!e.movedirection(player.x, e.x)) {
//                        if (checkWalls(e.x - e.movelength, e.y)) {
//                            e.x = e.move(player.x, e.x);
//                        }
//                    }
//                    if (e.movedirection(player.y, e.y)) {
//                        if (checkWalls(e.y + e.movelength, e.x)) {
//                           e.y = e.move(player.y, e.y);
//                        }
//                    } else if (!e.movedirection(player.y, e.y)) { 
//                        if (checkWalls(e.y - e.movelength, e.x)) {
//                            e.y = e.move(player.y, e.y);
//                        }
//                    }
//                    if (((e.x == player.x + 1) || (e.x == player.x - 1) || (e.x == player.x)) && ((e.y == player.y + 1) || (e.y == player.y - 1) || (e.y == player.y))) {
//                        if (player.weapon.equals("Sword")) {
//                            System.out.println("You got attacked by an enemy, but fought him off with your sword!");
//                            System.out.println("- 10 Health    + 100 Exp");
//                            player.health -= 10;
//                            player.xp += 100;
//                            player.score += 5;
//                            e.isAlive = false;
//                            e.x = 0;
//                            e.y = 0;
//                        } else {
//                            System.out.println("The enemy attacked you! - " + e.attack(e, gameLevel) + " Health");
//                            player.health -= e.attack(e, gameLevel);
//                        }
//                    }
//                } else {
//                    e.x = 0;
//                    e.y = 0;
//                }
//            }
//        }
//    }
//
//    private static void isDead(int pX, int pY) {
//        if (gameLevel == 1) {
//            for (BasicEnemy e : basicEnemies) {
//                if (e.x == pX && e.y == pY) {
//                    System.out.println("You got attacked by an enemy! - 30 Health");
//                    player.health -= 30;
//                    e.isAlive = false;
//                    e.x = 0;
//                    e.y = 0;
//
//                }
//            }
//        }
//    }
//
//    private static boolean enemyAlive(int eX, int eY) {
//        if (eX == 0 && eY == 0) {
//            return false;
//        }
//        return true;
//    }
//
//    private static boolean healthDead() {
//        if (player.health <= 0) {
//            System.out.println(" __   __                                          _            __   _                _ _   _     _ \n"
//                    + " \\ \\ / /__  _   _   _ __ __ _ _ __     ___  _   _| |_    ___  / _| | |__   ___  __ _| | |_| |__ | |\n"
//                    + "  \\ V / _ \\| | | | | '__/ _` | '_ \\   / _ \\| | | | __|  / _ \\| |_  | '_ \\ / _ \\/ _` | | __| '_ \\| |\n"
//                    + "   | | (_) | |_| | | | | (_| | | | | | (_) | |_| | |_  | (_) |  _| | | | |  __/ (_| | | |_| | | |_|\n"
//                    + "   |_|\\___/ \\__,_| |_|  \\__,_|_| |_|  \\___/ \\__,_|\\__|  \\___/|_|   |_| |_|\\___|\\__,_|_|\\__|_| |_(_)\n"
//                    + "                                                                                                   ");
//            System.out.println("");
//            System.out.println("   ______             _            __                           _     _              __  \n"
//                    + "  / / ___|  ___  _ __| |_    ___  / _|   __ _   _ __  _ __ ___ | |__ | | ___ _ __ ___\\ \\ \n"
//                    + " | |\\___ \\ / _ \\| '__| __|  / _ \\| |_   / _` | | '_ \\| '__/ _ \\| '_ \\| |/ _ \\ '_ ` _ \\| |\n"
//                    + " | | ___) | (_) | |  | |_  | (_) |  _| | (_| | | |_) | | | (_) | |_) | |  __/ | | | | | |\n"
//                    + " | ||____/ \\___/|_|   \\__|  \\___/|_|    \\__,_| | .__/|_|  \\___/|_.__/|_|\\___|_| |_| |_| |\n"
//                    + "  \\_\\                                          |_|                                   /_/ ");
//            return true;
//        }
//        return false;
//    }
    
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
        System.out.println("What animal would you like to add?");
        String animal = scan.nextLine();
        animal = scan.nextLine();
        System.out.println("What type is the animal?");
        System.out.println("1) Mythical");
        System.out.println("2) Paranormal");
        System.out.println("3) LingerLing");
        System.out.println("4) FossilRelative");
        int type = scan.nextInt();

        if (type > 4 || type < 1) {
            System.out.println("Not a valid type.");
        } else {
            System.out.println("Where did the animal come from?");
            String orig = scan.nextLine();
            orig = scan.nextLine();
            System.out.println("How dangerous is it?");
            int dang = scan.nextInt();
            if (type == 1) {
                System.out.println("What does the animal eat?");
                String foodTyp = scan.nextLine();
                foodTyp = scan.nextLine();
                System.out.println("How much food does it eat per day?");
                int foodAmt = scan.nextInt();
                Mythical addedMyth = new Mythical(animal, orig, dang, foodTyp, foodAmt, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
                z.zooList.add(addedMyth);
            } else if (type == 2) {
                Paranormal addedPara = new Paranormal(animal, orig, dang, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
                z.zooList.add(addedPara);
            } else if (type == 3) {
                LingerLing addedLing = new LingerLing(animal, orig, dang, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
                z.zooList.add(addedLing);
            } else if (type == 4) {
                FossilRelative addedFoss = new FossilRelative(animal, orig, dang, rand.nextInt(49) + 1, rand.nextInt(49) + 1);
                z.zooList.add(addedFoss);
            }
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
