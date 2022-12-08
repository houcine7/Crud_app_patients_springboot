package com.springmvc.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	@NotNull
	@Size(min = 3 ,max = 20)
	private String name;
	
	private boolean sick ;
	@Temporal(TemporalType.DATE) // store date as a date time not as a time stamp
	@DateTimeFormat(pattern = "yyyy-mm-dd") // format date and set it to the attribute birthday 
	@NotNull
	private Date birthday ;

}
