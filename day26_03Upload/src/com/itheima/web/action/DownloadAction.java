package com.itheima.web.action;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	private InputStream inputStream;
	private String filename;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String download() throws Exception{
		String filePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/files/5.jpg");
		inputStream=new FileInputStream(filePath);
		filename="照片.jpg";
		return SUCCESS;
	}
}
