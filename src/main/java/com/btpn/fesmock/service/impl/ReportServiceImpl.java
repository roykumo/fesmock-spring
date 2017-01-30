package com.btpn.fesmock.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.apache.log4j.Logger;

import com.btpn.fesmock.model.Rekening;
import com.btpn.fesmock.model.User;
import com.btpn.fesmock.service.IReportCreatorService;
import com.btpn.fesmock.service.ReportService;
import com.btpn.fesmock.util.Utils;

public class ReportServiceImpl implements ReportService {
	private static final Logger LOGGER = Logger.getLogger(ReportServiceImpl.class);
	
	private IReportCreatorService iReportCreatorService = new IReportCreatorServiceImpl();
	
	private static final String FILE_PATH = "C:\\fesmock\\jasper\\";
	private static final String FILE_JASPER = "report_test.jasper";
	private static final String FILE_NAME = "generate_test";

	public void initFile(User user) {
		List<Rekening> rekenings = new ArrayList<Rekening>();
		for (int i = 0; i < 3; i++) {
			String counter = String.valueOf(i+1);
			Rekening rek = new Rekening();
			rek.setId(counter);
			rek.setNama("Nama "+counter);
			rek.setNomer("Nomor "+counter);
			
			rekenings.add(rek);
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bulan", "jan");
		
		JasperPrint jasperPrint = iReportCreatorService.getJasperPrint(FILE_PATH + FILE_JASPER, params, rekenings);		
		try {
			JasperExportManager.exportReportToPdfFile(jasperPrint, FILE_PATH + FILE_NAME +".pdf");
		} catch (JRException e) {
			LOGGER.error(e.toString());
		}
		
		//return iReportCreatorService.reportCreation("C:\\fesmock\\jasper\\report_test.jasper", params, rekenings);
	}

	public byte[] getFile(String fileName, boolean loadFromFile) throws Exception {
		if(loadFromFile){
			File f=new File(FILE_PATH + fileName);
	
			if(!f.exists()){
				throw new Exception("file not found");
			}
			
			return Utils.loadFile(f.getAbsolutePath());
		}else{
			
			List<Rekening> rekenings = new ArrayList<Rekening>();
			
			Rekening rek = new Rekening();
			rek.setId(fileName);
			rek.setNama("File untuk : "+fileName);
			rek.setNomer("Nomor "+fileName);			
			rekenings.add(rek);		
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("bulan", "jan");
			
			JasperPrint jasperPrint = iReportCreatorService.getJasperPrint(FILE_PATH + FILE_JASPER, params, rekenings);		
			
			return JasperExportManager.exportReportToPdf(jasperPrint);
		}
	}
	
}
