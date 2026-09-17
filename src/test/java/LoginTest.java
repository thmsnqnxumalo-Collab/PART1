/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.part1.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Login class using the test data supplied in the PoE brief.
 */
/**
 *
 * @author twnxu
 */
public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login("Kyle", "Smith");
    }

    // ---------- assertEquals tests ----------

    @Test
    public void testRegisterUser_usernameCorrectlyFormatted() {
        assertEquals("Welcome Kyle, Smith it is great to see you.",
                login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testRegisterUser_usernameIncorrectlyFormatted() {
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.",
                login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testRegisterUser_passwordMeetsComplexity() {
        assertEquals("Welcome Kyle, Smith it is great to see you.",
                login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testRegisterUser_passwordDoesNotMeetComplexity() {
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                login.registerUser("kyl_1", "password", "+27838968976"));
    }

    @Test
    public void testRegisterUser_cellPhoneCorrectlyFormatted() {
        assertEquals("Welcome Kyle, Smith it is great to see you.",
                login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976"));
    }

    @Test
    public void testRegisterUser_cellPhoneIncorrectlyFormatted() {
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.",
                login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553"));
    }

    // ---------- assertTrue / assertFalse tests ----------

    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertEquals("Welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus());
    }

    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("kyl_2", "wrongPass1!"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus());
    }

    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexityRequirements() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexityRequirements() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneNumberCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneNumberIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}
    

