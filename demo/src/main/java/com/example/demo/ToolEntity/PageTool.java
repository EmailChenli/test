package com.example.demo.ToolEntity;

import java.util.List;

import lombok.Data;

@Data
public class PageTool<T> {
	private Integer currentpage = 1; // 当前页，初始值也为第一页
	private Integer firstPage = 1;// 首页为第一页
	private Integer prePage; // 上一页
	private Integer nextPage; // 下一页
	private Integer lastPage; // 最后一页
	private Integer totalPage; // 总页数
	private Integer totalData; // 总数据
	private Integer pageSize; // 
	private List<T> list; // list集合用来装查出的数据

}
