package com.div.domain;

import lombok.Data;

@Data
public class MessageResponse {
    private String response;

	public MessageResponse(String response) {
		super();
		this.response = response;
	}
	

}
