package com.entity.view;

import com.entity.DiscusszhaopingangweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招聘岗位评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@TableName("discusszhaopingangwei")
public class DiscusszhaopingangweiView  extends DiscusszhaopingangweiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhaopingangweiView(){
	}
 
 	public DiscusszhaopingangweiView(DiscusszhaopingangweiEntity discusszhaopingangweiEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhaopingangweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
