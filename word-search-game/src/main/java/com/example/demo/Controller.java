package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Controller {
    
	@Autowired
	WordService wordService;
	
	@GetMapping
	public String getGrid(@RequestParam("gridSize") int gridsize,@RequestParam("words")  String wordsList) {
		String[] words= wordsList.split(",");
		String returnString=wordService.getArrayFormString(gridsize, words);
		return returnString;
	}
}
