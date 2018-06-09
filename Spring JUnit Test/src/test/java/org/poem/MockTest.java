package org.poem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.poem.user.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Test
    public void test(){
        UserService userService = mock(UserService.class);
        when(userService.count()).thenReturn(100);

        int count = userService.count();
        assertEquals(count, 1000);
    }
}
