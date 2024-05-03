package com.entity.model;

import com.entity.GerenjianliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 个人简历
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public class GerenjianliModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 居住省份
	 */
	
	private String juzhushengfen;
		
	/**
	 * 居住城市
	 */
	
	private String juzhuchengshi;
		
	/**
	 * 出生年月
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date chushengnianyue;
		
	/**
	 * 工作时间
	 */
	
	private String gongzuoshijian;
		
	/**
	 * 当前状态
	 */
	
	private String dangqianzhuangtai;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 专业
	 */
	
	private String zhuanye;
		
	/**
	 * 最高学历
	 */
	
	private String zuigaoxueli;
		
	/**
	 * 简历附件
	 */
	
	private String jianlifujian;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：居住省份
	 */
	 
	public void setJuzhushengfen(String juzhushengfen) {
		this.juzhushengfen = juzhushengfen;
	}
	
	/**
	 * 获取：居住省份
	 */
	public String getJuzhushengfen() {
		return juzhushengfen;
	}
				
	
	/**
	 * 设置：居住城市
	 */
	 
	public void setJuzhuchengshi(String juzhuchengshi) {
		this.juzhuchengshi = juzhuchengshi;
	}
	
	/**
	 * 获取：居住城市
	 */
	public String getJuzhuchengshi() {
		return juzhuchengshi;
	}
				
	
	/**
	 * 设置：出生年月
	 */
	 
	public void setChushengnianyue(Date chushengnianyue) {
		this.chushengnianyue = chushengnianyue;
	}
	
	/**
	 * 获取：出生年月
	 */
	public Date getChushengnianyue() {
		return chushengnianyue;
	}
				
	
	/**
	 * 设置：工作时间
	 */
	 
	public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
	}
	
	/**
	 * 获取：工作时间
	 */
	public String getGongzuoshijian() {
		return gongzuoshijian;
	}
				
	
	/**
	 * 设置：当前状态
	 */
	 
	public void setDangqianzhuangtai(String dangqianzhuangtai) {
		this.dangqianzhuangtai = dangqianzhuangtai;
	}
	
	/**
	 * 获取：当前状态
	 */
	public String getDangqianzhuangtai() {
		return dangqianzhuangtai;
	}
				
	
	/**
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
				
	
	/**
	 * 设置：专业
	 */
	 
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}
				
	
	/**
	 * 设置：最高学历
	 */
	 
	public void setZuigaoxueli(String zuigaoxueli) {
		this.zuigaoxueli = zuigaoxueli;
	}
	
	/**
	 * 获取：最高学历
	 */
	public String getZuigaoxueli() {
		return zuigaoxueli;
	}
				
	
	/**
	 * 设置：简历附件
	 */
	 
	public void setJianlifujian(String jianlifujian) {
		this.jianlifujian = jianlifujian;
	}
	
	/**
	 * 获取：简历附件
	 */
	public String getJianlifujian() {
		return jianlifujian;
	}
			
}
