package caci.order.resources;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RetrieveOrdersBean {

	private List<RetrieveOrderBean> beans;

	public List<RetrieveOrderBean> getBeans() {
		return beans;
	}

	public void setBeans(List<RetrieveOrderBean> beans) {
		this.beans = beans;
	}
	
}
