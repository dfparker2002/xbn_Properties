package jammazwan.xbn;

import org.apache.camel.PropertyInject;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelContextScopeTest extends CamelSpringTestSupport {
	@PropertyInject("foo")
	private String foo;

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camelContext-scope-camel-context.xml");
	}


	@Test
	public void testRouteUri() throws Exception {
		String reply = template.requestBody("direct:myRoute", "seed", String.class);
		assertEquals("seed", reply);
	}

	@Test
	public void testTemplateUri() throws Exception {
		String reply = template.requestBody("direct:{{your.route}}", "seed", String.class);
		assertEquals("seed", reply);
	}

	@Test
	public void testBeanReplacement() throws Exception {
		String reply = template.requestBody("direct:beanTest", "seed", String.class);
		assertEquals("seed bar", reply);
	}

	@Test
	public void testThisJavaFile() throws Exception {
		String reply = template.requestBody("direct:javaTest", "seed " + foo, String.class);
		assertEquals("seed bar", reply);
	}

	@Test
	public void testEnvVars() throws Exception {
		String reply = template.requestBody("direct:envVars", "seed", String.class);
		assertTrue(reply.toLowerCase().contains(":"));
	}

	@Test
	public void testResolvePropertyPlaceholders() throws Exception {
		String reply = template.requestBody("direct:resolvePropertyPlaceholders", "seed", String.class);
		assertEquals("seed bar", reply);
	}

}
