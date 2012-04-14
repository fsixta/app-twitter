package cz.cn.app.twitter.entity;

import static cz.cn.app.twitter.Consts.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author sixtaf
 */
@XmlType(namespace = WADL_NAMESPACE)
@XmlRootElement(name = "param", namespace = WADL_NAMESPACE)
public class Method {

	private String id;
	private String doc;

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "doc")
	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

}
