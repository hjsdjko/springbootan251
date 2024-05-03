package com.entity.view;

import com.entity.DiscussqiuzhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 求职信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@TableName("discussqiuzhixinxi")
public class DiscussqiuzhixinxiView  extends DiscussqiuzhixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussqiuzhixinxiView(){
	}
 
 	public DiscussqiuzhixinxiView(DiscussqiuzhixinxiEntity discussqiuzhixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussqiuzhixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
