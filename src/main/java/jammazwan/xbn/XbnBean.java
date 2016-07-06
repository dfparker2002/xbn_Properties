package jammazwan.xbn;

import org.apache.camel.PropertyInject;

public class XbnBean {

	@PropertyInject("foo")
	private String foo;

	public String answer(String text) {
		return text + " " + foo;
	}

}
