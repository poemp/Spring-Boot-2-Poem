package org.poem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.poem.user.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockInitTimesTest {

    @Test
    public void test(){
        UserService userService = mock(UserService.class);

        when(userService.count()).thenReturn(100);

        int count = userService.count();
        count = userService.count();

        assertEquals(100,count);

        doThrow(new NullPointerException("空指针异常")).when(userService).count();
        //
        verify(userService,times(4)).count();
    }
}
