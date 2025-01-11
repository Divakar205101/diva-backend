package com.diva.filters;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {

	  public static final List<String> openApiEndpoints = List.of(
	            "/auth/signon",
	            "/auth/gentoken",
	            "/auth/validtoken",
	            "/swagger-ui"
	    );

	  public Predicate<ServerHttpRequest> isSecured =
	            request -> openApiEndpoints
	                    .stream()
	                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
