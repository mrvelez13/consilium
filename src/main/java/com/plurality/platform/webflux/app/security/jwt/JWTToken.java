package com.plurality.platform.webflux.app.security.jwt;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTToken
{
	private String token;
	
	public JWTToken(String jwt) {
		this.token = jwt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
