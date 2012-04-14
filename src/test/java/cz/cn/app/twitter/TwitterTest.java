package cz.cn.app.twitter;

import cz.cn.app.twitter.service.TwitterService;
import cz.cn.app.twitter.entity.Param;
import cz.cn.app.twitter.entity.Resource;
import cz.cn.app.twitter.entity.Resources;
import java.util.List;
import org.junit.Ignore;
import static junit.framework.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 *
 * @author sixtaf
 */
@ContextConfiguration(locations="classpath:test-context.xml")
public class TwitterTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	private TwitterService twitterService;

	@Test
	public void basicTest() {
		List<Resources> resourcesList = twitterService.getResourcesList();
		assertNotNull(resourcesList);
		assertEquals(resourcesList.size(), 2);
		Resources resources = resourcesList.get(0);
		assertNotNull(resources);
		assertEquals(resources.getBase(), "https://api.twitter.com/1");
		List<Resource> resourceList = resources.getResource();
		assertNotNull(resourceList);
		assertEquals(resourceList.size(), 3);
		Resource resource = resourceList.get(1);
		assertNotNull(resource);
		assertEquals(resource, twitterService.getResource(resource.getRefId()));
		assertEquals(resource.getPath(), "statuses/mentions.{format}");
		List<Param> paramList = resource.getParam();
		assertNotNull(paramList);
		assertEquals(paramList.size(), 4);
		Param param = paramList.get(0);
		assertNotNull(param);
		assertEquals(param.getName(), "format");
		assertEquals(param.getDoc(), "Response format.");
	}

	@Test
	@Ignore
	public void printOutTest() throws Exception {
		List<Resources> resourcesList = twitterService.getResourcesList();
		System.out.println("Twitter test data listing:");
		if (resourcesList != null) {
			for (Resources resources : resourcesList) {
				System.out.println("  Resources: " + resources.getBase());
				if (resources.getResource() != null) {
					for (Resource resource : resources.getResource()) {
						System.out.println("    Resource: " + resource.getPath());
						if (resource.getParam() != null) {
							for (Param param : resource.getParam()) {
								System.out.println("      Param name: " + param.getName() +
										"; doc: " + param.getDoc());
							}
						}
					}
				}
			}
		}
	}

}
