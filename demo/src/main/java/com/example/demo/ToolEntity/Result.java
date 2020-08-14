package com.example.demo.ToolEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
	//模板规定状态值正常为0
	private int code;
	//获取总条数
	private int count;
	private String mgs;
	private T data;
}
