package com.eliteschool.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.eliteschool.school.model.UploadForm;
import com.eliteschool.school.service.UploadFormService;

@Controller
public class UploadFormController implements HandlerExceptionResolver {

	@Autowired
	UploadFormService uploadFormService;

	@RequestMapping(value = "/FileUploadForm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		UploadForm form = new UploadForm();
		model.addAttribute("FORM", form);
		return "FileUploadFormTile";
	}

	@RequestMapping(value = "/FileUploadForm", method = RequestMethod.POST)
	public String processForm(HttpServletRequest request,
			@ModelAttribute(value = "FORM") UploadForm form,
			BindingResult result, ModelMap model) {
		if (!result.hasErrors()) {
			try {
				// Store Local FileSystem
				// new UploadFormController().saveLocalFileSystem(form);

				// Store Mongo FileSystem
				String message = uploadFormService.saveImage(form);
				model.addAttribute("success", message);

			} catch (Exception e) {
				System.out.println("Error while saving file  " + e);
				model.addAttribute("errors", e.toString());
			}

		}
		return "FileUploadFormTile";
	}
	
	@RequestMapping(value="/fileDownload/{folder}/{prefix}/{suffix}")
	public void downloadFile(HttpServletResponse response,@PathVariable String folder,@PathVariable String prefix
			,@PathVariable String suffix){
		try {
			String fileName = prefix+"."+suffix;
			response.setHeader("Content-disposition", "attachment;filename="
	                + new String(fileName.getBytes(), "iso8859-1"));
			OutputStream os = response.getOutputStream();
			InputStream inStream = uploadFormService.downloadImage(folder,fileName);
			FileCopyUtils.copy(inStream, os);
			
			os.flush();
			os.close();
			
		}catch (Exception e) {		
			e.printStackTrace();
		}
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {
		Map<Object, Object> model = new HashMap<Object, Object>();
		if (exception instanceof MaxUploadSizeExceededException) {
			model.put(
					"errors",
					"File size should be less then "
							+ ((MaxUploadSizeExceededException) exception)
									.getMaxUploadSize() + " Bytes.");
		} else {
			model.put("errors", "Un expected error : " + exception.getMessage());
		}
		model.put("FORM", new UploadForm());
		return new ModelAndView("/FileUploadFormTile", (Map) model);
	}
	
	// Save Uploaded files in Local FileSystem
	/*public void saveLocalFileSystem(UploadForm form) throws IOException,
			Exception {
		FileOutputStream outputStream = null;
		String filePath = null;
		filePath = System.getProperty("java.io.tmpdir")
				+ form.getFile().getOriginalFilename();
		System.out.println("File Path ::::: " + filePath);
		outputStream = new FileOutputStream(new File(filePath));
		outputStream.write(form.getFile().getFileItem().get());
		outputStream.close();
	}*/

}
// https://code.google.com/p/fresh-mongo/source/browse/trunk/SpringMongo/src/main/java/com/lichhao/system/web/controller/UploadFormController.java?r=7
