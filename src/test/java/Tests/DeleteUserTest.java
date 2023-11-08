package Tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class DeleteUserTest extends BaseTest{

    String endpoint = "/users/";
    String email = "hkkdsddffdsdasjh@gmail.com";

    @Test
    public void successDelete(){
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();
        postRequest(endpoint, 201, requestBody);
        Response response = deleteRequest(endpoint+email ,200);
    }

    @Test
    public void deleteDelete(){
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();
        postRequest(endpoint, 201, requestBody);
        Response response = deleteRequest(endpoint+email ,200);
        deleteRequest(endpoint+email ,404);
    }

    @Test
    public void deleteUserFromGetMethode(){
        Response response = getRequest(endpoint+email,404);
    }

    @Test
    public void deleteInvalidUser(){
        String invalidEmail = "@ghjjkl";
        deleteRequest(endpoint+invalidEmail ,404);
    }


}