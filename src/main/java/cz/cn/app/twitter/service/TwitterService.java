package cz.cn.app.twitter.service;

import cz.cn.app.twitter.entity.Resource;
import cz.cn.app.twitter.entity.Resources;
import java.util.List;

/**
 *
 * @author sixtaf
 */
public interface TwitterService {

	/**
	 * @return list of all resource objects from the underlying XML source
	 */
	public List<Resources> getResourcesList();

	/**
	 * @param refId the reference ID of the resource to get
	 * @return the Twitter resource with the given reference ID, null if there is no resource with the given ID
	 */
	public Resource getResource(int refId);

}
