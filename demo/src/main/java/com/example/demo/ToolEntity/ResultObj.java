package com.example.demo.ToolEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultObj {
	//200正常，-1及其他错误
	private int code;
	private String msg; 
}
