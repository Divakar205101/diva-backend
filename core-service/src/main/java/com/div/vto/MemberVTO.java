package com.div.vto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.div.domain.RoleMasterVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVTO {
	   
	    private Integer id;
	    private RoleMasterVO roleMasterDO;	    
	    private MemberCommVTO memberCommVO = new MemberCommVTO();	    
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
	    private List<MemberBanksVTO> memberBanksVOs = new ArrayList<MemberBanksVTO>();
}
