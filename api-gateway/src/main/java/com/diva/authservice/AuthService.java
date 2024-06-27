package com.diva.authservice;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "",name = "authserivce")
public interface AuthService {
   public String vlidatetoken(String token); 
}
