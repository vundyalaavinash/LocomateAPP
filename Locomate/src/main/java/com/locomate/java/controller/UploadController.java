package com.locomate.java.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;

import com.locomate.java.beans.UploadFilePO;
import com.locomate.java.proxy.UploadProxy;
import com.locomate.java.proxy.Impl.UploadProxyImpl;

@Controller
public class UploadController {
	
	@Autowired
	private UploadProxy uploadproxy;
	@RequestMapping("/displayUploadPicture")
	public String displayUploadPicture(){
		
		return "upload";
		
	}
@SuppressWarnings("deprecation")

@RequestMapping("/images")

public String pictureSave(@ModelAttribute("uploadForm") UploadFilePO uploadForm,Model model,
		HttpServletRequest request,
        HttpServletResponse response, Object command,  @RequestParam("file") MultipartFile file) throws IOException, ServletException{

       String fileName="";
   
	     try{
	    	 InputStream inputStream = null;
	    	 OutputStream outputStream = null;
	    	 if(file.getSize()>0){
	    		 inputStream =file.getInputStream();
	    		 fileName =  request.getRealPath("") +
	                     "/images/"+ file.getOriginalFilename();
	    		/* Blob blob = Hibernate.createBlob(file.getInputStream());
	    		 uploadForm.setContent(blob);
	    		 uploadproxy.saveImage(uploadForm);*/
	    		 outputStream = new FileOutputStream(fileName);
	    		 int readBytes=0;
	    		 byte[] buffer = new byte[10000];
	    		 while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                     outputStream.write(buffer, 0, readBytes);
               }
	    		 outputStream.close();
                 inputStream.close(); 
	    	 }
	     }catch(Exception e){
	    		 e.printStackTrace();
	    	 }
	     
         model.addAttribute("fileName", file.getOriginalFilename());
         model.addAttribute("filepath", "images/"+file.getOriginalFilename());
	        return "viewImage";
	
	    }
	
}

