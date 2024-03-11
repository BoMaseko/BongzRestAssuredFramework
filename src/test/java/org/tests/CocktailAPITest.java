package org.tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertwrapper.ResponseAssert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CocktailAPITest {

    @Test(dataProvider = "getDataForIngredient")
    public void searchIngredientByName(String ingredient){

        Response response = given().queryParam("i", ingredient)
                .when()
                .get("https://www.thecocktaildb.com/api/json/v1/1/search.php");

        System.out.println("*****************Ingredient****************************");

        ResponseAssert.assertThat(response)
                .statusCodeIs(200)
                .alcoholic("strAlcohol")
                .assertAll();

        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ingredients.json"));

        response.prettyPrint();
    }

    @Test(dataProvider = "getDataForCocktails")
    public void searchCocktailByName(String cocktail){

        Response response = given().queryParam("s", cocktail.toLowerCase())
                .when()
                .get("https://www.thecocktaildb.com/api/json/v1/1/search.php");

        System.out.println("*******************Cock-tail**************************");

        ResponseAssert.assertThat(response)
                .statusCodeIs(200)
                .isCocktailAvailable()
                .assertAll();

        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("cocktail.json"));

        response.prettyPrint();
    }

    @DataProvider
    public Object[][] getDataForIngredient(){
        return new Object[][]{
                {"vodka"},
                {"gin"}
        };
    }

    @DataProvider
    public Object[][] getDataForCocktails(){
        return new Object[][]{
                {"margarita"}
        };
    }




}
