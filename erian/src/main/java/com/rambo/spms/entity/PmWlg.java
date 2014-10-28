/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.rambo.spms.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rambo.erian.entity.IdEntity;

import java.util.*;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */


@Entity
@Table(name = "pm_wlg")
public class PmWlg extends IdEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	

	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	
	@NotNull 
	private java.util.Date dateTime;
	@NotNull 
	private java.lang.Float realPower;
	@NotNull 
	private java.lang.Float reactivePower;
	@NotNull 
	private java.lang.Float apparentPower;
	@NotNull 
	private java.lang.Float energy;
//	@NotNull 
	private java.lang.Float frequency;
//	@NotNull 
	private java.lang.Float powerFactor;
//	@NotNull 
	private java.lang.Integer pmnum;
	//columns END


	public PmWlg(){
	}


	
	// 设定JSON序列化时的日期格式
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public java.util.Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(java.util.Date dateTime) {
		this.dateTime = dateTime;
	}


	public java.lang.Float getRealPower() {
		return realPower;
	}


	public void setRealPower(java.lang.Float realPower) {
		this.realPower = realPower;
	}


	public java.lang.Float getReactivePower() {
		return reactivePower;
	}


	public void setReactivePower(java.lang.Float reactivePower) {
		this.reactivePower = reactivePower;
	}


	public java.lang.Float getApparentPower() {
		return apparentPower;
	}


	public void setApparentPower(java.lang.Float apparentPower) {
		this.apparentPower = apparentPower;
	}


	public java.lang.Float getEnergy() {
		return energy;
	}


	public void setEnergy(java.lang.Float energy) {
		this.energy = energy;
	}


	public java.lang.Float getFrequency() {
		return frequency;
	}


	public void setFrequency(java.lang.Float frequency) {
		this.frequency = frequency;
	}


	public java.lang.Float getPowerFactor() {
		return powerFactor;
	}


	public void setPowerFactor(java.lang.Float powerFactor) {
		this.powerFactor = powerFactor;
	}

	@Column(name = "PM_Num", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getPmnum() {
		return pmnum;
	}


	public void setPmnum(java.lang.Integer pmnum) {
		this.pmnum = pmnum;
	}

	
	

}

