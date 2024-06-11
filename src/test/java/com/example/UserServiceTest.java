package com.example;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Create a mock object of UserDao
        UserDao userDao = mock(UserDao.class);

        // Define the behavior of the mock object (stubbing)
        User mockUser = new User(1, "John Doe");
        when(userDao.getUserById(1)).thenReturn(mockUser);

        // Create an instance of UserService and inject the mock object
        UserService userService = new UserService(userDao);

        // Call the method to be tested
        User user = userService.getUserById(1);

        // Verify the result
        assertNotNull(user); // Check that the returned user is not null
        assertEquals(1, user.getId()); // Check that the user ID is correct
        assertEquals("John Doe", user.getName()); // Check that the name is correct
    }
}
