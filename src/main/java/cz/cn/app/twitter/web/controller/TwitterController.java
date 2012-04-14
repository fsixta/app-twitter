package cz.cn.app.twitter.web.controller;

import cz.cn.app.twitter.entity.Resource;
import cz.cn.app.twitter.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sixtaf
 */
@Controller
public class TwitterController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TwitterService twitterService;

    @RequestMapping("/home")
    public String getHomePage() {
        return "home-tiles";
    }

    @RequestMapping("/docMain")
    public String getDocMainPage(Model model) {
		model.addAttribute("resourcesList", twitterService.getResourcesList());
        return "docMain-tiles";
    }

    @RequestMapping("/detail")
    public String getDetailPage(@RequestParam(value = "id", required = true) String pId, Model model) {
		Resource resource;
		try {
			int id = Integer.parseInt(pId);
			resource = twitterService.getResource(id);
		} catch (NumberFormatException e) {
			resource = null;
			logger.warn("Invalid resource ID passed ({})", pId);
		}
		// Let the exceptional behaviour (null resource) on the JSP logic
		model.addAttribute("resource", resource);
        return "detail-tiles";
    }

    @RequestMapping("/aPage")
    public String getAnotherPage(@RequestParam(value = "page", required = false) String page, Model model) {
		model.addAttribute("pageId", page);
        return "aPage-tiles";
    }

}
