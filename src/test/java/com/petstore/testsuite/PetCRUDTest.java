package com.petstore.testsuite;

import io.restassured.response.Response;
import com.petstore.model.PetPojo;
import com.petstore.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetCRUDTest extends TestBase {

    @Test
    public void addNewPet() {

        PetPojo petPojo = new PetPojo();

        petPojo.setId(105);

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 5);
        newCategory.put("name", "Cat");
        petPojo.setCategory(newCategory);

        petPojo.setName("Poochu");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fcatastic.pet%2Fcat-breeds%2F11-fun-facts-about-tabby-cat%2F&psig=AOvVaw0tNqe9Q6z1VZOFGGguOVWP&ust=1672427102352000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOjW9szCn_wCFQAAAAAdAAAAABAJ");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 1);
        tagHash.put("name", "Domesticated");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response=given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post("/pet");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void findPetById(){
        Response response=given()
                .when()
                .get("/pet/105");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateExistingPetDetail(){
        PetPojo petPojo = new PetPojo();

        petPojo.setId(105);

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 5);
        newCategory.put("name", "Cat");
        petPojo.setCategory(newCategory);

        petPojo.setName("Poochupendra");

        List<Object> newList = new ArrayList<>();
        newList.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fcatastic.pet%2Fcat-breeds%2F11-fun-facts-about-tabby-cat%2F&psig=AOvVaw0tNqe9Q6z1VZOFGGguOVWP&ust=1672427102352000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCOjW9szCn_wCFQAAAAAdAAAAABAJ");
        petPojo.setPhotoUrls(newList);

        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 1);
        tagHash.put("name", "Domesticated");
        tagList.add(tagHash);
        petPojo.setTags(tagList);

        petPojo.setStatus("available");

        Response response=given()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .put("/pet/");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deletePet(){

        Response response=given()
                .header("Content-Type", "application/json")
                .when()
                .delete("/pet/105");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
