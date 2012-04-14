package cz.cn.app.twitter.entity;

import static cz.cn.app.twitter.Consts.*;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author sixtaf
 */
@XmlType(namespace = WADL_NAMESPACE)
@XmlRootElement(name = "resources", namespace = WADL_NAMESPACE)
public class Resources {

	private String base;
	private List<Resource> resource;

	@XmlAttribute(name = "base")
	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public List<Resource> getResource() {
		return resource;
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}

}
