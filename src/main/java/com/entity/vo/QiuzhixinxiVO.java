package com.entity.vo;

import com.entity.QiuzhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 求职信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public class QiuzhixinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
