package com.weiwei.bonc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSayHello(){
        App app = new App();
        String str = app.sayHello('pig');
        assertEquals('hello pig', str);
    }
}
