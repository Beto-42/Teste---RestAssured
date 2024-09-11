package org.example;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class PetStoreTests {
    @Test
    public void testCreatePetOrder() {
        String requestBody = "{ \"id\": 1, \"name\": \"Doggie\", \"status\": \"available\" }";

         given()
                .header("Content-Type", "application/json")
                .body(requestBody)
         .when()
                .post("https://petstore.swagger.io/v2/store/order")
         .then()
                .statusCode(200)
                .body("name", equalTo("Doggie"))
                .body("status", equalTo("available"));
    }

    @Test
    public void testGetNonExistentPet() {
            given()
            .when()
                    .get("https://petstore.swagger.io/v2/pet/999999")
            .then()
                    .statusCode(404)
                    .body("message", equalTo("Pet not found"));
    }


    @Test
    public void testUpdatePet() {
        String requestBody = "{ \"id\": 1, \"name\": \"Doggie\", \"status\": \"sold\" }";

        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
        .when()
                .put("https://petstore.swagger.io/v2/pet")
        .then()
                .statusCode(200)
                .body("status", equalTo("sold"));
    }
    @Test
    public void testFindPetsByStatus() {
        given()
                .param("status", "pending")
        .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus}")
        .then()
                .statusCode(200)
                .body("status" , everyItem(equalTo("pending")));
    }
}