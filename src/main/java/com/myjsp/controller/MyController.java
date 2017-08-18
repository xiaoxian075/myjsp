package com.myjsp.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;  

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * TODO 控制层代码
 * @author cjx
 * @date 2017年6月3日
 */
@Controller
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);  
	
	
	@RequestMapping("login.do") //用来处理前台的login请求
	private @ResponseBody String hello(
			@RequestParam(value = "username", required = false)String username,
			@RequestParam(value = "password", required = false)String password
			){
		logger.info(username+"   "+password);
		return "你好:"+username+",你的密码是:"+password;
	}
	
	//上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="upload.do",method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
           @RequestParam("description") String description,
           @RequestParam("file") MultipartFile file) throws Exception {
    	System.out.println(description);
    	/*//分别获取的是变量名file---文件类型---文件名
        System.out.println(file.getName()+"---"+file.getContentType()+"---"+file.getOriginalFilename());
        try {
            if (!file.isEmpty()){
            //使用StreamsAPI方式拷贝文件
                Streams.copy(file.getInputStream(),new FileOutputStream("E:/temp/"+file.getOriginalFilename()),true);
            }
        } catch (IOException e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
        }
        //System.out.println(user.toString());
        return "success";
        */
      //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = "E:/temp";//request.getServletContext().getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else {
            return "error";
        }
    }
    
    @RequestMapping(value = "/download.do",produces = "application/octet-stream;charset=UTF-8")
    public ResponseEntity<byte[]> download() throws IOException {
		//        指定文件,必须是绝对路径
		    File file = new File("E:/temp/R.log");
		//        下载浏览器响应的那个文件名
		    String dfileName = "R.log";
		//        下面开始设置HttpHeaders,使得浏览器响应下载
		    HttpHeaders headers = new HttpHeaders();
		//        设置响应方式
		    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//        设置响应文件
		    headers.setContentDispositionFormData("attachment", dfileName);
		//        把文件以二进制形式写回
		    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    /*
  //上传文件会自动绑定到MultipartFile中
    @RequestMapping(value="upload.do",method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
           @RequestParam("description") String description,
           @RequestParam("file") MultipartFile file) throws Exception {

       System.out.println(description);
       //如果文件不为空，写入上传路径
       if(!file.isEmpty()) {
           //上传文件路径
           String path = request.getServletContext().getRealPath("/images/");
           //上传文件名
           String filename = file.getOriginalFilename();
           File filepath = new File(path,filename);
           //判断路径是否存在，如果不存在就创建一个
           if (!filepath.getParentFile().exists()) { 
               filepath.getParentFile().mkdirs();
           }
           //将上传文件保存到一个目标文件当中
           file.transferTo(new File(path + File.separator + filename));
           return "success";
       } else {
           return "error";
       }
    }
   
  //实现文件的下载   //需要说明的是文件的上传和下载不需要其他配置  
    @RequestMapping(value="download.do",method=RequestMethod.POST)
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session,
    		@RequestParam(value = "filename", required = true)String filename) throws IOException{
    	byte[] body=null;     
    	ServletContext servletContext=session.getServletContext();     
    	///files/abc.txt：所要下载文件的地址     
    	InputStream in=servletContext.getResourceAsStream("/files/abc.txt");     
    	body=new byte[in.available()];     
    	in.read(body);           
    	HttpHeaders headers=new HttpHeaders();     
    	//响应头的名字和响应头的值    
    	headers.add("Content-Disposition", "attachment;filename=abc.txt");
    	HttpStatus statusCode=HttpStatus.OK;
    	ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, statusCode);
    	return response;
    }
    */
}
