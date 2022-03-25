package services;

import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    private UserDAO userDAO = Mockito.mock(UserDAO.class);

    public UserServiceTest(){
        this.userService = new UserService(userDAO);
    }

    @Test
    void getByUsernameIsWrongUsername() {
        String expectedUsername = "incorrectusername";
        String expectedPassword = "pass123";
        User expectedOutput = null;
        Mockito.when(userDAO.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        User actualOutput = userService.getByUsername(expectedUsername, expectedPassword);


        Assertions.assertEquals(expectedOutput,actualOutput);


    }

    @Test
    void getByUsernameIsWrongPassword() {
        String expectedUsername = "correctusername";
        String expectedPassword = "pass123";
        User expectedOutput = null;
        User userFromDb = new User(2,"correctusername", "pass1234", 2);
        Mockito.when(userDAO.getUserGivenUsername(expectedUsername)).thenReturn(userFromDb);

        User actualOutput = userService.getByUsername(expectedUsername, expectedPassword);


        Assertions.assertEquals(expectedOutput,actualOutput);


    }

    @Test
    void getByUsernameIsValidCredentials() {

        String expectedUsername = "correctusername";
        String expectedPassword = "correctpassword";
        User expectedOutput = new User(2, expectedUsername, expectedPassword, 2);
        Mockito.when(userDAO.getUserGivenUsername(expectedUsername)).thenReturn(expectedOutput);

        User actualOutput = userService.getByUsername(expectedUsername, expectedPassword);

        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void createUser() {
        //arrange
        User userToPass = new User(2, "username", "password", 2);
        //act
        userService.createUser(userToPass);
        //assert
        Mockito.verify(userDAO, Mockito.times(1)).createUser(userToPass);
    }
}