package com.entity.view;

import com.entity.XianshangmianshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 线上面试
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@TableName("xianshangmianshi")
public class XianshangmianshiView  extends XianshangmianshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianshangmianshiView(){
	}
 
 	public XianshangmianshiView(XianshangmianshiEntity xianshangmianshiEntity){
 	try {
			BeanUtils.copyProperties(this, xianshangmianshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
