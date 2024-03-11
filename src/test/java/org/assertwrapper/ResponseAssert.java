package org.assertwrapper;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    private static SoftAssertions softAssertions;

    private ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
        softAssertions = new SoftAssertions();
    }

    public static ResponseAssert assertThat(Response response){
        return new ResponseAssert(response);
    }

    public ResponseAssert statusCodeIs(int expectedStatusCode){
        softAssertions.assertThat(actual.statusCode()).isEqualTo(expectedStatusCode);
        System.out.println("Status code " + actual.statusCode());
        return this;
    }

    public ResponseAssert alcoholic(String key){

        String alcoholic = actual.getBody()
                .jsonPath()
                .getString("ingredients[0]." + key);

        if(alcoholic.equalsIgnoreCase("yes")){
            softAssertions.assertThat(actual.getBody()
                            .jsonPath()
                            .getString("ingredients[0].strABV"))
                    .as("Alcoholic")
                    .isNotNull();

        }else{
            softAssertions.assertThat(actual.getBody()
                            .jsonPath()
                            .getString("ingredients[0].strABV"))
                    .as("Non Alcoholic")
                    .isEqualToIgnoringCase(null);

        }


        return this;
    }

    public ResponseAssert isCocktailAvailable(){

        String cocktail = actual.getBody()
                .jsonPath()
                .getString("drinks");

        softAssertions.assertThat(cocktail)
                .as("Drinks is empty")
                .isNotNull();



        return this;
    }

    public void assertAll(){
        softAssertions.assertAll();
    }
}
