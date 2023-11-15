import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nombreJeton = 10;
        int nombreJetonJoue = 1;
        int desUn ;
        int desDeux ;
        int totalDes;
        int but = 0;
        boolean firstLaps;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (nombreJeton !=0 || nombreJetonJoue != 0){
            firstLaps =true;
            System.out.println("Vous avez " +nombreJeton+" jetons");
            System.out.println("Combien voulez vous miser ? (0 pour arrêter) :");
            nombreJetonJoue = scanner.nextInt();
            if (nombreJetonJoue < 1 || nombreJetonJoue > nombreJeton){
                System.out.println("Vous essayez de rouler le casino. Recommencez.");
            }else if(nombreJetonJoue == 0) {
                System.out.println("A bientôt !");
            }else {
                do {
                    desUn = random.nextInt(6) + 1;
                    desDeux = random.nextInt(6) + 1;
                    totalDes = desDeux + desUn;
                    System.out.println("Vous avez lancé "+desUn+" et "+desDeux+". La somme est "+totalDes+".");
                    if(firstLaps){
                        if(totalDes == 7 || totalDes == 11){
                            nombreJeton += nombreJetonJoue;
                            System.out.println("Vous avez gangé! ");
                            totalDes = 7;
                        }else if(totalDes == 2||totalDes == 3||totalDes == 12){
                            nombreJeton -= nombreJetonJoue;
                            System.out.println("Vous avez perdu! ");
                            totalDes = 7;
                        }else {
                            but = totalDes;
                            System.out.println("Votre but est "+but+".");
                        }
                        firstLaps = false;
                    }else{
                        if(totalDes == but){
                            nombreJeton += nombreJetonJoue;
                            System.out.println("Vous avez gangé! ");
                            totalDes = 7;
                        }else if (totalDes ==7){
                            nombreJeton -= nombreJetonJoue;
                            System.out.println("Vous avez perdu! ");
                        }
                    }

                }while (totalDes != 7);
            }


        }
    }
}