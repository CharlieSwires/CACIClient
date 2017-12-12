package caci.order.resources;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class MakeOrderBean {

	private int orderNum;
	
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getOrderNum() {
		return this.orderNum;
	}

}
