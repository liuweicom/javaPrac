package com.itheima.web.action;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport {
	private String username;
	private File[] photo;
	private String[] photoFileName;
	private String[] photoContentType;
	
	public String upload(){
		System.out.println(111111);
		ServletContext application =ServletActionContext.getServletContext();
		
		String filePath=application.getRealPath("/WEB-INF/files");
		
		File file=new File(filePath);
		if(file.exists()){
			file.mkdirs();
		}
		for(int i=0;i<photo.length;i++){
			photo[i].renameTo(new File(file,photoFileName[i]));
		}
		return null;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File[] getPhoto() {
		return photo;
	}

	public void setPhoto(File[] photo) {
		this.photo = photo;
	}

	public String[] getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String[] getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}

}
