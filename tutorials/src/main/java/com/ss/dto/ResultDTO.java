package com.ss.dto;

public class ResultDTO {

    private long reult_id;
    private long timestamp;
    private int total;
    private int status;
    private int sub_id;
    private int user_id;
    private String code;
    private boolean is_verified;
    private boolean is_qualified;
    private float percent;
    private int attempt;
    
	public long getReult_id() {
		return reult_id;
	}
	public void setReult_id(long reult_id) {
		this.reult_id = reult_id;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isIs_verified() {
		return is_verified;
	}
	public void setIs_verified(boolean is_verified) {
		this.is_verified = is_verified;
	}
	public boolean isIs_qualified() {
		return is_qualified;
	}
	public void setIs_qualified(boolean is_qualified) {
		this.is_qualified = is_qualified;
	}
	public float getPercent() {
		return percent;
	}
	public void setPercent(float percent) {
		this.percent = percent;
	}
	
	public int getAttempt() {
		return attempt;
	}
	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}
	public ResultDTO(){
		
	}
	@Override
	public String toString() {
		return "ResultDTO [reult_id=" + reult_id + ", timestamp=" + timestamp
				+ ", total=" + total + ", status=" + status + ", sub_id="
				+ sub_id + ", user_id=" + user_id + ", code=" + code
				+ ", is_verified=" + is_verified + ", is_qualified="
				+ is_qualified + ", percent=" + percent + ", attempt="
				+ attempt + "]";
	}
	
	
    
    
    
    
}
