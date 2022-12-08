package com.springmvc;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.springmvc.dao.PatientRepository;
import com.springmvc.entities.Patient;


@SpringBootApplication()
public class SpringDemov1Application implements CommandLineRunner {
	
	@Autowired
	private PatientRepository pRepository ;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemov1Application.class, args);
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
	
		pRepository.save(new Patient(null ,"houcine" ,true,new Date()));
		pRepository.save(new Patient(null ,"dele" ,false,new Date()));
		pRepository.save(new Patient(null ,"nunes" ,false,new Date()));
		pRepository.save(new Patient(null ,"cristor" ,false,new Date()));
		pRepository.save(new Patient(null ,"speed" ,false,new Date()));
		pRepository.save(new Patient(null ,"mrBeast" ,true,new Date()));
		pRepository.save(new Patient(null ,"Ksi" ,true,new Date()));
		pRepository.save(new Patient(null ,"Harry maguire" ,false,new Date()));
		pRepository.save(new Patient(null ,"boby fermino" ,true,new Date()));
		pRepository.save(new Patient(null ,"sadio mane" ,true,new Date()));
		pRepository.save(new Patient(null ,"modric" ,false,new Date()));
		pRepository.save(new Patient(null ,"kovasic" ,false,new Date()));
		//
		pRepository.findAll().forEach(patient->{
			System.out.println(patient.toString()) ;
		});
	}
}
