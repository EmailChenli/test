package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntryInfoDe {
	private Long id;
	private String name;
	private String date;
	private String phonenumber;
	private String money;
}
