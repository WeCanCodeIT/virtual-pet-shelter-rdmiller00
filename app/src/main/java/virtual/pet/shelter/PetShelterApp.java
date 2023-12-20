
package virtual.pet.shelter;

import java.util.Scanner;

public class PetShelterApp {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Cumberland County Shelter Employee Dashboard \n");

        VirtualPetShelter petShelter = new VirtualPetShelter();
        

        int userChoice;
    do{
        System.out.println("What would you like to do today?");
        System.out.println("________________________________");
        System.out.println("");
        System.out.println("Enter 1 to intake pet                 / \\__          ");
        System.out.println("Enter 2 to adopt a pet               (     @\\____    ");
        System.out.println("Enter 3 to play fetch                 /          O   ");
        System.out.println("Enter 4 to let all animals out       /   (_____ /     ");
        System.out.println("Enter 5 to feed and water animals   /_____/   U       ");
        System.out.println("Enter 6 to check all pets");
        System.out.println("Enter 7 to clock out");
        System.out.print("Enter Input Here: ");

        userChoice = scanner.nextInt();
        

        switch (userChoice) {
            case 1:
            System.out.println("");
            petShelter.intakePet();
            break;

            case 2:
            System.out.println("");
            petShelter.displayAdoptionList();
            petShelter.adoptPet();
            break;

            case 3:
            System.out.println("");
            petShelter.playFetch();
            break;

            case 4:
            petShelter.yardTime();
            break;
            
            case 5:
            petShelter.waterPets();
            petShelter.feedPets();
            break;
            
            case 6: 
            petShelter.checkPets();
            break;
            
            case 7:
            System.exit(userChoice);
            default:
                System.out.println("Invalid choice. Please enter 1-7!");
                break;


    }   
    
    petShelter.welfareCheck();

    
    } while (userChoice != 7);
        scanner.close();
}
}
