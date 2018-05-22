package maven_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class testMaven {
	@Test
	public void test(){
		helloMaven hm = new helloMaven();
		String result = hm.sayHello("fouzi");
		assertEquals("hellofouzi",result);
	}
}
