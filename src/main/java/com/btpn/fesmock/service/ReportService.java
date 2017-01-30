package com.btpn.fesmock.service;

import com.btpn.fesmock.model.User;

public interface ReportService {
	void initFile(User user);
	byte[] getFile(String fileName, boolean loadFromFile) throws Exception;
}
