package com.itheima.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private UserService service = new UserServiceImpl();
	private User user=new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
	 return user;
	}
	private List<User> users;
	private String isUpload;
	private String uploadFileName;
	private File upload;
	//--------------多条件查询--------------------------
	public String findUserByCondition(){
		users = service.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isUpload);
		return null;
	}
	//--------------编辑用户-----------------------
	public String edit(){
		//.判断用户是否重新选择了文件	
		if(upload==null){
		//没有选择文件，我们用原来的
			User dbUser=service.findUserById(user.getUserID());
			//由于选择文件，user模型中的filename和path属性都是null,我们需要用查出来的用户里面的值替换
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			int res=service.modifyUser(user);
			if(res>0){
				return SUCCESS;
			}
		}else{
		//用户重新选择文件
		//文件保存的路径
			String filePath=ServletActionContext.getServletContext().getRealPath("files");
			String dir=generateChildPath(filePath);
		//2，生成带有随机性的文件名
			
			String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;
		//把user模型中缺少定位属性，填充进去
			user.setPath(dir);
			//保存的文件名必须是带有GUID的文件名，下载的时候还要用
			user.setFilename(fileName);
		
		//上传文件操作
			upload.renameTo(new File(filePath+File.separator+dir,fileName));
		//保存用户
			int res=service.modifyUser(user);
			if(res>0){
				return SUCCESS;
			}
		}
		return null;
	}
	
	
	//------------显示编辑页面的动作方法--------------------
	public String editUI(){
		user=service.findUserById(user.getUserID());
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//---------删除用户---------------------
	public String delete(){
		int res=service.removeUser(user.getUserID());
		if(res>0){
			return SUCCESS;
		}
		return null;
	}
	
	//------------文件下载----------------------
	private InputStream inputStream;
	private String oldFileName;//原始文件
	public String download() throws Exception{
		//获取用户的信息
		User dbUser=service.findUserById(user.getUserID());
		//2.获取存放的路径
		String filePath = ServletActionContext.getServletContext().getRealPath("./files");
		//3.给原始文件名赋值
		oldFileName = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1);
		//4.给字节输入流赋值
		inputStream=new FileInputStream(filePath+File.separator+dbUser.getPath()+File.separator+dbUser.getFilename());;
		//5.返回成功
		return SUCCESS;
		//剩下的交给stream类型的结果视图
	}
	
	
	//-------------查看用户详细信息------------------
	public String findUserId(){
		user=service.findUserById(user.getUserID());
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	
	//------------查询所有用户-----------------------
	public String findAll(){
		users=service.findAllUser();
		return SUCCESS;
	}
		//用于存放查询出来的所用用户
	
	//-------------用户添加-----------------------
	public String add(){
		//1.文件保存的路径
		String filePath = ServletActionContext.getServletContext().getRealPath("files");
		String dir=generateChildPath(filePath);
		//2.生成带有随机性的文件名
		String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;
		//3.把users模型中缺少的属性，填充进去
		user.setFilename(fileName);
		user.setPath(dir);
		//上传文件操作
		upload.renameTo(new File(filePath+File.separator+dir+File.separator,fileName));
		//保存用户
		return SUCCESS;
	}
	//生成一yyyy-mm-dd的格式名称的文件夹
	private String generateChildPath(String fildPath){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dir=format.format(date);
		File file=new File(fildPath,dir);
		if(file.exists()){
			file.mkdirs();
		}
		return dir;
	}
	//-------------用户登录的动作方法-------------------
	public String login(){
		User dbUser=service.login(user.getLogonName(),user.getLogonPwd());
		if(dbUser==null){
			addActionError("用户不存在，或者用户名，密码错误");
		}
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getIsUpload() {
		return isUpload;
	}
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getOldFileName() {
		return oldFileName;
	}
	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}
	
	
	
}
