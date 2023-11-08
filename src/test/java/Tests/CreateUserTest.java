package Tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest extends BaseTest{
    String endpoint = "/users/";

    @Test
    public void successfulCreateUser() {
     String email = getRandomEmail();
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();
         postRequest(endpoint, 201, requestBody);
         deleteRequest(endpoint + email , 200);

    }


    @Test
    public void CreateUserWithoutPassword() {
        String email = getRandomEmail();
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                .full_name("SFGGJSH")
                //.password("123456")
                .generate_magic_link(false)
                .build();
        Response response = postRequest(endpoint, 201, requestBody);
        deleteRequest(endpoint + email , 200);

    }

    @Test
    public void CreateUserWithoutFullName() {
        String email = getRandomEmail();
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email(email)
                //.full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();
        Response response = postRequest(endpoint, 201, requestBody);
        deleteRequest(endpoint + email , 200);

    }

    @Test
    public void CreateUserWithoutEmail() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                //.email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();
        Response response = postRequest(endpoint, 400, requestBody);


    }

    @Test
    public void CreateUserFromGetMethode() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();
        Response response = getRequest(endpoint,405);

    }
    @Test
    public void CreateUserWithTrueLink() {

        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(true)
                .build();
        Response response = getRequest(endpoint,400);

    }







}