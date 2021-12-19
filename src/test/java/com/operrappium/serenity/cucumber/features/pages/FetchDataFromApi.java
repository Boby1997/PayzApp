package com.operrappium.serenity.cucumber.features.pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class FetchDataFromApi extends BasePage{
    public void getDVCCodeFromApi(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("as string "+ response.asString());
        System.out.println("as getStatusCode "+ response.getStatusCode());
        System.out.println("as getBody().asString() "+ response.getBody().asString());
        System.out.println("as string "+ response.getHeader("content-type"));
    }

    public void deleteOldMessageFromAPI() throws Throwable{
//        Response response = RestAssured.delete("http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=100&afterdownload=delete");
//        String xmlResponse = response.getBody().asString();
//        System.out.println("Response .... "+ xmlResponse);
//        RestAssured.delete("http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=100&afterdownload=delete");
        deleteOldMessageFromAPI2();
    }

    public void getDataFromApiGETMethod() throws ParserConfigurationException, IOException, SAXException {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//        System.out.println("response is: "+response);
//        System.out.println("as string "+ response.asString());
        System.out.println("as getStatusCode "+ response.getStatusCode());
        System.out.println("as prettyPrint "+ response.prettyPrint());
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println("extract data: "+ jsonPath.prettyPrint());

        List<String> id = jsonPath.get("data.id");
        System.out.println("id list: "+ id);

        List<String> email = jsonPath.get("data.email");
        System.out.println("email list: "+ email);

        List<String> first_name = jsonPath.get("data.first_name");
        System.out.println("first_name list: "+ first_name);

        List<String> last_name = jsonPath.get("data.last_name");
        System.out.println("last_name list: "+ last_name);

        List<String> avatar = jsonPath.get("data.avatar");
        System.out.println("avatar list: "+ avatar);
    }

    public int returnStatusCode(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public void getAndPrintFirstAndLastUserData(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        JsonPath jsonPath = new JsonPath(response.asString());
//        System.out.println("extract data: "+ jsonPath.prettyPrint());
        String firstUserEmail = jsonPath.get("data[0].email");
        System.out.println("firstUserEmail: "+ firstUserEmail);
    }


}
