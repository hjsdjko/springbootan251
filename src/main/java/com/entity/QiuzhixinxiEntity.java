package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 求职信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@TableName("qiuzhixinxi")
public class QiuzhixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QiuzhixinxiEntity() {
		
	}
	
	public QiuzhixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 求职标题
	 */
					
	private String qiuzhibiaoti;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 期望职位
	 */
					
	private String qiwangzhiwei;
	
	/**
	 * 期望行业
	 */
					
	private String qiwangxingye;
	
	/**
	 * 工作城市
	 */
					
	private String gongzuochengshi;
	
	/**
	 * 薪资要求
	 */
					
	private String xinziyaoqiu;
	
	/**
	 * 求职内容
	 */
					
	private String qiuzhineirong;
	
	/**
	 * 用户名
	 */
					
	private String yonghuming;
	
	/**
	 * 邮箱
	 */
					
	private String youxiang;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：求职标题
	 */
	public void setQiuzhibiaoti(String qiuzhibiaoti) {
		this.qiuzhibiaoti = qiuzhibiaoti;
	}
	/**
	 * 获取：求职标题
	 */
	public String getQiuzhibiaoti() {
		return qiuzhibiaoti;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：期望职位
	 */
	public void setQiwangzhiwei(String qiwangzhiwei) {
		this.qiwangzhiwei = qiwangzhiwei;
	}
	/**
	 * 获取：期望职位
	 */
	public String getQiwangzhiwei() {
		return qiwangzhiwei;
	}
	/**
	 * 设置：期望行业
	 */
	public void setQiwangxingye(String qiwangxingye) {
		this.qiwangxingye = qiwangxingye;
	}
	/**
	 * 获取：期望行业
	 */
	public String getQiwangxingye() {
		return qiwangxingye;
	}
	/**
	 * 设置：工作城市
	 */
	public void setGongzuochengshi(String gongzuochengshi) {
		this.gongzuochengshi = gongzuochengshi;
	}
	/**
	 * 获取：工作城市
	 */
	public String getGongzuochengshi() {
		return gongzuochengshi;
	}
	/**
	 * 设置：薪资要求
	 */
	public void setXinziyaoqiu(String xinziyaoqiu) {
		this.xinziyaoqiu = xinziyaoqiu;
	}
	/**
	 * 获取：薪资要求
	 */
	public String getXinziyaoqiu() {
		return xinziyaoqiu;
	}
	/**
	 * 设置：求职内容
	 */
	public void setQiuzhineirong(String qiuzhineirong) {
		this.qiuzhineirong = qiuzhineirong;
	}
	/**
	 * 获取：求职内容
	 */
	public String getQiuzhineirong() {
		return qiuzhineirong;
	}
	/**
	 * 设置：用户名
	 */
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
	/**
	 * 设置：邮箱
	 */
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	/**
	 * 获取：邮箱
	 */
	public String getYouxiang() {
		return youxiang;
	}

}
