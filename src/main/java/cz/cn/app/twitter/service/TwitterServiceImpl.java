package cz.cn.app.twitter.service;

import cz.cn.app.twitter.entity.Application;
import cz.cn.app.twitter.entity.Resource;
import cz.cn.app.twitter.entity.Resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.xml.transform.stream.StreamSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

/**
 *
 * @author sixtaf
 */
@Service
public class TwitterServiceImpl implements TwitterService, InitializingBean {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;

	@Autowired
	private ClassPathResource xmlResource;

	private Application application;
	private HashMap<Integer, Resource> resourceMap = new HashMap<Integer, Resource>();


	public void afterPropertiesSet() {
		loadTwitterXml();
	}

	private void loadTwitterXml() {
		try {
			FileInputStream inputStream = new FileInputStream(xmlResource.getFile());
			StreamSource source = new StreamSource(inputStream);
			application = (Application)jaxb2Marshaller.unmarshal(source);

			List<Resources> resourcesList = application.getResources();
			if (resourcesList != null) {
				for (Resources resources : resourcesList) {
					List<Resource> resourceList = resources.getResource();
					if (resourceList != null) {
						for (Resource resource : resourceList) {
							resourceMap.put(resource.getRefId(), resource);
						}
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Unable to load Twitter API data.", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Resources> getResourcesList() {
		return application != null ? application.getResources() : null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Resource getResource(int refId) {
		Resource resource = resourceMap.get(refId);
		if (resource != null) {
			logger.info("Resource ID {} found; path: {}", refId, resource.getPath());
		} else {
			logger.warn("No resource with ID {} found; returning null");
		}
		return resource;
	}

}
