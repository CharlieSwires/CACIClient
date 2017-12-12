package caci.order.resources;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RetrieveOrderBean {

	private long bricks;
	private int orderNum;
	
	public long getBricks() {
		return bricks;
	}
	public void setBricks(long bricks) {
		this.bricks = bricks;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	
}
