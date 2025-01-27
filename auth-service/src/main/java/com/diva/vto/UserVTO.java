package com.diva.vto;




import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserVTO {

	@ApiModelProperty(value = "Id will Genrate From Backend")
	private Integer Id;
	@NotNull
	@NotEmpty(message = "userName should not null")
	private String userName;
	@Email(message = "email should not null")
	private String email;
	@NotEmpty(message = "password should not null")
	private String password;
	@NotEmpty(message = "confirmPassword should not null")
	private String confirmPassword;
}
