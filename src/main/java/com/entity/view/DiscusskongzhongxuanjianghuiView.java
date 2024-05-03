package com.entity.view;

import com.entity.DiscusskongzhongxuanjianghuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 空中宣讲会评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
@TableName("discusskongzhongxuanjianghui")
public class DiscusskongzhongxuanjianghuiView  extends DiscusskongzhongxuanjianghuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusskongzhongxuanjianghuiView(){
	}
 
 	public DiscusskongzhongxuanjianghuiView(DiscusskongzhongxuanjianghuiEntity discusskongzhongxuanjianghuiEntity){
 	try {
			BeanUtils.copyProperties(this, discusskongzhongxuanjianghuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
