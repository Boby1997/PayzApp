package com.operrappium.serenity.cucumber.features.pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
        String URL = "https://dev-gateway-api.bynfor.com/auth/oauth/token?grant_type=password&scope=webclient%20customerfrontend";
        JSONObject request = new JSONObject();
        request.put("username","bynforus");
        request.put("password","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        System.out.println("request data: "+ request);
//        given().
//                header("Content-Type","application/x-www-form-urlencoded").
//                contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                body(request.toJSONString()).
//                when().
//                post("https://dev-gateway-api.bynfor.com/auth/oauth/token?grant_type=password&scope=webclient%20customerfrontend").
//                then().
//                statusCode(201).log().all();
//        given().auth().basic("bynforus", "0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e").when().get(URL).then().statusCode(200);

//        given().auth().preemptive()
//                .basic("customer1", "password")
//                .when()
//                .get("https://dev-gateway-api.bynfor.com/auth/oauth/token")
//                .then().log()
//                .all();
        given().when().
                queryParam("grant_type","password").
                queryParam("scope","webclient%20customerfrontend").
                queryParam("captchaToken","03AGdBq25U-JjZHNXc0N5LBpJ4tbgeH57UaC2t1XkQaqxakZu2F4bMD0hXCUXUUjlo5j1aPbtPHNsgbH5vzNMoiMh1Pg6VRMo3cc4e5DqPj_aZMLIDWRsDB4zGGF_PIdGD59kz6WtD-TTdDRrgqG_oQu8-NkNydDOYXdQoV56DR11pGajO3JA3b8wqHPlWwFjrKZvfD52Funehaiq-rd0ErHWVivfeR7JzXwVdOk4kWiNo2qU8Skvt1NFzBkQn01Ule5RIhUCrWhBM1uZKmjSRxgmAWtP0i4d5x4aS-F1EegkESeUCHPQNtTJVxQtyG_ak7_TCodCxTg98Dy-hcsNvBfkyi3F4UIGEcy9LvYMSFUqiJM8yeNwXoc-YSK7_KG2OWrfEwazN3wFv1CXVqu2Hwm5ENiLXsEIIp8wNOT7iveGCVHtDbOQVAwu28ThA4KYEvUb6i1As73PoXE6WytYBTPacf-28veYK0ZvjpBTv8HbqyTSp1y8tt_A0KrtKaCQqaHgq495Yfv6dbjBC64TJgA_9hC90N1-gNg").
                queryParam("bfsignature","1MR9XLmY9YdZedw3Cmsipkvf85CVJEMhqvBTVrDOqFaD7AgVMx3wmlVAPL6b%252Br4vferlR80RQqMkLU5bmp01gg%253D%253D").
                queryParam("bftimestamp","1640083942").
                header("Content-Type","application/x-www-form-urlencoded").
                header("Content-Length","<calculated when request is sent>").
                header("Host","<calculated when request is sent>").
                header("User-Agent","<calculated when request is sent>").
                header("Accept","*/*").
                header("Accept-Encoding","gzip, deflate, br").
                header("Connection","keep-alive").
                header("sec-ch-ua","\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"").
                header("DNT","1").
                header("Authorization","Basic and0Y2xpZW50OlBhc3MhMjM0").
                header("Content-Type","application/x-www-form-urlencoded").
                header("Accept","application/json, text/plain, */*").
                header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36").
                header("sec-ch-ua-platform","\"Windows\"").
                header("Origin","https://dev.bynfor.com").
                header("Sec-Fetch-Site","same-site").
                header("Sec-Fetch-Mode","cors").
                header("Sec-Fetch-Dest","empty").
                header("Referer","https://dev.bynfor.com/").
                header("Accept-Language","en-US,en;q=0.9").
                auth().basic("bynforus", "0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e").when()
                .post("https://dev-gateway-api.bynfor.com/auth/oauth/token")
                .then().log()
                .all();


    }

    public void loginBynfor2() throws Throwable{
        String URL = "https://dev-gateway-api.bynfor.com/auth/oauth/token";
        JSONObject request = new JSONObject();
        request.put("username","bynfor51");
        request.put("password","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
        System.out.println("request data: "+ request);
        given().
                header("Authorization","Basic and0Y2xpZW50OlBhc3MhMjM0").
                header("Content-Type","application/x-www-form-urlencoded").
                header("Accept","application/json, text/plain, */*").
                queryParam("grant_type","password").
                queryParam("scope","webclient customerfrontend").
                queryParam("bfsignature","IYf2yKnvi8OBiW%2Fnf36JjzwcjfUJzHakMhRzHDZVBXfOUEZmuQLaVgDfpSN1LVv6bAp26ByI8ru7W5%2FxiFDTQw%3D%3D").
                queryParam("password","5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8").
                queryParam("username","bynfor51").
                body(request.toJSONString()).
                post(URL).
                then().
                statusCode(200).
                log().
                all();
    }
}
