package com.example.demo.ToolEntity;

import lombok.Data;

@Data
public class PageLimit {
	//显示条数
	private int limit; 
	//当前页
	private int page;
}
