package com.basicspring.architecture.SpringArtifact.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicspring.architecture.SpringArtifact.config.BarCode;

@RestController
class BaseController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/test")
	public String index() {
		LOGGER.info("Welcome to spring boot");
		return "welcome to spring boot!!";
	}

	@RequestMapping("/generateBarCode")
	public String generateBarCode(){
		
		BarCode.generateBarCode();
		
		return "BarCode Generated Successfully";
	}
	
	
	@RequestMapping("/displayTxtfile")
	public String returnDisplay() {
		StringBuilder result = new StringBuilder();
		LOGGER.info("Here reading a txt file and returning the same to the browser");
		Resource resource = new ClassPathResource(
				"C:\\Users\\Dell\\Desktop\\practice\\");
		try {
			File file = resource.getFile();
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}

}