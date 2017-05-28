package com.boot.controller;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	
	private final static org.slf4j.Logger logger=org.slf4j.LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Value("${multipart.location}")
	private String location;
	
	@RequestMapping(value="/upload",method=RequestMethod.POST,produces=MediaType.IMAGE_GIF_VALUE)
	public String upload(@RequestPart("file") MultipartFile file,
						@RequestParam("start") int start,@RequestParam("end") int end,
						@RequestParam("speed") int speed,@RequestParam("repeat") boolean repeat) throws IllegalStateException, IOException {
		File videoFile=new File(location+"/"+System.currentTimeMillis()+".mp4");
		file.transferTo(videoFile);
		logger.info("Saved file to {}",videoFile.getAbsolutePath());
		return "";
	}
}
