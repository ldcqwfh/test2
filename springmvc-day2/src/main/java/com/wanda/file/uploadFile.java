package com.wanda.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

@Controller
public class uploadFile {
	
		@RequestMapping("/fileUpload")
		public String upload(MultipartFile uploadFile,HttpServletRequest request) throws IllegalStateException, IOException {
			//文件名
			String filename = uploadFile.getOriginalFilename();
			//让每一个文件名不同
			filename = UUID.randomUUID().toString().replace("-", "")+filename;
			//服务器端保存文件的文件夹地址
			String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
			System.out.println(uploadPath );
			//在保存文件的文件夹中创建当前日期的文件夹
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			File file  = new File(uploadPath,date);
			if(!file.exists()) {
				file.mkdirs();
			}
			File fileUp = new File (file,filename);
			
			uploadFile.transferTo(fileUp);
			return "success";
			
		}
		//uploads必须提前创建好
	    private static String fileServerPath = "http://localhost:8081/upLoadFileServer/uploads/";
		@RequestMapping("/uploadFileServer")
		public String uploadFileServer(MultipartFile uploadFile,HttpServletRequest request) throws IOException {
				
			String filename = uploadFile.getOriginalFilename();
			filename = UUID.randomUUID().toString()+filename;
			//5.创建sun公司提供的jersey包中的Client对象	
			Client client = Client.create();
			//6.指定上传文件的地址，该地址是web路径
			WebResource resource = client.resource(fileServerPath+filename);
			//7.实现上传
			resource.put(uploadFile.getBytes());
			return "success";
		}	
	
}




