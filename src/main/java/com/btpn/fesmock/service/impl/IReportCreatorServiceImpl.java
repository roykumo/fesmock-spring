package com.btpn.fesmock.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.btpn.fesmock.service.IReportCreatorService;


@Component
public class IReportCreatorServiceImpl implements IReportCreatorService {
	private static final Logger logger = Logger.getLogger(IReportCreatorServiceImpl.class);
	
	public <T> byte[] reportCreation(String jasperFilePath, Map<String, Object> parameters, List<T> dataSource) {
		
		try{
			return JasperExportManager.exportReportToPdf(getJasperPrint(jasperFilePath, parameters, dataSource));
		}catch(JRException e){
			logger.error(e.toString());
			return null;
		}

	}
	
	public <T> JasperPrint getJasperPrint(String jasperFilePath, Map<String, Object> parameters, List<T> dataSource){
		
		try {
			JasperReport report;
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataSource);
			report = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, beanColDataSource);
			return jasperPrint;
		} catch (JRException e) {
			logger.error(e.toString());
			return null;
		}
	}

}
