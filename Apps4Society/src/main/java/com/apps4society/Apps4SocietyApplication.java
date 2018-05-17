package com.apps4society;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apps4society.controler.UserControler;
import com.apps4society.model.User;
import com.opencsv.CSVReader;

@SpringBootApplication
public class Apps4SocietyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Apps4SocietyApplication.class, args);
	}
	
}