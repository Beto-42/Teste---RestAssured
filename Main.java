package org.example;

public class Main {
    public static void main(String[] args) {

        PetStoreTests tests = new PetStoreTests();


        System.out.println("Iniciando testes da API Petstore...");

        tests.testCreatePetOrder();
        tests.testGetNonExistentPet();
        tests.testUpdatePet();
        tests.testFindPetsByStatus();

        System.out.println("Testes concluídos.");
    }


}
