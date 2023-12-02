package network_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import network.Request;

class RequestTest {
	@Test
	public void paramsTest() {
		Request r = new Request("http://text.com");
		r.setParams("key", "value", "key2", "value2");
		assertEquals("?key2=value2&key=value", r.getParamsString());
	}
	
	@Test
	public void paramsTestSpaces() {
		Request r = new Request("http://text.com");
		r.setParams("key", "value with spaces");
		assertEquals("?key=value+with+spaces", r.getParamsString());
	}
}
