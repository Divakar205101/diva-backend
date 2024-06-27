package com.div.domain;

import java.util.Date;

public class SetAdditionalFeilds {
	
	public static void setFeilds(BaseVO baseDO) {
		if (baseDO.getId()==null) {
			baseDO.setCreatedDate(new Date());
			baseDO.setUpdatedDate(new Date());
		} else {
			baseDO.setUpdatedDate(new Date());
		}
	}

}
