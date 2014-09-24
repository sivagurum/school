package com.eliteschool.school.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.eliteschool.school.model.UploadForm;

@Repository
public class UploadFormService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String saveImage(UploadForm form) throws IOException,Exception{
		CommonsMultipartFile file = form.getFile();
		String folder = "upload";
		String originalFileName = file.getOriginalFilename();				
						
		String[] s = originalFileName.split("\\.");	
		String prefix = s[0];
		String suffix = s.length == 1 ? "" : s[1];
		
		/*System.out.println(" **** "+originalFileName+" :: "+file.getInputStream()+" :: "+file.getSize()+" **** ");
		System.out.println(" **** "+folder+" :: "+prefix+" :: "+suffix+" :: "+mongoTemplate.getDb()+" **** ");*/
		GridFS gridFs = new GridFS(mongoTemplate.getDb(),folder);	
		
		GridFSInputFile gfsFile = gridFs.createFile(file.getInputStream());				
		gfsFile.setFilename(originalFileName);
		gfsFile.setContentType(suffix);				
		gfsFile.save();
		
		return "Upload Success : "+folder+"/"+originalFileName;		
		
	}

	public InputStream downloadImage(String folder, String fileName) throws IOException,Exception {
		
		System.out.println(" **** "+mongoTemplate.getDb()+" :: "+folder+" :: "+fileName+" **** ");
		
		GridFS gridFs = new GridFS(mongoTemplate.getDb(), folder);
		GridFSDBFile gridFSDBFile = gridFs.findOne(fileName);
		
		System.out.println(" *** "+gridFSDBFile.getUploadDate()+" ***");
		
		return gridFSDBFile.getInputStream();
	}
	
}
