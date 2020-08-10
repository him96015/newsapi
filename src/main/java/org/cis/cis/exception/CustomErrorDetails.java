package org.cis.cis.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomErrorDetails {
	
	private Date timestamp;
	private String message;
	private String errordetails;
	

}
