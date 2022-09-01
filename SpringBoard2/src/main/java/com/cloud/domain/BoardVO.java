package com.cloud.domain;


import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO implements Serializable {

	private static final long serialVersionUID = 10L;
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regDate;
	private int cnt;
}
