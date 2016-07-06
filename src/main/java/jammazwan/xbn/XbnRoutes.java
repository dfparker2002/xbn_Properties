package jammazwan.xbn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class XbnRoutes extends RouteBuilder {

	@Autowired
	private XbnBean xbnBean;

	@Override
	public void configure() throws Exception {
		from("direct:{{what.route}}").log("tested testRouteUri");

		from("direct:yourRoute").log("tested templateUri");

		from("direct:beanTest").bean(xbnBean);

		from("direct:javaTest").log("tested javaTest");

		from("direct:envVars").transform(simple("env:PATH"));

		from("direct:resolvePropertyPlaceholders").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String text = exchange.getIn().getBody(String.class);
				String newAnswer = text + " " + getContext().resolvePropertyPlaceholders("{{foo}}");
				exchange.getOut().setBody(newAnswer);
			}
		});

	}
}
