package canady_3_interactivefiction;

import java.util.Scanner;
//import java.util.Timer;
//import java.util.TimerTask;

public class Canady_3_interactiveFiction {

    public int progress = 0;
    public static boolean play = true;
    public static boolean start = false;
    static Scanner sc = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {//#while
        while (play) {  //the while loop with boolean allows me to end end the game
                        //by setting it to false, or repeating otherwise
            game();
        }
    }//END OF MAIN CLASS

    public static void game() { //#method1
                                 //this is just the beginning/intro that starts the method train
        System.out.println(
                "You are walking home from work.\n"
                + "A row of stores is on your left.\n"
                + "From the corner of your eye, \n"
                + "you spot a scary-looking guy several meters behind you.\n"
                + "He is definitely following you.\n"
                + "Keep walking, or go to your car?");
//        start = true;
//        while (start) {
        input = sc.nextLine().toLowerCase();
        if (input.contains("car")) { //CAR START
            car();
        } else if (input.contains("keep") || input.contains("walk")) { //WALK START
            walk();//each method leads to another, most of my 30ish methods are just node and choice
        }
    }

    public static void gameover() { //#method2
                                      //#lose
        System.out.println("Try again? (y/n)");//This lets them choose to try again, and will end if they choose no, or run the start method if they do
        input = sc.nextLine().toLowerCase();
        if (input.contains("y")) {
            game();
        } else {
            System.out.println("Goodbye!");
            play = false;
        }
    }

    public static void wrong() {//#method3
                                //this runs if the parsing fails, along with the method/node repeating itself
        System.out.println("That input wasn't recognized, try again.");
    }
                                //all following methods are just nodes
    public static void car() {//#method4
        System.out.println(
                "You start towards your car.\n"
                + "Once you reach the car, he is already near.\n"
                + "Putting in your key and opening the door takes too long,\n"
                + "and the guy is right behind you. Run, or fight?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("run")) {
            run2();
        } else if (input.contains("fight")) {
            fight();
        } else {
            wrong();
            car();
        }
    }

    public static void walk() {//#method5
        System.out.println(
                "You continue along the street,\n"
                + "but it won't work for long.\n"
                + "Start running, or hide?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("run")) {
//            timer();
            run1();
        } else if (input.contains("hide")) {
            hide();
        } else {
            wrong();
            walk();
        }
    }

    public static void hide() {
        System.out.println(
                "You sneak into a clothing store. \n"
                + "You might as well buy something \n"
                + "to take your mind off of the situation.\n"
                + "Buy something, or not?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("don") && input.contains("buy")) {
            nobuy();
        } else if (input.contains("buy")) {
            buy();
        } else if (input.contains("no") || input.contains("don")) {
            nobuy();
        } else {
            wrong();
            hide();
        }
    }

    public static void run1() {
        System.out.println(
                "You start to run, but this thug\n"
                + "is determined to take you out.\n"
                + "He pulls out a gun.\n"
                + "Quick, dodge!");
        input = sc.nextLine().toLowerCase();
        if (input.contains("dodge")) {
            dodge();
        } else {
            dFail();
        }
    }

    public static void dodge() {
        System.out.println(
                "You jump into the crowd.\n"
                + "His gun fires and misses.\n"
                + "You run away.");
        run2();
    }

    public static void dFail() {
        System.out.println(
                "You didn't dodge in time.\n"
                + "He shoots you and you die.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void fight() {
        System.out.println(
                "You turn to fight, and he pulls out a gun.\n"
                + "Take cover, or try to disarm him?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("cover")) {
            cover();
        } else if (input.contains("disarm")) {
            disarm();
        } else {
            wrong();
            fight();
        }
    }

    public static void cover() {
        System.out.println(
                "The thug walks around the car with the gun.\n"
                + "You try to get up, but he shoots you.\n"
                + "You die.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void disarm() {
        System.out.println(
                "You rush up and try to take the gun.\n"
                + "Your bravery is rewarded,\n"
                + "as he didn't have the gun ready.\n"
                + "You take the gun.\n"
                + "Shoot him, or run away?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("run")) {
            run3();
        } else if (input.contains("shoot")) {
            shoot();
        } else {
            wrong();
            disarm();
        }
    }

    public static void shoot() {
        System.out.println(
                "You shoot the thug. Luckily, nobody hears.\n"
                + "You get in the car, and start to drive home.\n"
                + "Take a shortcut, or drive the long way?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("short")) {
            shortcut();
        } else if (input.contains("long")) {
            longway();
        } else {
            wrong();
            shoot();
        }
    }

    public static void run3() {
        System.out.println(
                "With the gun in your hands, you start to run.\n"
                + "A police officer catches you and you are arrested.\n"
                + "You get fined for using a gun in public,\n"
                + "and then go on with your life.\n"
                + "========\n"
                + "|||WIN???|||\n"
                + "========");//#win
        gameover();
    }

    public static void shortcut() {
        System.out.println(
                "You take the short way home through a back road.\n"
                + "The dirt road looks worse than usual, maybe it rained?\n"
                + "Keep going, or turn back?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("keep") || input.contains("go")) {
            shortcut2();
        } else if (input.contains("turn") || input.contains("back")) {
            longway();
        } else {
            wrong();
            run2();
        }
    }

    public static void shortcut2() {
        System.out.println(
                "You keep going down the sketchy road.\n"
                + "Your car loses traction and runs into a tree.\n"
                + "You die.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void longway() {
        System.out.println(
                "You drive the long way home.\n"
                + "You are exhausted and truamatized\n"
                + "because you just killed a man.\n"
                + "========\n"
                + "|||WIN???|||\n"
                + "========");//#win
        gameover();
    }

    public static void run2() {
        System.out.println(
                "You run and the thug takes your car. \n"
                + "He doesn't chase you, so you are probably safe.\n"
                + "Walk home, or take the bus?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("bus")) {
            bus();
        } else if (input.contains("walk") || input.contains("home")) {
            walk2();
        } else {
            wrong();
            run2();
        }
    }

    public static void walk2() {
        System.out.println(
                "You start walking. Your house is pretty far away.\n"
                + "Walk all the way home, or call your friend to pick you up?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("call") || input.contains("fr")) {
            pickup();
        } else if (input.contains("walk") || input.contains("home")) {
            walk5();
        } else {
            wrong();
            walk2();
        }
    }

    public static void walk5() {
        System.out.println(
                "You walk home. It was a long day, but you made it.\n"
                + "=====\n"
                + "|||WIN|||\n"
                + "=====");//#win
        gameover();
    }

    public static void pickup() {
        System.out.println(
                "You friend comes and picks you up.\n"
                + "They look really tired.\n"
                + "The friend falls asleep at the wheel\n"
                + "on the way home. you both die\n"
                + "in a car crash.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void bus() {
        System.out.println(
                "You take the bus home, but it doesn't\n"
                + "go all the way to your house.\n"
                + "You are now in an unfamiliar part of town.\n"
                + "Try to walk home, or take another bus?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("take") || input.contains("bus")) {
            bus2();
        } else if (input.contains("walk") || input.contains("home")) {
            walk3();
        } else {
            wrong();
            bus();
        }
    }

    public static void bus2() {
        System.out.println(
                "This next bus comes sputtering up.\n"
                + "It's really dirty and might not even work.\n"
                + "You get a strange sense of forboding from it.\n"
                + "Do you really want to get on this bus?\n"
                + "Walk home, or ride bus?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("take") || input.contains("bus")) {
            bus3();
        } else if (input.contains("walk") || input.contains("home")) {
            walk4();
        } else {
            wrong();
            bus2();
        }
    }

    public static void walk4() {
        System.out.println(
                "You walk home, a little weirded out by that bus.\n"
                + "The sketchy bus drives onto the sidewalk\n"
                + "and hits you as you start to walk home.\n"
                + "You die.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void bus3() {
        System.out.println(
                "You get on the bus. As you ride, you feel\n"
                + "a weird sensation of going back in time.\n"
                + "You pass out.");
        game();
    }

    public static void walk3() {
        System.out.println(
                "You don't really know where you're going,\n"
                + "and you become very lost. Several days later,\n"
                + "you arrive home nearly-dead and very tired.\n"
                + "========\n"
                + "|||WIN???|||\n"
                + "========\n");//#win
        gameover();
    }

    public static void buy() {
        System.out.println(
                "You don't have a lot of money,\n"
                + "but you decide to buy something.\n"
                + "Buy shoes, or a shirt?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("sho")) {
            buy1();
        } else if (input.contains("shir")) {
            buy2();
        } else {
            wrong();
            buy();
        }
    }

    public static void nobuy() {
        System.out.println(
                "You leave the store.\n"
                + "The thug was waiting, and recognizes you\n"
                + "because you look exactly the same.\n"
                + "The thug stabs you in the back.\n"
                + "You die.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void buy1() {
        System.out.println(
                "You buy shoes and leave the store.\n"
                + "The thug was waiting, and recognizes you\n"
                + "because you look exactly the same.\n"
                + "The thug stabs you in the back.\n"
                + "You die.\n"
                + "=============\n"
                + "|||GAME OVER|||\n"
                + "=============");//#lose
        gameover();
    }

    public static void buy2() {
        System.out.println(
                "You buy a shirt and leave the store.\n"
                + "You don't look back just in case the thug\n"
                + "was waiting for you.\n"
                + "Now you have to get home.\n"
                + "Walk home, or take the bus?");
        input = sc.nextLine().toLowerCase();
        if (input.contains("walk") || input.contains("home")) {
            walk2();
        } else if (input.contains("take") || input.contains("bus")) {
            bus();
        } else {
            wrong();
            buy2();
        }
    }
}
