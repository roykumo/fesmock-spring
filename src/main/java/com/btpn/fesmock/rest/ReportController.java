package com.btpn.fesmock.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.fesmock.constant.URLConstant;
import com.btpn.fesmock.model.CommonResponse;
import com.btpn.fesmock.model.Rekening;
import com.btpn.fesmock.model.User;
import com.btpn.fesmock.service.ReportService;
import com.btpn.fesmock.service.impl.ReportServiceImpl;
import com.btpn.fesmock.util.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ReportController {
	private static final Logger LOGGER = Logger.getLogger(ReportController.class);
	
	private ReportService reportService = new ReportServiceImpl();
	
	@RequestMapping(value = URLConstant.URL_REPORT_LIST_TEST, method = RequestMethod.POST)
	public CommonResponse getList(@RequestBody User user) {
				
		try {
			if(user!=null){
				List<Rekening> rekenings = new ArrayList<Rekening>();
				for (int i = 0; i < 3; i++) {
					String counter = String.valueOf(i+1);
					Rekening rek = new Rekening();
					rek.setId(counter);
					rek.setNama("Nama "+counter);
					rek.setNomer("Nomor "+counter);
					
					rekenings.add(rek);
				}
				
				try{
					reportService.initFile(user);
				}catch(Exception e){
					LOGGER.error("error report : "+e.toString());
				}
				
				ObjectMapper mapper = new ObjectMapper();
				String jsonInString = mapper.writeValueAsString(rekenings);
				return new CommonResponse("0", jsonInString);
				
			}else{
				throw new Exception("no data");
			}
			
		} catch (Exception e) {
			LOGGER.error(e);
			return new CommonResponse("99", e.toString());
		}

	}
	
	@RequestMapping(value = URLConstant.URL_REPORT_PDF_TEST, method = RequestMethod.GET, produces = "application/pdf")
	public @ResponseBody ResponseEntity<byte[]> getPDFFile() {
		String fileName = "generate_test.pdf";
		try {
			byte[] document=reportService.getFile(fileName, true);

			return new ResponseEntity<byte[]>(document, Utils.constructHttpHeaderForPdf(fileName, document.length), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Error in Creating PDF Delivery Order : " + ex);
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = URLConstant.URL_REPORT_PDF_DOWNLOAD, method = RequestMethod.GET, produces = "application/pdf")
	public @ResponseBody ResponseEntity<byte[]> getPDFFile(@PathVariable String id) {
		String fileName = "dynamic_file.pdf";
		try {
			byte[] document=reportService.getFile(id, false);

			return new ResponseEntity<byte[]>(document, Utils.constructHttpHeaderForPdf(fileName, document.length), HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error("Error in Creating PDF Delivery Order : " + ex);
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
