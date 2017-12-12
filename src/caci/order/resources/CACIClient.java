package caci.order.resources;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CACIClient {
	private static final String MIME_TYPE = MediaType.APPLICATION_JSON;

	public MakeOrderBean makeOrder(long bricks){
		ClientConfig config = new DefaultClientConfig();//.register(JacksonFeature.class);
		//config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		//Build URI in its entirety
		UriBuilder uriBuilder = service.getUriBuilder().path("rest").path("OrderService").path("makeOrder");
		service = service.uri(uriBuilder.build());
		
		String input = "{\"bricks\":"+bricks+"}";
		// Now call the REST service
		ClientResponse response = service.type(MIME_TYPE).accept(MIME_TYPE).post(ClientResponse.class,input);

		// Get the data
		MakeOrderBean bean = response.getEntity(MakeOrderBean.class);


		return bean;

	}
	public RetrieveOrderBean retrieveOrder (int orderNum){
		ClientConfig config = new DefaultClientConfig();//.register(JacksonFeature.class);
		//config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		//Build URI in its entirety
		UriBuilder uriBuilder = service.getUriBuilder().path("rest").path("OrderService").path("retrieveOrder");
		service = service.uri(uriBuilder.build());
		
		String input = "{\"orderNum\":"+orderNum+"}";
		// Now call the REST service
		ClientResponse response = service.type(MIME_TYPE).accept(MIME_TYPE).post(ClientResponse.class,input);

		// Get the data
		RetrieveOrderBean bean = response.getEntity(RetrieveOrderBean.class);


		return bean;

	}

	public RetrieveOrdersBean retrieveAllOrders (int i){
		ClientConfig config = new DefaultClientConfig();//.register(JacksonFeature.class);
		//config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		//Build URI in its entirety
		UriBuilder uriBuilder = service.getUriBuilder().path("rest").path("OrderService").path("retrieveAllOrders");
		service = service.uri(uriBuilder.build());
		
		// Now call the REST service
		ClientResponse response = service.type(MIME_TYPE).accept(MIME_TYPE).post(ClientResponse.class, "{\"dummy\":"+i+"}");

		// Get the data
		RetrieveOrdersBean bean = response.getEntity(RetrieveOrdersBean.class);

		return bean;

	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(("http://localhost:8080/OrderServer")).build();
	}
	

}
