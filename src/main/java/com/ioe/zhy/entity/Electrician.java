/**
 * 
 */
package com.ioe.zhy.entity;

import java.util.Date;

/**
 * @author hq
 *
 */
public class Electrician {
	private String electrician_id;      //电工信息id
	private String network_licence;      //进网作业许可证
	private String special_certificate;    //特种作业操作证
	private String professional_credential;  //职业资格证书
	private String area_id;                //服务区域id
	private String area_name;              //服务区域名称
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	private String account_id;           //对应Account的Id
	private String employee_id;           //雇员表
	private boolean sys_record_status;         //是否删除
	private Date sys_last_modified_time;    //最后一次修改时间
	private String sys_hash;
	private Date  sys_create_time;           //添加时间
	public String getElectrician_id() {
		return electrician_id;
	}
	public void setElectrician_id(String electrician_id) {
		this.electrician_id = electrician_id;
	}
	public String getNetwork_licence() {
		return network_licence;
	}
	public void setNetwork_licence(String network_licence) {
		this.network_licence = network_licence;
	}
	public String getSpecial_certificate() {
		return special_certificate;
	}
	public void setSpecial_certificate(String special_certificate) {
		this.special_certificate = special_certificate;
	}
	public String getProfessional_credential() {
		return professional_credential;
	}
	public void setProfessional_credential(String professional_credential) {
		this.professional_credential = professional_credential;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public Date getSys_last_modified_time() {
		return sys_last_modified_time;
	}
	public void setSys_last_modified_time(Date sys_last_modified_time) {
		this.sys_last_modified_time = sys_last_modified_time;
	}
	public String getSys_hash() {
		return sys_hash;
	}
	public void setSys_hash(String sys_hash) {
		this.sys_hash = sys_hash;
	}
	public Date getSys_create_time() {
		return sys_create_time;
	}
	public void setSys_create_time(Date sys_create_time) {
		this.sys_create_time = sys_create_time;
	}
	
	public boolean isSys_record_status() {
		return sys_record_status;
	}
	public void setSys_record_status(boolean sys_record_status) {
		this.sys_record_status = sys_record_status;
	}
	@Override
	public String toString() {
		return "Electrician [electrician_id=" + electrician_id + ", network_licence=" + network_licence
				+ ", special_certificate=" + special_certificate + ", professional_credential="
				+ professional_credential + ", area_id=" + area_id + ", area_name=" + area_name + ", account_id="
				+ account_id + ", employee_id=" + employee_id + ", sys_record_status=" + sys_record_status
				+ ", sys_last_modified_time=" + sys_last_modified_time + ", sys_hash=" + sys_hash + ", sys_create_time="
				+ sys_create_time + "]";
	}

	

}
