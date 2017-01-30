package com.btpn.fesmock.service;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;

public interface IReportCreatorService {
	public <T> byte[] reportCreation(String jasperFilePath, Map<String, Object> parameters, List<T> dataSource);
	public <T> JasperPrint getJasperPrint(String jasperFilePath, Map<String, Object> parameters, List<T> dataSource);
}
