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
@XmlRootElement(name = "resource", namespace = WADL_NAMESPACE)
public class Resource {

	private String path;
	private List<Param> param;
	private List<Method> method;

	@XmlAttribute(name = "path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Param> getParam() {
		return param;
	}

	public void setParam(List<Param> param) {
		this.param = param;
	}

	public List<Method> getMethod() {
		return method;
	}

	public void setMethod(List<Method> method) {
		this.method = method;
	}

	/**
	 * Returns the reference ID of this Twitter resource. We use the object hash code as the reference ID.
	 * @return reference ID of this Twitter resource
	 */
	public int getRefId() {
		return hashCode();
	}

	/**
	 * Sets the internal reference ID. It must be a unique number identifying this resource in the set Twitter resources.
	 * @param refId the internal reference ID
	 */
	/*public void setRefId(int refId) {
		this.refId = refId;
	}*/

}
