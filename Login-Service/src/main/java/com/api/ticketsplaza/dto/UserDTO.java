package com.api.ticketsplaza.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private String name;
	private String email;
	private String password;
	private String mobileNumber;
	private String role;
}
