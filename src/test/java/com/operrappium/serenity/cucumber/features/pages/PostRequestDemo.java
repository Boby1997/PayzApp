package com.operrappium.serenity.cucumber.features.pages;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequestDemo extends BasePage{
    public void postRequestDemo1() throws Throwable{
//        Map<String,Object> map = new HashMap<String , Object>();
//        map.put("name","test1");
//        map.put("job","tester");
//        System.out.println("data: "+ map);
//        JSONObject request = new JSONObject(map);
//        System.out.println("request data: "+ request);

        JSONObject request = new JSONObject();
        request.put("name","test1");
        request.put("job","tester");
        System.out.println("request data: "+ request);
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201).log().all();
    }

    public void loginBynfor(){
        JSONObject request = new JSONObject();
        request.put("username","bynforus");
        request.put("password","0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e");
        System.out.println("request data: "+ request);
        given().
                header("Content-Type","application/x-www-form-urlencoded").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://dev-gateway-api.bynfor.com/auth/oauth/token?grant_type=password&scope=webclient%20customerfrontend").
                then().
                statusCode(201).log().all();
    }
}
