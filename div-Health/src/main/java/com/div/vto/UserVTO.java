package com.div.vto;

import java.util.Date;

import com.div.domain.RoleMasterVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVTO {
	   
	    private Integer id;
	    private RoleMasterVO roleMasterDO;	    
	    private String title;	    
	    private String firstName;
	    private String lastName;	    
	    private String middleName;	    
	    private String adharNumber;	    
	    private Date dateOfBirth;    
	    private Integer age;  
	    private String email;
	    private String country;
	    private String mobileNumber;
	    private String lanNumber;
	    private String status;
}
