package org.krams.tutorial.service;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.krams.tutorial.domain.PowerSupply;
import org.krams.tutorial.report.FillManager;
import org.krams.tutorial.report.Layouter;
import org.krams.tutorial.report.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;



@Service("downloadService")
@Transactional
public class DownloadService {

	private static Logger LOGGER = LoggerFactory.getLogger(DownloadService.class);

	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * Processes the download for Excel format.
	 * It does the following steps:
	 * <pre>1. Create new workbook
	 * 2. Create new worksheet
	 * 3. Define starting indices for rows and columns
	 * 4. Build layout 
	 * 5. Fill report
	 * 6. Set the HttpServletResponse properties
	 * 7. Write to the output stream
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public void downloadXLS(HttpServletResponse response) throws ClassNotFoundException {
		LOGGER.debug("Downloading Excel report");

		// 1. Create new workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 2. Create new worksheet
		HSSFSheet worksheet = workbook.createSheet("POI Worksheet");

		// 3. Define starting indices for rows and columns
		int startRowIndex = 0;
		int startColIndex = 0;

		// 4. Build layout 
		// Build title, date, and column headers
		Layouter.buildReport(worksheet, startRowIndex, startColIndex);

		// 5. Fill report
		FillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource());

		// 6. Set the response properties
		String fileName = "SalesReport.xls";
		response.setHeader("Content-Disposition", "inline; filename=" + fileName);
		// Make sure to set the correct content type
		response.setContentType("application/vnd.ms-excel");

		//7. Write to the output stream
		Writer.write(response, worksheet);
	}

	/**
	 * Retrieves the datasource as as simple Java List.
	 * The datasource is retrieved from a Hibernate HQL query.
	 */
	@SuppressWarnings("unchecked")
	private List<PowerSupply> getDatasource() {

		// Retrieve session
		Session session = sessionFactory.getCurrentSession();
		// Create query for retrieving products
		Query query = session.createQuery("FROM PowerSupply");
		// Execute query
		List<PowerSupply> result = query.list();

		// Return the datasource
		return result;
	}
}
