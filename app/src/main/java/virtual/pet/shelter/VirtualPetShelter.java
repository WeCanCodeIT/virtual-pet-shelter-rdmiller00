package virtual.pet.shelter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelter {
    public Map<Integer, VirtualPet> animals = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public void intakePet() {
        System.out.print("What is the pet's name? ");
        String name = scanner.nextLine();
        System.out.print("What breed is " + name + "? ");
        String breed = scanner.nextLine();
        System.out.print("Enter ID for pet: ");
        int petID = scanner.nextInt();
        scanner.nextLine();
        VirtualPet pet = new VirtualPet(petID, name, breed);

        System.out.println("Welcome in " + name + "!");
        System.out.println("");
        animals.put(pet.getPetId(), pet);
        pet.tick();
    }

    public void checkPets() {
        System.out.println("Name \t| Hunger \t| Thirst \t| Boredom");
        System.out.println("_____\t|________\t|________\t|________");

        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            VirtualPet pet = entry.getValue();
            pet.tick();
            System.out.println(pet.getName() + " \t| " + pet.getHungerLevel() + " \t\t| " + pet.getThirstLevel()
                    + "\t\t| " + pet.getBoredomLevel());

        }
    }

    public void displayAdoptionList() {
        System.out.println("Pet ID        \t| Name        \t| Breed       ");
        System.out.println("--------------\t|-------------\t|-------------");

        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            int key = entry.getKey();
            VirtualPet pet = entry.getValue();
            System.out.println(key + " \t| " + pet.getName() + " \t| " + pet.getBreed());
            pet.tick();
        }
    }

    public void adoptPet() {
        System.out.print("What pet is being adopted today? ");
        int petId = scanner.nextInt();
        scanner.nextLine();
        VirtualPet pet = animals.get(petId);
        System.out.println("So excited that " + pet.getName() + " is getting to go home!");
        System.out.println("");
        animals.remove(petId);

    }

    public void playFetch() {
        System.out.println("ID \t| Name      \t| Boredom");
        System.out.println("_____\t|_________\t|________");

        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            VirtualPet pet = entry.getValue();
            System.out.println(pet.getPetId() + " \t|" + pet.getName() + " \t| " + pet.getBoredomLevel());
            pet.tick();
        }

        System.out.println("");
        System.out.print("Which pet would you like to play with? Enter ID: ");
        int petId = scanner.nextInt();
        scanner.nextLine();
        VirtualPet pet = animals.get(petId);
        pet.playFetch();
        System.out.println("");
    }

    public void yardTime() {
        System.out.println("");
        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            VirtualPet pet = entry.getValue();
            System.out.println(pet.getPetId() + " \t|" + pet.getName() + " \t| " + pet.getBoredomLevel());
            pet.tick();
        }
    }

    public void waterPets() {
        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            VirtualPet pet = entry.getValue();
            pet.giveWater();

        }
    }

    public void feedPets() {
        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            VirtualPet pet = entry.getValue();
            pet.giveFood();
            pet.tick();
        }
        System.out.println("What a feeding frenzy!!");
    }

    public void welfareCheck() {
        for (Map.Entry<Integer, VirtualPet> entry : animals.entrySet()) {
            VirtualPet pet1 = entry.getValue();
            if (pet1.getHungerLevel() >= 100 || pet1.getThirstLevel() >= 100) {
                System.out.println(pet1.getName()
                        + " has passed away. You need to make sure you are feeding and watering the animals more consistently. An email has been sent to the supervisor.");
                System.out.println("");
                animals.remove(pet1.getPetId());
            }
        }

    }

}
