package com.dao;

import com.entity.XianshangmianshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XianshangmianshiVO;
import com.entity.view.XianshangmianshiView;


/**
 * 线上面试
 * 
 * @author 
 * @email 
 * @date 2021-01-04 10:02:53
 */
public interface XianshangmianshiDao extends BaseMapper<XianshangmianshiEntity> {
	
	List<XianshangmianshiVO> selectListVO(@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);
	
	XianshangmianshiVO selectVO(@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);
	
	List<XianshangmianshiView> selectListView(@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);

	List<XianshangmianshiView> selectListView(Pagination page,@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);
	
	XianshangmianshiView selectView(@Param("ew") Wrapper<XianshangmianshiEntity> wrapper);
	
}
