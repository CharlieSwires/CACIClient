package caci.order.resources;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Test1 {
	CACIClient client;
	@Before
	public void setUp() throws Exception {
		client = new CACIClient();
	}

	@Test
	public void test() {
		MakeOrderBean order[] = new MakeOrderBean[2];
		order[0] = client.makeOrder(1000L);
		order[1] = client.makeOrder(2000L);
		
		assertTrue("Order numbers same",order[0].getOrderNum() != order[1].getOrderNum());

		RetrieveOrderBean lodgedOrder[] = new RetrieveOrderBean[2];
		lodgedOrder[0] = client.retrieveOrder(order[0].getOrderNum());
		lodgedOrder[1] = client.retrieveOrder(order[1].getOrderNum());
		
		assertTrue("Bricks don't match",lodgedOrder[0].getBricks() == 1000 &&
				lodgedOrder[1].getBricks() == 2000);
		
		RetrieveOrdersBean orders = client.retrieveAllOrders();
		List<RetrieveOrderBean> ordersList = orders.getBeans();
		
		int i = 0;
		for(RetrieveOrderBean orderItem: ordersList){
			assertTrue("orderNum doesn't match", order[i].getOrderNum() == orderItem.getOrderNum());
			assertTrue("bricks doesn't match", lodgedOrder[i].getBricks() == orderItem.getBricks());
			i++;
		}
	}

}
