package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysUserInfoDe {
	private Long id;
	private String username;
	private String password;
	private String role;
}
