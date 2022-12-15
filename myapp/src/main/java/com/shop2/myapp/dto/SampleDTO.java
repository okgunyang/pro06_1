package com.shop2.myapp.dto;

public class SampleDTO {
	private String id;
	private String pw;
	private long vcnt;
	
	public SampleDTO() { }
	
	public SampleDTO(String id, String pw, long vcnt) {
		this.id = id;
		this.pw = pw;
		this.vcnt = vcnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public long getVcnt() {
		return vcnt;
	}
	public void setVcnt(long vcnt) {
		this.vcnt = vcnt;
	}

	@Override
	public String toString() {
		return "SampleDTO [id=" + id + ", pw=" + pw + ", vcnt=" + vcnt + "]";
	}
}
