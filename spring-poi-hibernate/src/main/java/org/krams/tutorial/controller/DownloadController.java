package org.krams.tutorial.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.krams.tutorial.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/download")
public class DownloadController {

	private static Logger logger = LoggerFactory.getLogger(DownloadController.class);
	
	@Resource(name="downloadService")
	private DownloadService downloadService;

    @RequestMapping(value = "/xls", method = RequestMethod.GET)
    public void getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
    	logger.debug("Received request to download report as an XLS");
    	
    	// Delegate to downloadService. Make sure to pass an instance of HttpServletResponse 
    	downloadService.downloadXLS(response);
	}
}
