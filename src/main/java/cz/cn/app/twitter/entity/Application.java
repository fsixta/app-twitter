package cz.cn.app.twitter.entity;

import static cz.cn.app.twitter.Consts.*;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author sixtaf
 */
@XmlType(namespace = WADL_NAMESPACE)
@XmlRootElement(name = "application", namespace = WADL_NAMESPACE)
public class Application {

	private List<Resources> resources;

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

}
